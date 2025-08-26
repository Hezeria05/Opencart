package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

//Constructor
	 public AccountRegistrationPage(WebDriver driver) {
	        super(driver); //BasePage
	    }

//Locators
@FindBy(xpath = "//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath = "//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath = "//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath = "//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="(//input[@id='input-confirm'])[1]")
WebElement txtCPassword;

@FindBy(xpath = "//input[@name='agree']")
WebElement chkdPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

//Actions
public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);
	}

public void setLastName(String lname) {
	txtLastname.sendKeys(lname);
	}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
	}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
	}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
	}

public void setConfirmPassword(String pwd) {
	txtCPassword.sendKeys(pwd);
	}

public void setPrivacyPolicy() {
	//chkdPolicy.click();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", chkdPolicy);
	}

public void clickContinue() {
	//sol1
	//btnContinue.click();
	
	//sol2
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
	
	//sol4
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", btnContinue);
	
	//sol5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//sol6
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.OfSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
}
}
