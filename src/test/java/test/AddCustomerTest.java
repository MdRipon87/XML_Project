package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage1;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {

	WebDriver driver;

	@Test
	@Parameters({ "Username", "Password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "State",
			"Zip" })
	public void validUserShouldAbleToAddCustomer(String username, String password, String fullName, String company,
			String email, String phone, String address, String city, String state, String zipcode) {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(username);
		login.enterPassword(password);
		login.clickSigninButton();

		DashBoardPage1 dashboard = PageFactory.initElements(driver, DashBoardPage1.class);
		dashboard.validateDashboardHeader();
		dashboard.clickOnCustomerButton();
		dashboard.clickOnAddCustomerButton();

		AddCustomerPage addCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomer.insertFullName(fullName);
		addCustomer.chooseCompanyNameField(company);
		addCustomer.insertEmailAddressField(email);
		addCustomer.insertPhoneNumberField(phone);
		addCustomer.insertAddressNameField(address);
		addCustomer.insertCityField(city);
		addCustomer.insertStateField(state);
		addCustomer.insertZicodeField(zipcode);
		addCustomer.clickOnSaveButtonLocator();

	}

}
