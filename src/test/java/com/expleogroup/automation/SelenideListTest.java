package com.expleogroup.automation;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.CollectionCondition;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class SelenideListTest {

  @Test
  public void expleoSelenideListTest() {

    open("https://selenide.org");
    $("div.short.howto > div > a > img").scrollIntoView(true).click();

    // lists
    $$("div.quicklinks > div > ul > li").shouldHave(CollectionCondition.size(5));
  }
}
