package SwagLabs.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import SwagLabs.AbstractComponents.AbstractComponents;

@Test
public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginbutton;
	
	@FindBy(xpath="//div//h3")
	WebElement loginErrormessage;

	public ProductcataloguePage loginToApplication(String user_name, String pass_word) {
		username.sendKeys(user_name);
		password.sendKeys(pass_word);
		loginbutton.click();
		ProductcataloguePage productcataloguePage = new ProductcataloguePage(driver);
		return productcataloguePage;

	}
	
	@Test
	public void gotTo() {
		driver.get("https://www.saucedemo.com/");
	}
	
	public String loginErrorMessage() {
		waitForElementtoAppear(loginErrormessage);
		return loginErrormessage.getText();
	}

	

}
