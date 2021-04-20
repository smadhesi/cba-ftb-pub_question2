package home;

import helper.UtilityFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PageObject;

public class HomePage extends PageObject {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    UtilityFunction uf = new UtilityFunction();

    By repaymentLink = By.linkText("Repayments calculator");

    public void clickRepaymentLink() {
        uf.clickLink(driver.findElement(repaymentLink));
    }
}
