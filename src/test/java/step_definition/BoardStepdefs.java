package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;
import static modules.Hooks.driver;


public class BoardStepdefs {
    int divSizeInitial, divSizeFinal;

    @And("user is on board page")
    public void userIsOnBoardPage()  {
        while(!driver.getCurrentUrl().contains("slideboard-new/a/")){
            driver.findElement(By.cssSelector("#root > div > section > aside > div > div > div.module-links-list > a:nth-child(2)")).click();
        }
    }

    @When("user creates a new card")
    public void userCreatesANewCard() throws InterruptedException {
        DateTimeFormatter dateformat  = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime localDate = LocalDateTime.now();
        String dateCardBeCreate = dateformat.format(localDate);
        driver.findElement(By.xpath("//*[@id=\"columns-container\"]/div/div[1]/div[1]/div[2]/div/span")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/span/input")).sendKeys("newCard_" + dateCardBeCreate);
        driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[3]/div/div[2]/button[2]")).click();
        Thread.sleep((5000));
    }

    @And("user drag&drop card")
    public void userDragDropCard() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement from = driver.findElement(By.xpath("//*[@id=\"columns-container\"]/div/div[1]/div[2]/div[1]"));
        WebElement to = driver.findElement(By.cssSelector("#columns-container > div > div.containCol__col.column-animation.col2 > div.containCol__col__card"));
        actions.dragAndDrop(from, to).build().perform();
        Thread.sleep(3000);
    }

    @Then("card is correctly dragged and dropped")
    public void cardIsCorrectlyDraggedAndDropped() {
        divSizeFinal = driver.findElements(By.xpath("//*[@id=\"columns-container\"]/div/div[3]/div[2]/div[1]/div")).size();
        assertTrue(divSizeFinal > divSizeInitial);
    }
}
