package MME3.meeplatform.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MME3.meeplatform.AbsrtactComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By productsBy = By.cssSelector(".mb-3");
	By prodBy = By.cssSelector("b");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By ToastMessage = By.cssSelector("#toast-container");

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return products;

	}

	public WebElement getProductByName(String ProductName) {

		WebElement prod = products.stream()
				.filter(product -> product.findElement(prodBy).getText().contains(ProductName)).findFirst()
				.orElse(null);

		return prod;

	}

	public void addProdToCart(String ProductName) throws InterruptedException {

		getProductByName(ProductName).findElement(addToCart).click();

		waitForElementToAppear(ToastMessage);
		
		waitForElementToDisappear(spinner);
	}
}
