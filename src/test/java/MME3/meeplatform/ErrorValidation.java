package MME3.meeplatform;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MME.meeplatform.TestComponents.Retry;
import MME3.meeplatform.pageobjects.CheckoutPage;
import MME3.meeplatform.pageobjects.ConfirmmationPage;
import MME3.meeplatform.pageobjects.LandingPage;
import MME3.meeplatform.pageobjects.ProductCatalogue;
import MME3.meeplatform.pageobjects.cartPage;

public class ErrorValidation extends BaseTest {

	@Test(groups = { "Smoke" }, retryAnalyzer = Retry.class)
	public void loginError() throws Throwable {

		String ProductName = "ZARA COAT 3";
		LandingPage landingpage = launchApplication();
		landingpage.loginApplication("pratikshag3@gmial.com", "Password@12345");
		Assert.assertEquals(landingpage.getErrorMessage(), "Incorrect email or password.");
	}

	@Test
	public void productErrorValidation() throws Throwable {
		String ProductName = "ZARA COAT 3";

		ProductCatalogue productcatalogue = landingpage.loginApplication("advik14@gmail.com", "Password1234@");

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProdToCart(ProductName);

		cartPage cartpage = productcatalogue.goToCartPage();

		Boolean match = cartpage.verifyProductDisplay(ProductName);
		Assert.assertTrue(match);
	}
}
