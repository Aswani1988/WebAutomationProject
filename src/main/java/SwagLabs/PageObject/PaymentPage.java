package SwagLabs.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class='cart_item']")
	List<WebElement> cartList;

	@FindBy(css = "button[id='finish']")
	WebElement finishButton;

	By cartproduct = By.cssSelector("div[class='inventory_item_name']");

	public Boolean getCartList(String productName) {

		Boolean matchPaymentPage = cartList.stream()
				.anyMatch(pr1 -> pr1.findElement(cartproduct).getText().equalsIgnoreCase(productName));
		return matchPaymentPage;
	}

	public ConfirmationPage clickFinishButton() {
		finishButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;

	}

}
