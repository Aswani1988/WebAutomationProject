package SwagLabs.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractComponents.AbstractComponents;

public class ProductcataloguePage extends AbstractComponents {

	WebDriver driver;

	public ProductcataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='inventory_item']")
	List<WebElement> productList;

	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	WebElement cartButton;

	By productnameToSelect = By.cssSelector("div[class='inventory_item_name ']");
	By addToCartButton = By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']");

	public WebElement getProduct(String productName) {
		waitForElementstoAppear(productList);
		WebElement producttoCart = productList.stream()
				.filter(product -> product.findElement(productnameToSelect).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return producttoCart;
	}

	public void clickAddToCart(String productName) {
		getProduct(productName).findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']"))
				.click();
	}

	public CartPage clickCartButton() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
}
