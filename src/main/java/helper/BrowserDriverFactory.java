package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import resources.Resources;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserDriverFactory {
    private static Resources resources;
    private static Map<String, WebDriver> driverMap = new HashMap<>();
    private static String driverPath;
    static{
        resources = Properties.getResource();
        URL url = Thread.currentThread().getContextClassLoader().getResource(resources.getChromeDriver());
        driverPath = url.getPath();
        driverMap.clear();
    }

    public synchronized static WebDriver getDriver(String module){
        if(!driverMap.containsKey(module)){
            WebDriver driver = null;
            try{
                System.setProperty("webdriver.chrome.driver",driverPath);
                Map<String,Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups",0);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs",chromePrefs);
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("ignore-certificate-errors");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }catch(Exception e){
                e.printStackTrace();
            }
            driverMap.put(module,driver);
        }
        return driverMap.get(module);
    }

    public synchronized static void closeDriver(String module){
        WebDriver driver = driverMap.get(module);
        driver.close();
    }
}
