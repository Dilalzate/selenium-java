import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicTest {


  public WebDriver driver;

  private static String DROPDOWN_URL = "https://the-internet.herokuapp.com/dropdown";

  @BeforeMethod
  public void setUp() {

    driver = new ChromeDriver();
  }


  @Test
  public void dropdownTest() {

    driver.get(DROPDOWN_URL);
    driver.findElement(By.id("dropdown")).sendKeys("Option");

  }

  @Test
  public void dropdownTestUsingSelectObject() {

    driver.get(DROPDOWN_URL);
    Select select = new Select(driver.findElement(By.id("dropdown")));
    select.selectByVisibleText("Option 2");

  }

}
