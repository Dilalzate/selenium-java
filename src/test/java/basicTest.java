import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class basicTest {


  public WebDriver driver;

  private static String DROPDOWN_URL = "https://the-internet.herokuapp.com/dropdown";

  @BeforeMethod
  public void setUp() {

    driver = new ChromeDriver();
  }


  @Test
  public void dropdownTest() {

    driver.get(DROPDOWN_URL);
  }

}
