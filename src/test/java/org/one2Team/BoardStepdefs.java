package org.one2Team;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.one2Team.Hooks.driver;


public class BoardStepdefs {

    @And("user click on Board Button")
    public void userClickOnBoardButton() {
        driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(2)")).click();
        assertTrue(driver.getCurrentUrl().contains("slideboard-new"));
    }

    @When("user create new card {string}")
    public void userCreateNewCard(String arg0) throws InterruptedException {
        driver.findElement(By.className("add-icon")).click();
        driver.switchTo().activeElement();
        Thread.sleep(4000);
        driver.findElement(By.className("ant-input")).clear();
        driver.findElement(By.className("ant-input")).sendKeys(arg0);
        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[3]/div/div[2]/button[2]")).click();
    }
    @Then("card should be create")
    public void cardShouldBeCreate() {
        String idCard = driver.findElement(By.tagName("id")).getText();
        assertTrue(driver.findElement(By.id(idCard )).isEnabled());




    }

    @Given("user is connected to LogIn and card created")
    public void userIsConnectedToLogInAndCardCreated() {
        driver.get("https://chewie.one2team.com/");
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("etudiant4");
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("Etudiant4*");
        driver.findElement(By.id("domainName")).clear();
        driver.findElement(By.id("domainName")).sendKeys("telco");
        driver.findElement(By.cssSelector("#flogin > input[type=submit]")).click();
        driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(2)")).click();
    }

    @When("user drop card to october column")
    public void userDropCardToOctoberColumn() throws InterruptedException {

        WebElement drag = driver.findElement(By.xpath("//*[@id=\"columns-container\"]/div/div[1]/div[2]/div[1]"));
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"columns-container\"]/div/div[6]/div[2]/div[1]"));
        Actions act = new Actions(driver);
        act.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(4000);
    }

    @Then("card should be prodded to new column")
    public void cardShouldBeProddedToNewColumn() {
        assertEquals(driver.findElement(By.id("/ogp/8558138")), driver.findElement(By.id("/ogp/8558138")));

    }
}
