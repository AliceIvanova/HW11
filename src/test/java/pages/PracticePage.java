package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Заполнение формы регистрации")
public class PracticePage {

  public String welcomeText="Thanks for submitting the form";
  public String uploadPictureFromPath="photo_2024-11-07_16-38-58.jpg";
  private final SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genterInput = $("#genterWrapper"),
    userNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    uploadPictureResource=$("#uploadPicture"),
    hobbyInput = $("#hobbiesWrapper"),
    submitButtonInPracticeForm=$("#submit"),
    modalWindow=$(".modal-content"),
    addressInput=$("#currentAddress"),
    stateInput=$("#react-select-3-input"),
    cityInput=$("#react-select-4-input"),
    subjectsInput= $("#subjectsInput");

  CalendarComponent calendarComponent = new CalendarComponent();
  TableResultComponent tableResultComponent=new TableResultComponent();

  @Step("Заполнение имени")
  public PracticePage setFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }
  @Step("Заполнение фамилии")
  public PracticePage setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }
  @Step("Заполнение Email")
  public PracticePage setUserEmailInput(String value) {
    userEmailInput.setValue(value);
    return this;
  }
  @Step("Выбор пола")
  public PracticePage setGender(String value) {
    genterInput.$(byText(value)).click();
    return this;
  }
  @Step("Заполнение тел. номера")
  public PracticePage setUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }
  @Step("Заполнение даты ДР")
  public PracticePage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }
  @Step("Заполнение хобби")
  public PracticePage setSport(String hobby) {
    hobbyInput.$(byText(hobby)).click();
    return this;
  }
  @Step("Открытие страницы")
  public PracticePage openTestPage (String value) {
    open(value);
    return this;
  }
  @Step("Загрузка картинки")
  public PracticePage setUploadPicture(String value) {
    uploadPictureResource.uploadFromClasspath(value);
    return this;
  }
  @Step("Выбор предмета")
  public PracticePage setSubjects(String value){
    subjectsInput.setValue(value).pressEnter();
    return this;
  }
  @Step("Заполнение адреса")
  public PracticePage setAddress(String value) {
    addressInput.setValue(value);
    return this;
  }
  @Step("Заполнение страны")
  public PracticePage setState(String value) {
    stateInput.setValue(value).pressEnter();
    return this;
  }
  @Step("Заполнение города")
  public PracticePage setCity(String value) {
    cityInput.setValue(value).pressEnter();
    return this;
  }
  @Step("Подтверждение ввода")
  public PracticePage  submitButton() {
    submitButtonInPracticeForm.scrollIntoView(true).click();
    return this;
  }
  @Step("Проверка вывода {0} результата в таблицу")
  public PracticePage checkResult(String key, String value) {
    tableResultComponent.tableResult(key, value);
    return this;
  }
  @Step("Проверка, что окно закрылось")
  public void  checkFormNotAppears() {
    modalWindow.shouldNotBe(visible);
  }
}