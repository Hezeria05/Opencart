package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

//Constructor
    public HomePage(WebDriver driver) {
        super(driver); //BasePage
    }
    
//Locators
    @FindBy(xpath="//a[@title='My Account']")
    WebElement lnkMyaccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement lnkRegister;
    
    @FindBy(xpath="//a[normalize-space()='Login']")
    WebElement lnkLogin;
    
 //Action Methods
    public void clickMyAccount() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.elementToBeClickable(lnkMyaccount))
//            .click();
    	lnkMyaccount.click();
    	}

    public void clickRegister() {
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//            .until(ExpectedConditions.elementToBeClickable(lnkRegister))
//            .click();
    	lnkRegister.click();
    }
    
    public void clickLogin() {
    	lnkLogin.click();
    }
}
