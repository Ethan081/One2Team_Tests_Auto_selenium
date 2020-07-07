package org.one2Team;

import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.junit.Assert.*;
import static org.one2Team.Hooks.*;



public class TheInternetStepdefs {
    @Given("I was in page {string}")
    public void iWasInPage(String arg0) {
        driver.get(arg0);
    }

    @When("I select {string}")
    public void iSelect(String arg0) {
        Select option = new Select(driver.findElement(By.id("dropdown")));
        option.selectByValue(arg0);
    }


    @Then("The {int} should be {string}")
    public void theShouldBe(int arg0, String arg1) {
        int calc = arg0 + 1;
        String selection = driver.findElement(By.cssSelector("#dropdown > option:nth-child(" + calc + ")")).getAttribute("selected");
        assertEquals(arg1 , selection);


    }
}
