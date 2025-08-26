package testCases;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_LoginDDT extends BaseClass{
	@Test(groups="DataDriven", dataProvider="LoginData", dataProviderClass=DataProviders.class) //if data provider is on another package
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("******* Starting TC_003_LoginDDT *******");
		
		try {
//HomePage		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
//Login Page		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
//MyAccountPage		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage= macc.isMyAccountPageExists();	
		/*
		 Data is valid - login success -> TEST PASSED - logout
		 				 login fail -> TEST FAILED
		 Data is invalid - login success -> TEST FAILED - logout
						   login success -> TEST PASSED
		 */
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		else
			System.out.println("No Data Provided");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("******* Finished TC_003_LoginDDT *******");
		
		
	}

}
