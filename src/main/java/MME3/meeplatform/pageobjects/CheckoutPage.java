package MME3.meeplatform.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MME3.meeplatform.AbsrtactComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement CountryName;

	By country = By.cssSelector(".ta-results");

	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][2]")
	WebElement selectIndia;

	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement submit;

	public void selectCountry(String name) {
		CountryName.sendKeys(name);
		waitForElementToAppear(country);
		selectIndia.click();
	}

	public ConfirmmationPage submitOrder() {
		submit.click();
		ConfirmmationPage page=	new ConfirmmationPage(driver);
		return page;
	}
}
