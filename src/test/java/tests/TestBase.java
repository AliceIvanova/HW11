package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
  @BeforeEach
  @Step("Настройка конфигурации")
  void setUP() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    Configuration.baseUrl = "https://demoqa.com";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
      "enableVNC", true,
      "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;
  }
  @AfterEach
  @Step("Закрытие веб-драйвера")
  void turnDown() {
    Selenide.closeWebDriver();
  }
}