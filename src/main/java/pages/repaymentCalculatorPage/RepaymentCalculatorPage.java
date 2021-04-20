package pages.repaymentCalculatorPage;

import helper.UtilityFunction;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageObject;

public class RepaymentCalculatorPage extends PageObject {
    public RepaymentCalculatorPage(WebDriver driver){
        super(driver);
    }
    UtilityFunction uf = new UtilityFunction();


    By repaymentTab = By.xpath("//a[@id='repayments-link']");
    By amountBy =By.id("amount");
    By repaymentTypeBy =By.id("interestOnly");
    By calculateButton =By.id("submit");
    By repaymentAmtBy = By.xpath("//span[@data-tid='total-repayment']");
    By interestAmountBy = By.xpath("//span[@data-tid='total-interest']");
    By overBy = By.id("term");

    public void fillRepaymentDetails(String amount,String over, String repaymentType){
        uf.waitUntilElementVisible(repaymentTab,5,driver);
        getElement(amountBy).clear();
        getElement(amountBy).sendKeys(amount);
        getElement(overBy).sendKeys(over);
        uf.selectFromDropDown(driver.findElement(repaymentTypeBy),repaymentType);
    }

    public void clickCalculateButton(){
        if(getElement(calculateButton).isDisplayed()){
            uf.clickButton(getElement(calculateButton));
        }
    }

    public Boolean validateRepaymentAndInterestAmount(String repaymentAmt,String InterestAmt){
        String actRepaymentAmnt = driver.findElement(repaymentAmtBy).getText().trim();
        String actInterestAmt =driver.findElement(interestAmountBy).getText().trim();
        if(repaymentAmt.equalsIgnoreCase(actRepaymentAmnt)&&actInterestAmt.equalsIgnoreCase(InterestAmt)){
            return true;
        }
        return false;
    }


}
