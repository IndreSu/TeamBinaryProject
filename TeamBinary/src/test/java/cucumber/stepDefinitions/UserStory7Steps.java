package cucumber.stepDefinitions;

import cucumber.pages_sample.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserStory7Steps {
    private WebDriver driver;
    private HomePage homePage;
    private ContactUsPage contactUsPage;
    private MyAccountRegisterPage myAccountRegisterPage;
    private MyAccountLoginPage myAccountLoginPage;
    private WishListPage wishListPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private TabletsPage tabletsPage;
    private DesktopsPage desktopsPage;
    private SearchPage searchPage;
    private SearchCriteriaPage searchCriteriaPage;

    public UserStory7Steps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(Hooks.driver, HomePage.class);
        contactUsPage = PageFactory.initElements(Hooks.driver, ContactUsPage.class);
        myAccountRegisterPage = PageFactory.initElements(Hooks.driver, MyAccountRegisterPage.class);
        myAccountLoginPage = PageFactory.initElements(Hooks.driver, MyAccountLoginPage.class);
        wishListPage = PageFactory.initElements(Hooks.driver, WishListPage.class);
        shoppingCartPage = PageFactory.initElements(Hooks.driver, ShoppingCartPage.class);
        checkoutPage = PageFactory.initElements(Hooks.driver, CheckoutPage.class);
        tabletsPage = PageFactory.initElements(Hooks.driver, TabletsPage.class);
        desktopsPage = PageFactory.initElements(Hooks.driver, DesktopsPage.class);
        searchPage = PageFactory.initElements(Hooks.driver, SearchPage.class);
        searchCriteriaPage = PageFactory.initElements(Hooks.driver, SearchCriteriaPage.class);
    }

    @Given("Application is launched")
    public void applicationIsLaunched() throws Throwable {
        driver.get("https://www.demoshop24.com/");
    }

    @When("I navigate to Contact Us page")
    public void iNavigateToContactUsPage() throws Throwable {
        homePage.navigateToContactUs();
    }

    @When("I navigate to MyAccount Register")
    public void iNavigateToMyAccountRegister() throws Throwable {
        homePage.navigateToRegistration();
    }

    @When("I navigate to MyAccount Login")
    public void iNavigateToMyAccountLogin() throws Throwable{
        homePage.navigateToLogin();
    }

    @When("I navigate to Wish List page")
    public void iNavigateToWishListPage() throws Throwable {
       homePage.navigateToWishList();
    }

    @When("I navigate to Shopping Cart page")
    public void iNavigateToShoppingCartPage() throws Throwable {
       homePage.navigateToShoppingCart();
    }

    @When("I navigate to Checkout page")
    public void iNavigateToCheckoutPage() throws Throwable {
       homePage.navigateToCheckout();
    }

    @When("I navigate to Tablets category by clicking on first level menu")
    public void iNavigateToTabletsCategoryByClickingOnFirstLevelMenu() throws Throwable {
        homePage.navigateToTablets();
    }

    @When("I navigate to Desktops Mac sub-category by clicking on second level menu")
    public void iNavigateToDesktopsMacSubCategoryByClickingOnSecondLevelMenu() throws Throwable {
        homePage.navigateToDesktopsMac();
    }

    @Then("Search is displayed on every page screen")
    public void searchIsDisplayedOnEveryPageScreen() throws Throwable {
        assertTrue("Search field is not displayed on the Contact Us page.", contactUsPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the My Account Register page.", myAccountRegisterPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the My Account Login page.", myAccountLoginPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the Wish List page.", wishListPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the Shopping Cart page.", shoppingCartPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the Checkout page.", checkoutPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the Tablets page.", tabletsPage.getSearchField().isDisplayed());
        assertTrue("Search field is not displayed on the Desktops Mac page.", desktopsPage.getSearchField().isDisplayed());
    }

    @When("I input the text {string} in the search field")
    public void iInputTheTextInTheSearchWindow(String inputText) throws Throwable{
        searchPage.enterTextInSearchField(inputText);
    }

    @And("I select search button")
    public void iSelectSearchButton() throws Throwable {
       searchPage.clickSearchButton();
    }

    @Then("I verify that result include items related to {string}")
    public void iVerifyThatResultIncludeItemsRelatedTo(String inputText) throws Throwable{
        assertTrue("There is no product that matches the search criteria.", searchPage.verifyResultsContainText(inputText));
    }

    @When("I input numbers {string} in the search field")
    public void iInputNumbersInTheSearchWindow(String inputNumbers) throws Throwable {
        searchPage.enterNumbersInSearchField(inputNumbers);
    }

    @Then("I verify that result include items related to numbers {string}")
    public void iVerifyThatResultIncludeItemsRelatedToNumbers(String inputNumbers) throws Throwable {
        assertTrue("There is no product that matches the search criteria.", searchPage.verifyResultContainNumbers(inputNumbers));
    }

    @When("I select search icon when search field is empty")
    public void iSelectSearchIconWhenSearchInputFieldIsEmpty() throws Throwable {
        searchPage.clickSearchButton();
    }

    @And("I select a checkbox: Search in product descriptions")
    public void iSelectACheckboxSearchInProductDescriptions() throws Throwable {
        searchCriteriaPage.clickCheckboxInProductDescriptions();
    }

    @And("I select blue search button")
    public void iSelectBlueSearchButton() throws Throwable {
        searchCriteriaPage.clickBlueSearchButton();
    }

    @Then("I verify that no result related to {string} is found")
    public void iVerifyThatNoResultRelatedToIsFound(String inputText) throws Throwable {
        assertTrue(searchPage.verifyResultsContainText(inputText));
    }

    @Then("I verify that correct message is displayed")
    public void iVerifyThatCorrectMessageIsDisplayed()throws Throwable {
        searchPage.showMessage();
    }

    @And("I input the text {string} in the search criteria field")
    public void iInputTheTextInTheSearchCriteriaField(String inputText) throws Throwable {
        searchCriteriaPage.enterTextInSearchCriteriaField(inputText);
    }

    @And("I select {string} category")
    public void iSelectCategory(String categoryName)throws Throwable {
        searchCriteriaPage.selectCategoryDropdown(categoryName);
    }

    @And("I select a checkbox: Search in subcategories")
    public void iSelectACheckboxSearchInSubcategories()throws Throwable {
        searchCriteriaPage.clickCheckboxInSubcategories();
    }

    @When("I input the text {string} in the search field with grey borders")
    public void iInputTheTextInTheSearchFieldWithGreyBorders(String inputText) throws Throwable {
        searchPage.enterTextInSearchField(inputText);
        searchPage.waitForBlueBorderColor();
    }

    @Then("I verify that the borders of the field has bleu borders")
    public void iVerifyThatTheBordersOfTheFieldHasBleuBorders() throws Throwable {
        String actualBorderColor = searchPage.getSearchFieldBorderColor();
        String expectedBorderColor = "rgb(102, 175, 233)";
        assertEquals(expectedBorderColor, actualBorderColor);
    }

    @Then("I verify that list of products have pagination")
    public void iVerifyThatListOfProductsHavePagination() throws Throwable {
        assertTrue("Pagination is not displayed.", searchPage.isPaginationDisplayed());
    }
}
