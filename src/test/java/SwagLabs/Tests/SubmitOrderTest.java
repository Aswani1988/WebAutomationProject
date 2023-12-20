package SwagLabs.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SwagLabs.PageObject.CartPage;
import SwagLabs.PageObject.CheckoutPage;
import SwagLabs.PageObject.ConfirmationPage;
import SwagLabs.PageObject.LoginPage;
import SwagLabs.PageObject.PaymentPage;
import SwagLabs.PageObject.ProductcataloguePage;
import SwagLabs.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void BuyProductTest(HashMap<String, String> input) throws InterruptedException, IOException {

		// String productName = "Sauce Labs Bolt T-Shirt";

		LoginPage loginPage = launchApplication();
		ProductcataloguePage productcataloguePage = loginPage.loginToApplication(input.get("username"),
				input.get("password"));
		productcataloguePage.clickAddToCart(input.get("productname"));

		CartPage cartPage = productcataloguePage.clickCartButton();
		cartPage.getCartPageProductList(input.get("productname"));
		Boolean matchcartPage = cartPage.getCartPageProductList(input.get("productname"));
		Assert.assertTrue(matchcartPage);

		CheckoutPage checkoutPage = cartPage.clickCheckoutButton();

		PaymentPage paymentPage = checkoutPage.enterDetails("Aswani", "Kishore", "HA6778");
		Boolean matchPaymentPage = paymentPage.getCartList(input.get("productname"));
		Assert.assertTrue(matchPaymentPage);

		ConfirmationPage confirmationPage = paymentPage.clickFinishButton();
		String confirmationMessage = confirmationPage.verifyConfirmationMessage();
		AssertJUnit.assertEquals(confirmationMessage, "Thank you for your order!");
		confirmationPage.clickHomeButton();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsondataToMap(
				System.getProperty("user.dir") + "//src//test//java//SwagLabs//data//UserName_Password.json");
		return new Object[][] { { data.get(0) } };

	}
	
	

}
