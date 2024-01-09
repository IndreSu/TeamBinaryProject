package cucumber.pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabletsPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]")
    private WebElement tablets;

    @FindBy(how = How.ID, using = "search")
    private WebElement searchField;

    private final WebDriverWait wait;

    public TabletsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField));
        return searchField;
    }
}
