package cucumber.pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;


public class SamplePo {

    //   Define elements
    @FindBy(how = How.ID, using = "name") // By.id("name")
    private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("name"));


    public String getPageUrl() {
        return "https://demoshop24.com/";
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }
}
