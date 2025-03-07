package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
//@Tag("full")
public class TestBase {
  @BeforeEach
  @Step("Настройка конфигурации")

  void setUP() {
   Configuration.browserSize = System.getProperty("permission","1920x1080");
    Configuration.browser=System.getProperty("browser","chrome");
    Configuration.pageLoadStrategy = "eager";
    Configuration.remote ="https://user1:1234@"+System.getProperty("host","selenoid.autotests.cloud")+"/wd/hub";
    Configuration.baseUrl = System.getProperty("baseURL","https://demoqa.com");
    Configuration.browserVersion=System.getProperty("browserVersion");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
      "enableVNC", true,
      "enableVideo", true
    ));
    Configuration.browserCapabilities = capabilities;
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  @Step("Закрытие веб-драйвера")
  void addAttachments(){
    Attachments.screenshotAs("Last screenshot");
    Attachments.pageSource();
    Attachments.browserConsoleLogs();
    Attachments.addVideo();

    Selenide.closeWebDriver();
  }
}