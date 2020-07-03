package org.one2Team;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import static org.one2Team.Hooks.driver;
import static org.junit.Assert.assertTrue;


public class HomeStepdefs {


    @Given("user is connected to LogIn")
    public void userIsConnectedToLogIn() {

        driver.get("https://chewie.one2team.com/");
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("etudiant4");
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("Etudiant4*");
        driver.findElement(By.id("domainName")).clear();
        driver.findElement(By.id("domainName")).sendKeys("telco");
        driver.findElement(By.cssSelector("#flogin > input[type=submit]")).click();
        WebElement iconHome = driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(1) > div"));
        assertTrue(iconHome.isDisplayed());
    }

    @When("user select dropdown profile")
    public void userSelectDropdownProfile() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/header[2]/div/div")).click();
    }

    @And("user clicks on Disconnect button")
    public void userClicksOnDisconnectButton() {
        driver.findElement(By.cssSelector("body > div:nth-child(8) > div > div > ul > li:nth-child(2)")).click();
    }

    @Then("user is redirected to One2Team LogIn page")
    public void userIsRedirectedToOneTeamLogInPage() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String urlLogin = driver.getCurrentUrl();
        assertTrue(urlLogin.startsWith("https://o2t-chewie.eu.auth0.com/login?"));
    }

    @When("user clicks on WebSite button")
    public void userClicksOnWebSiteButton() {
        driver.findElement(By.cssSelector("#root > div > section > section > div > main > div > div > div.shortcuts-section > div.shortcuts.collapsed > div:nth-child(1) > div > div.shortcut-content > div:nth-child(1) > div")).click();
    }

    @Then("user is redirected to One2Team WebSite")
    public void userIsRedirectedToOneTeamWebSite() {
        String urlLogin = driver.getCurrentUrl();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(urlLogin.startsWith("https://one2team.com/"));
    }
}
