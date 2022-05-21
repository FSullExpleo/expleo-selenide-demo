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

    // arrange
    String browser = "chrome";
    System.setProperty("webdriver.chrome.driver", "C:\\Temp\\webdrivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    if ("edge".equals(browser)) {
      System.setProperty("webdriver.edge.driver", "C:\\Temp\\webdrivers\\msedgedriver.exe");
      driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://selenide.org");

    WebElement element = driver.findElement(By.cssSelector("div.short.howto > div > a > img"));
    Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
    driver.findElement(By.cssSelector("div.short.howto > div > a > img")).click();

    // assert
    Assert.assertTrue(
        "Not at 'Quick Start' page",
        driver
            .findElement(By.cssSelector("h4"))
            .getText()
            .contains("It's extremely easy to start using Selenide."));

    driver.quit();
  }
}
