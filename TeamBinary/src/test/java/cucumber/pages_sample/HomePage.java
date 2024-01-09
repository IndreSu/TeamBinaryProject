package cucumber.pages_sample;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static cucumber.stepDefinitions.Hooks.driver;

public class HomePage {

    @FindBy(how = How.XPATH, using = "/html/body")
    private WebElement home;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[1]/a/i")
    private WebElement contactUsLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement myAccountLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/a")
    private WebElement registrationLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    private WebElement loginLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"wishlist-total\"]")
    private WebElement wishListLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[4]/a")
    private WebElement shoppingCartLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"top-links\"]/ul/li[5]/a")
    private WebElement checkoutLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[4]/a")
    private WebElement tabletsLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
    private WebElement desktopsLink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")
    private WebElement macLink;
    @FindBy(how = How.ID, using = "search")
    private WebElement searchField;

    private final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToContactUs(){
        wait.until(ExpectedConditions.visibilityOf(contactUsLink)).click();
    }

    public void navigateToRegistration(){
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).perform();
        wait.until(ExpectedConditions.visibilityOf(registrationLink)).click();
    }

    public void navigateToLogin() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountLink).perform();
        wait.until(ExpectedConditions.visibilityOf(loginLink)).click();
    }

    public void navigateToWishList(){
        wait.until(ExpectedConditions.visibilityOf(wishListLink)).click();
    }

    public void navigateToShoppingCart() {
        wait.until(ExpectedConditions.visibilityOf(shoppingCartLink)).click();
    }

    public void navigateToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(checkoutLink)).click();
    }

    public void navigateToTablets() {
        wait.until(ExpectedConditions.visibilityOf(tabletsLink)).click();
    }

    public void navigateToDesktopsMac() {
        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsLink).perform();
        wait.until(ExpectedConditions.visibilityOf(macLink)).click();
    }

    public WebElement getSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return searchField;
    }
}
