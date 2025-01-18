package pages.components;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Utils {
  public static void removeBanner() {
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
  }
}