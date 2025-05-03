package MME3.meeplatform.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MME3.meeplatform.AbsrtactComponents.AbstractComponents;

public class ConfirmmationPage extends AbstractComponents{
	WebDriver driver;

	public ConfirmmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement successmessage;

	public String getConfirmationmessage() {
		return successmessage.getText();
	}
}
