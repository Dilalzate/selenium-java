package automation_exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 The purpose of this class is to implement 'Test Case 1' from https://automationexercise.com/test_cases
 with this approach we can see all the steps in the same method then if we want to include another test case
 probaly we need to duplicated code.
 */
public class RegisterUserTest {

  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://automationexercise.com/");
  }

  @Test
  public void testRegisterUser() {

    String title = driver.getTitle();
    Assert.assertEquals(title, "Automation Exercise");
    driver.findElement(By.linkText("Signup / Login")).click();

    String signupTitle = driver.findElement(By.cssSelector(".signup-form > h2")).getText();
    Assert.assertEquals(signupTitle, "New User Signup!");

    driver.findElement(By.name("name")).sendKeys("Dilson Alzate");
    driver.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys("dilson.alzate@hotmail.com");
    driver.findElement(By.cssSelector("[data-qa='signup-button']")).click();

    String enterAccountTitle = driver.findElement(By.cssSelector(".login-form > h2")).getText();
    Assert.assertEquals(enterAccountTitle, "ENTER ACCOUNT INFORMATION");

    driver.findElement(By.id("id_gender1")).click();

    driver.findElement(By.id("password")).sendKeys("password");

    driver.findElement(By.id("days")).sendKeys("10");
    driver.findElement(By.id("months")).sendKeys("April");
    driver.findElement(By.id("years")).sendKeys("1982");

    driver.findElement(By.id("newsletter")).click();
    driver.findElement(By.id("optin")).click();

    driver.findElement(By.id("first_name")).sendKeys("Dilson");
    driver.findElement(By.id("last_name")).sendKeys("Alzate Perez");
    driver.findElement(By.id("company")).sendKeys("MyOwnCompany");
    driver.findElement(By.id("address1")).sendKeys("Street Address 1");
    driver.findElement(By.id("address2")).sendKeys("Second Avenue");
    driver.findElement(By.id("country")).sendKeys("United States");
    driver.findElement(By.id("state")).sendKeys("Florida");
    driver.findElement(By.id("city")).sendKeys("Miami");
    driver.findElement(By.id("zipcode")).sendKeys("33191");
    driver.findElement(By.id("mobile_number")).sendKeys("305555555");

    driver.findElement(By.cssSelector("[data-qa='create-account']")).click();

    String accountCreated = driver.findElement(By.cssSelector("[data-qa='account-created']")).getText();
    Assert.assertEquals(accountCreated, "ACCOUNT CREATED!");

    driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();

    String loggedInText = driver.findElement(By.linkText("Logged in as Dilson Alzate")).getText();
    Assert.assertEquals(loggedInText, "Logged in as Dilson Alzate");

    driver.findElement(By.linkText("Delete Account")).click();

    String accountDeleted = driver.findElement(By.cssSelector("[data-qa='account-deleted']")).getText();
    Assert.assertEquals(accountDeleted, "ACCOUNT DELETED!");

    driver.quit();

  }


}
