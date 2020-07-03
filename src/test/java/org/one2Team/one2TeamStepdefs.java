package org.one2Team;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.one2Team.Hooks.driver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class one2TeamStepdefs {

    @Given("user navigates to {string}")
    public void iAmOnLoginInPage(String url) {
        driver.get(url);
    }

    @When("user enters {string} {string}")
    public void userEnters(String field, String value) {
        driver.findElement(By.id(field)).clear();
        driver.findElement(By.id(field)).sendKeys(value);
    }

    @When("user clicks on Connect button")
    public void userClicksOnConnectButton() {
        driver.findElement(By.cssSelector("#flogin > input[type=submit]")).click();
    }

    @Then("login is {string} with {string}")
    public void loginIsWith(String arg0, String arg1) {
        switch (arg0) {
            case "successful":
                WebElement iconHome = driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(1) > div"));
                assertTrue(iconHome.isDisplayed());
                break;
            case "failed":
                assertEquals(arg1, driver.findElement(By.cssSelector("#errorMsg > div")).getText());
                break;
        }

    }

    @Then("user is redirected to One2Team homepage")
    public void userIsRedirectedToOneTeamHomepage() {
        WebElement iconHome = driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(1) > div"));
        assertTrue(iconHome.isDisplayed());

    }


}