package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.Bank_Cash_Page;
import page.DashBoardPage2;
import page.LoginPage;
import util.BrowserFactory;

public class BankAndCashTest {

	WebDriver driver;

	@Test
	@Parameters({ "username", "password", "accountTittle", "description", "initialBalance", "accountNumber", "contactParson","phone" })
	public void validUserShouldAbleToAddNewAccount(String Username, String Password, String AccountTittle, String Description,
			String InitialBalance, String AccountNumber, String ContactParson,String Phone) {
		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.enterUserName(Username);
		login.enterPassword(Password);
		login.clickSigninButton();

		DashBoardPage2 dashboard = PageFactory.initElements(driver, DashBoardPage2.class);
		dashboard.validateDashboardHeader();
		dashboard.clickOnBankAndCashButton();
		dashboard.clickOnNewAccountButton();

		Bank_Cash_Page bankcash = PageFactory.initElements(driver, Bank_Cash_Page.class);
		bankcash.insertAccountField(AccountTittle);
		bankcash.insertDescriptionField(Description);
		bankcash.insertBalanceField(InitialBalance);
		bankcash.insertAccNumberField(AccountNumber);
		bankcash.insertConParsonField(ContactParson);
		bankcash.insertConPhoneField(Phone);
		bankcash.clickSubmitButton();
		bankcash.validatedAccountCreatedSuccessfully();

	}
}