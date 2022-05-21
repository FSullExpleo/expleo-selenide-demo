package com.expleogroup.automation;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {

  @Test
  public void expleoSeleniumTest() {

    // choose browser and set driver
    String browser = "chrome";
    System.setProperty("webdriver.chrome.driver", "C:\\Temp\\webdrivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    if ("edge".equals(browser)) {
      System.setProperty("webdriver.edge.driver", "C:\\Temp\\webdrivers\\msedgedriver.exe");
      driver = new EdgeDriver();
    }

    // set timeout
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    // open browser
    driver.get("https://selenide.org");

    // find 'quick start' element
    WebElement element = driver.findElement(By.cssSelector("div.short.howto > div > a > img"));

    // move to element to enable interaction
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();

    // perform action
    driver.findElement(By.cssSelector("div.short.howto > div > a > img")).click();

    // assert
    Assert.assertTrue(
        "Not at 'Quick Start' page",
        driver
            .findElement(By.cssSelector("h4"))
            .getText()
            .contains("It's extremely easy to start using Selenide."));

    // close browser
    driver.quit();
  }
}
