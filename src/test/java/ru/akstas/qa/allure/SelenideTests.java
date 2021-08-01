package ru.akstas.qa.allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTests {

  @Test
  public void testRepositoryIssue() {


    open("https://github.com");

    $(".header-search-input").click();
    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
    $(".header-search-input").submit();

    $(By.linkText("eroshenkoam/allure-example")).click();
    $(By.partialLinkText("Issues")).click();
    $(byText("#68")).click();
  }

}
