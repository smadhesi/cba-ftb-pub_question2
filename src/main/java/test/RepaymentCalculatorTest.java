package test;

import helper.BrowserDriverFactory;
import helper.Properties;
import helper.UtilityFunction;
import home.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.repaymentCalculatorPage.RepaymentCalculatorPage;
import resources.Resources;

import java.util.Arrays;
import java.util.List;

public class RepaymentCalculatorTest {
    WebDriver driver;
    Resources resources;
    RepaymentCalculatorPage repaymentCalculatorPage;
    HomePage homePage;
    @BeforeEach
    public void init(){
        this.driver = BrowserDriverFactory.getDriver("Repayment");
        resources = Properties.getResource();
        repaymentCalculatorPage = new RepaymentCalculatorPage(driver);
        homePage = new HomePage(driver);
        String url = resources.getUrl();
        if(url==null||url==""){
            driver.close();
        }else{
            driver.navigate().to(url);
        }
    }
    @Test
    public void calculateLoanRepaymentAmount(){
        List<Resources.RepaymentCalculator> repaymentCalculators = resources.getRepaymentCalculator();
        homePage.clickRepaymentLink();
        for(Resources.RepaymentCalculator repaymentCalculator:repaymentCalculators){
            repaymentCalculatorPage.fillRepaymentDetails(repaymentCalculator.getAmount(),repaymentCalculator.getOver(),repaymentCalculator.getRepaymentType());
            repaymentCalculatorPage.clickCalculateButton();
            Assertions.assertTrue(repaymentCalculatorPage.validateRepaymentAndInterestAmount(repaymentCalculator.getRepaymentAmt(),repaymentCalculator.getInterestAmt()));
        }

    }
    @AfterEach
    public void tearDown(){
        BrowserDriverFactory.closeDriver("Repayment");
    }
}
