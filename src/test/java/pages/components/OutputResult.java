package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputResult {
  public void outputResult(String key,String value) {
    $("#output").$(byText(key))
      .shouldHave(text(value));
  }
}