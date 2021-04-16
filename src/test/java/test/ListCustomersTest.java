package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashBoardPage1;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomersTest {

	WebDriver driver;
	
	String Username = null;
	String Password = null;
	String fullName = null;
	String company = null;
	String email = null;
	String phone = null;
	String address = null;
	String city = null;
	String state = null;
	String zipcode = null;

	@Test
	public void login() {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(Username);
		login.enterPassword(Password);
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

		
		ListCustomersPage listCustomers = PageFactory.initElements(driver, ListCustomersPage.class);
		listCustomers.clickOnListCustomersButton();
		listCustomers.enteredNameAndDelete();
		
	}

}
