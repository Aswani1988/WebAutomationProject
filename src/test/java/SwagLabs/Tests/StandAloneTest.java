package SwagLabs.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class StandAloneTest {
	@Test
	public void BuyProductTest() {

		String productName = "Sauce Labs Bolt T-Shirt";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> productList = driver.findElements(By.cssSelector("div[class='inventory_item']"));

		WebElement producttoCart = productList.stream()
				.filter(product -> product.findElement(By.cssSelector("div[class='inventory_item_name ']")).getText()
						.equalsIgnoreCase(productName))
				.findFirst().orElse(null);

		producttoCart.findElement(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory ']")).click();

		driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

		List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item"));
		Boolean matchcartPage = cartItems.stream()
				.anyMatch(pr -> pr.findElement(By.cssSelector("div[class='inventory_item_name']")).getText()
						.equalsIgnoreCase(productName));
		Assert.assertTrue(matchcartPage);

		driver.findElement(By.id("checkout")).click();

		driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Aswani");
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Kishore");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("HA61TL");
		driver.findElement(By.cssSelector("#continue")).click();

		List<WebElement> cartList = driver.findElements(By.cssSelector("div[class='cart_item']"));

		Boolean matchPaymentPage = cartList.stream()
				.anyMatch(pr1 -> pr1.findElement(By.cssSelector("div[class='inventory_item_name']")).getText()
						.equalsIgnoreCase(productName));

		Assert.assertTrue(matchPaymentPage);
		driver.findElement(By.cssSelector("button[id='finish']")).click();
		String confirmationMessage = driver.findElement(By.xpath("//div/h2")).getText();
		AssertJUnit.assertEquals(confirmationMessage, "Thank you for your order!");
		driver.findElement(By.id("back-to-products")).click();
	}

}
