package cucumber.pages_sample;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SearchPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/input")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//*[@id='search']/span/button")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@id='content']/div[3]")
    private List<WebElement> searchResults;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/p[2]")
    private WebElement message;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div[4]/div[1]/ul/li[3]/a")
    private WebElement paginationNextButton;

    private final WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return searchField;
    }

    public void enterTextInSearchField(String inputText) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(inputText);
    }

    public void enterNumbersInSearchField(String inputNumbers) {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(inputNumbers);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchButton.click();
    }

    public boolean verifyResultsContainText(String inputText) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        boolean allResultsContainText = true;

        for (WebElement result : searchResults) {
            wait.until(ExpectedConditions.visibilityOfAllElements(result));
            if (!result.getText().toLowerCase().contains(inputText.toLowerCase())) { //checking without capital letters
                allResultsContainText = false;
                break;
            }
        }
        return allResultsContainText;
    }

    public boolean verifyResultContainNumbers(String inputNumbers) {
        wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
        boolean allResultsContainNumbers = true;

        for (WebElement result : searchResults) {
            wait.until(ExpectedConditions.visibilityOfAllElements(result));
            if (!result.getText().contains(inputNumbers)) {
                allResultsContainNumbers = false;
                break;
            }
        }
       return allResultsContainNumbers;
    }

    public void showMessage() {
        String actualMessage = message.getText();
        Assertions.assertTrue(actualMessage.equals("There is no product that matches the search criteria."));
    }

    public String getSearchFieldBorderColor() {
        return searchField.getCssValue("border-color");
    }

    public void waitForBlueBorderColor() {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String actualBorderColor = getSearchFieldBorderColor();
                return actualBorderColor.equals("rgb(102, 175, 233)");
            }
        });
    }

    public boolean isPaginationDisplayed() {
        try {
                wait.until(ExpectedConditions.visibilityOfAllElements(searchResults));
                wait.until(ExpectedConditions.visibilityOfAllElements(paginationNextButton));
                return paginationNextButton.isDisplayed();
            } catch (Exception e) {
                return false; // Pagination not found
            }
    }
}
