package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashBoardPage2;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	
	@Test
	@Parameters({"Username", "Password"})
	public void validUserShouldAbleToLogIn(String Username , String Password) {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(Username);
		login.enterPassword(Password);
		login.clickSigninButton();

		DashBoardPage2 dashboard = PageFactory.initElements(driver, DashBoardPage2.class);
		dashboard.validateDashboardHeader();

		BrowserFactory.tearDown();
		
	}

}
