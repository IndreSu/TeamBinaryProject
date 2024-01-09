package cucumber.pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchCriteriaPage {

    @FindBy(how = How.ID, using = "button-search")
    private WebElement searchBlueButton;
    @FindBy(how = How.ID, using = "input-search")
    private WebElement searchCriteriaField;
    @FindBy(how = How.ID, using = "description")
    private WebElement checkboxSearchInProductDescriptions;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[3]/label/input")
    private WebElement checkboxSearchInSubcategories;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/select")
    private WebElement categoriesDropdown;

    private final WebDriverWait wait;

    public SearchCriteriaPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterTextInSearchCriteriaField(String inputText) {
        wait.until(ExpectedConditions.visibilityOf(searchCriteriaField));
        searchCriteriaField.clear();
        searchCriteriaField.sendKeys(inputText);
    }

    public void clickBlueSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchBlueButton));
        searchBlueButton.click();
    }

    public void clickCheckboxInProductDescriptions() {
        wait.until(ExpectedConditions.visibilityOf(checkboxSearchInProductDescriptions));
        checkboxSearchInProductDescriptions.click();
    }

    public void clickCheckboxInSubcategories() {
        wait.until(ExpectedConditions.visibilityOf(checkboxSearchInSubcategories));
        checkboxSearchInSubcategories.click();
    }

    public void selectCategoryDropdown(String categoryName) {
        wait.until(ExpectedConditions.visibilityOf(categoriesDropdown));
        new Select(categoriesDropdown).selectByVisibleText(categoryName);
    }
}
