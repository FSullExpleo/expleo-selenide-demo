package com.expleogroup.automation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumListTest {

  @Test
  public void expleoSeleniumListTest() {

    // set driver
    String browser = "chrome";
    System.setProperty("webdriver.chrome.driver", "C:\\Temp\\webdrivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    if ("edge".equals(browser)) {
      System.setProperty("webdriver.edge.driver", "C:\\Temp\\webdrivers\\msedgedriver.exe");
      driver = new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("https://selenide.org");

    // capture list of elements
    List<WebElement> elements;
    elements = driver.findElements(By.cssSelector("div.quicklinks > div > ul > li"));

    Assert.assertTrue("Incorrect number of social media links", elements.size() == 5);

    driver.quit();
  }
}
