package MME3.meeplatform;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

import MME3.meeplatform.BaseTest;
import MME3.meeplatform.pageobjects.CheckoutPage;
import MME3.meeplatform.pageobjects.ConfirmmationPage;
import MME3.meeplatform.pageobjects.LandingPage;
import MME3.meeplatform.pageobjects.ProductCatalogue;
import MME3.meeplatform.pageobjects.cartPage;

public class SubmitOrderTest extends BaseTest{

	@Test(dataProvider ="getData",groups= {"Smoke"})
	public void submitOrder(String username,String password) throws Throwable {

	String ProductName = "ZARA COAT 3";
		LandingPage landingpage=launchApplication();
		ProductCatalogue productcatalogue = landingpage.loginApplication(username, password);

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProdToCart(ProductName);

		cartPage cartpage = productcatalogue.goToCartPage();

		Boolean match = cartpage.verifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checoutpage = cartpage.checkoutPage();
		checoutpage.selectCountry("india");
		ConfirmmationPage page = checoutpage.submitOrder();
		String successmessage = page.getConfirmationmessage();
		Assert.assertTrue(successmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	

	}
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"pratikshag3@gmial.com","Password@1234"},{"rahul2808@gmail.com","Password@28"}};
	
	}
}
