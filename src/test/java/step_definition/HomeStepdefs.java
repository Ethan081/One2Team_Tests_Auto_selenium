package step_definition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import static modules.Hooks.driver;
import static org.junit.Assert.assertTrue;


public class HomeStepdefs {


    @Given("user is connected to LogIn")
    public void userIsConnectedToLogIn() {

        driver.get("https://chewie.one2team.com/");
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("*******");
        driver.findElement(By.id("passWord")).clear();
        driver.findElement(By.id("passWord")).sendKeys("*******");
        driver.findElement(By.id("domainName")).clear();
        driver.findElement(By.id("domainName")).sendKeys("telco");
        driver.findElement(By.cssSelector("#flogin > input[type=submit]")).click();
        WebElement iconHome = driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(1) > div"));
        assertTrue(iconHome.isDisplayed());
    }

    @When("user select dropdown profile")
    public void userSelectDropdownProfile() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#root > div > section > section > div > header:nth-child(2) > div > div > img")).click();
        Thread.sleep(3000);
    }

    @And("user clicks on Disconnect button")
    public void userClicksOnDisconnectButton() {
        driver.findElement(By.xpath("/html/body/div[6]/div/div/ul/li[2]")).click();
    }

    @Then("user is redirected to One2Team LogIn page")
    public void userIsRedirectedToOneTeamLogInPage() {
        assertTrue(driver.getCurrentUrl().contains("login"));
    }


    @When("user clicks on {string} {string}")
    public void userClicksOn(String arg0, String arg1) {
        if(driver.findElement(By.cssSelector("#root > div > section > section > div > main > div > div > div.shortcuts-section > div.shortcuts.collapsed")).getAttribute("class").equals("shortcuts collapsed")){
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/main/div/div/div[2]/div[2]/button")).click();
        }
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/div/main/div/div/div[2]/div[1]/" + arg1 + "/div")).click();
    }

    @Then("user is redirected to {string}")
    public void userIsRedirectedTo(String arg0) {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        int size = tabs.size();
        driver.switchTo().window(tabs.get(size-1));
        assertTrue(driver.getCurrentUrl().contains(arg0));

    }


}
