package tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.PracticePage;
import pages.components.Utils;

@Tag("full")
public class PracticeFormTest extends TestBase {
  PracticePage practicePage = new PracticePage();

  @Tag("full")
  @Test
  @Step("Заполнение формы регистрации")
  void fillFormTest() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    PracticePage steps = new PracticePage();

    steps.openTestPage("/automation-practice-form");
    //Utils.removeBanner();
    steps.setFirstName("Alice")
      .setLastName("Ivanova")
      .setUserEmailInput("alice-lilo@mail.ru")
      .setGender("Female")
      .setDateOfBirth("28", "April", "2010")
      .setUserNumber("1234567891").setSubjects("Math").setAddress("1\n 2\n 3\n 4\n 5\n 6")
      .setState("NCR")
      .setCity("Delhi")
      .setUploadPicture("photo_2024-11-07_16-38-58.jpg")
      .setSport("Sports")

      .submitButton();

    steps.checkResult("Student Name", "Alice Ivanova")
      .checkResult("Student Email", "alice-lilo@mail.ru")
      .checkResult("Gender", "Female")
      .checkResult("Mobile", "1234567891")
      .checkResult("Date of Birth", "28 April,2010")
      .checkResult("Subjects", "Maths")
      .checkResult("Hobbies", "Sports")
      .checkResult("Picture", "photo_2024-11-07_16-38-58.jpg")
      .checkResult("Address", "1\n 2\n 3\n 4\n 5\n 6")
      .checkResult("State and City", "NCR Delhi");
  }
}
