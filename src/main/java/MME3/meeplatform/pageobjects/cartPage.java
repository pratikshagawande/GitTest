package MME3.meeplatform.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MME3.meeplatform.AbsrtactComponents.AbstractComponents;

public class cartPage extends AbstractComponents {
	WebDriver driver;

	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOut;

	public Boolean verifyProductDisplay(String ProductName) {

		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
		
		return match;
		
	}
	
	public CheckoutPage checkoutPage() {
		
		checkOut.click();
		return new CheckoutPage(driver);
	}

}
