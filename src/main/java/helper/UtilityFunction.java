package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class UtilityFunction {

    public final Logger logger = Logger.getLogger(this.getClass().getName());
    public void waitUntilElementVisible(By element, long seconds, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void clickLink(WebElement element){
        try{
            element.click();
        }catch(NoSuchElementException e){
            logger.severe("Error while clicking link "+e.getMessage());
        }
    }
    public void selectFromDropDown(WebElement element,String input){
        try{
            Select select = new Select(element);
            select.selectByVisibleText(input);
        }catch(Exception e){
            logger.severe("Error while selecting element "+e.getMessage());
        }
    }
    public void clickButton(WebElement element){
        try{
            element.click();
        }catch(NoSuchElementException e){
            logger.severe("Error while clicking button "+e.getMessage());
        }
    }

}
