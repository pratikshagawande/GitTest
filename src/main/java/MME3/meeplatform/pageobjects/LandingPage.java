package MME3.meeplatform.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MME3.meeplatform.AbsrtactComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(css = "#login")
	WebElement submit;
	
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String username, String password) {
		userEmail.sendKeys(username);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalogue =new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");	}
}
