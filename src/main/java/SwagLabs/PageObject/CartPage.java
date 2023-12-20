package SwagLabs.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cart_item")
	List<WebElement> cartItems;

	@FindBy(id = "checkout")
	WebElement checkoutbutton;

	public Boolean getCartPageProductList(String productName) {

		Boolean matchcartPage = cartItems.stream()
				.anyMatch(pr -> pr.findElement(By.cssSelector("div[class='inventory_item_name']")).getText()
						.equalsIgnoreCase(productName));
		return matchcartPage;
	}

	public CheckoutPage clickCheckoutButton() {
		checkoutbutton.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
