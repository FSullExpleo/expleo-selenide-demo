package com.expleogroup.automation;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

public class SelenideTest {

  @Test
  public void expleoSelenideTest() {

    // arrange
    // Configuration.browser = "edge";
    open("https://selenide.org");

    // act
    $("div.short.howto > div > a > img").scrollIntoView(true).click();

    // assert
    $("h4").shouldHave(text("It's extremely easy to start using Selenode."));
  }
}
