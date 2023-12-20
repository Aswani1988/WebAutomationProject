package SwagLabs.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import SwagLabs.PageObject.CartPage;
import SwagLabs.PageObject.CheckoutPage;
import SwagLabs.PageObject.ConfirmationPage;
import SwagLabs.PageObject.LoginPage;
import SwagLabs.PageObject.PaymentPage;
import SwagLabs.PageObject.ProductcataloguePage;
import SwagLabs.TestComponents.BaseTest;

public class ErrorvalidationTest extends BaseTest {
	String productName = "Sauce Labs Bolt T-Shirt";

	@Test(groups="ErrorValidation")
	public void loginErrorvalidation() throws IOException {

		LoginPage loginPage = launchApplication();
		ProductcataloguePage productcataloguePage = loginPage.loginToApplication("standard_user1", "secret_sauce2");
		Assert.assertEquals(loginPage.loginErrorMessage(),
				"Epic sadface: Username and password do not_ match any user in this service");
	}

	@Test
	public void cartPageErrorValidation() throws IOException {
		LoginPage loginPage = launchApplication();
		ProductcataloguePage productcataloguePage = loginPage.loginToApplication("standard_user", "secret_sauce");
		productcataloguePage.clickAddToCart(productName);

		CartPage cartPage = productcataloguePage.clickCartButton();
		cartPage.getCartPageProductList(productName);
		Boolean matchcartPage = cartPage.getCartPageProductList(productName);
		Assert.assertTrue(matchcartPage);
	}

	@Test(groups="ErrorValidation")
	public void confirmationMessageValidation() throws IOException {

		LoginPage loginPage = launchApplication();
		ProductcataloguePage productcataloguePage = loginPage.loginToApplication("standard_user", "secret_sauce");
		productcataloguePage.clickAddToCart(productName);

		CartPage cartPage = productcataloguePage.clickCartButton();
		cartPage.getCartPageProductList(productName);
		Boolean matchcartPage = cartPage.getCartPageProductList(productName);
		Assert.assertTrue(matchcartPage);

		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

		PaymentPage paymentPage = checkoutPage.enterDetails("Aswani", "Kishore", "HA6778");
		Boolean matchPaymentPage = paymentPage.getCartList(productName);
		Assert.assertTrue(matchPaymentPage);

		ConfirmationPage confirmationPage = paymentPage.clickFinishButton();
		String confirmationMessage = confirmationPage.verifyConfirmationMessage();
		AssertJUnit.assertEquals(confirmationMessage, "Thank you for your order!");
		confirmationPage.clickHomeButton();
	}
}
