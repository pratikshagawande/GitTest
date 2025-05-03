package MME3.meeplatform.AbsrtactComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MME3.meeplatform.pageobjects.cartPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartheader;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {

		Thread.sleep(5);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public cartPage goToCartPage() throws InterruptedException {

		// cartheader.click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cartPage cartpage = new cartPage(driver);
		return cartpage;
	}
}
