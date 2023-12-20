package SwagLabs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/h2")
	WebElement message;

	@FindBy(id = "back-to-products")
	WebElement homeButton;

	public String verifyConfirmationMessage() {
		String confirmationMessage = message.getText();
		return confirmationMessage;

	}

	public void clickHomeButton() {
		homeButton.click();
		quitBrowser();
	}

}
