package automation_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

  WebDriver driver;

  @BeforeSuite
  public void setUp() {

    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ZERO);
    driver.manage().window().maximize();
  }


}
