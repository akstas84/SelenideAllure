package ru.akstas.qa.allure;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class StepsTests {

  Manager manager = new Manager();

  private static final String URL = "https://github.com";
  private static final String REPOSITORY = "eroshenkoam/allure-example";
  private static final int ISSUE_NUMBER = 68;

  @Test
  public void testRepositoryIssue() {
    manager.searchPage.openPageByUrl(URL);
    manager.searchPage.searchRepository(REPOSITORY);
    manager.searchPage.clickBy(By.linkText("eroshenkoam/allure-example"));
    manager.searchPage.clickBy(By.partialLinkText("Issues"));
    manager.searchPage.checkIssuesNumber(ISSUE_NUMBER);
  }

}
