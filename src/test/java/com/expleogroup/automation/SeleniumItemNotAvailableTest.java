package com.expleogroup.automation;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.fail;

import com.codeborne.selenide.Condition;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumItemNotAvailableTest {

  @Test
  public void itemNotAvailableTest() {

    System.setProperty("webdriver.chrome.driver", "C:\\Temp\\webdrivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://selenide.org");

    // Selenium
    try {
      WebElement element = driver.findElement(By.cssSelector("h7"));
      fail("Element should not exist");
    } catch (WebDriverException e) {
      // expected behaviour if item does not exist
    }
    driver.quit();

    // Selenide
    //    open("https://selenide.org");
    //    $("h7").shouldNot(exist);
  }
}
