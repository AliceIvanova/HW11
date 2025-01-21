package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class PropertiesTest {
  @Test
  @Tag("properties")
  void systemProperties(){
   // System.setProperty("browser", "opera");
    String browser=System.getProperty("browser","chrome");
    System.out.println(browser);

  }
}
