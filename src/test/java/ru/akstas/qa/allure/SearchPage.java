package ru.akstas.qa.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {
  @Step("Открываем главную страницу")
  public void openPageByUrl(String url) {
    open(url);
  }
  @Step("")
  public void searchRepository(String repository) {
    $(".header-search-input").click();
    $(".header-search-input").sendKeys(repository);
    $(".header-search-input").submit();
  }
  @Step("")
  public void clickBy(By by) {
    $(by).click();
  }
  @Step("")
  public void checkIssuesNumber(int issueNumber) {
    $(withText("#" + issueNumber)).should(Condition.exist);
  }
}
