package cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.pages_sample.*;


import static org.junit.Assert.assertEquals;

public class SamplePOSteps {
    private WebDriver driver;


    //constructor of samplepo
    static SamplePo samplePo;


    public SamplePOSteps() {
        this.driver = Hooks.driver;
        samplePo = PageFactory.initElements(Hooks.driver, SamplePo.class);
    }



    @Given("I am on demoShop{int} page using PO")
    public void iAmOnDemoShopPageUsingPO(int demoshop24) {
        driver.get(samplePo.getPageUrl());
    }
}
