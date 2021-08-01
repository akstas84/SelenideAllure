package ru.akstas.qa.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTests {

  private static final String REPOSITORY = "eroshenkoam/allure-example";
  private static final int ISSUE_NUMBER = 68;

  @Test
  public void testRepositoryIssue() {
    step("Открываем главную страницу", ()-> {
      open("https://github.com");
    });
    step("Ищем репозиторий", ()-> {
      $(".header-search-input").click();
      $(".header-search-input").sendKeys(REPOSITORY);
      $(".header-search-input").submit();
    });
    step("Переходим в репозиторий", ()-> {
      $(By.linkText("eroshenkoam/allure-example")).click();
    });
    step("Переходим в раздел Issues", ()-> {
      $(By.partialLinkText("Issues")).click();
    });
    step("Проверяем что существует Issues с номером " + ISSUE_NUMBER, () -> {
      $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    });
  }
}
