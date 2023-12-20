package SwagLabs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SwagLabs.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='First Name']")
	WebElement firstname;

	@FindBy(css = "input[name='lastName']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postcode;

	@FindBy(css = "#continue")
	WebElement continueButton;

	public PaymentPage enterDetails(String firstName, String LastName, String PostCode) {
		firstname.sendKeys(firstName);
		lastname.sendKeys(LastName);
		postcode.sendKeys(PostCode);
		continueButton.click();
		PaymentPage paymentPage = new PaymentPage(driver);
		return paymentPage;

	}

}
