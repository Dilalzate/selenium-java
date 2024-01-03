package automation_exercise;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
In these tests we are using a new base class in order to configure webdriver from beginning
using BeforeSuite method
 */
public class LoginTest extends BaseTest {

  @BeforeMethod
  public void setUpLogin() {
    driver.get("https://automationexercise.com/");
  }

  @Test(description = "Test Case 2: Login User with correct email and password")
  public void testLogin() {

    String title = driver.getTitle();
    Assert.assertEquals(title, "Automation Exercise");
    driver.findElement(By.linkText("Signup / Login")).click();

    String signupTitle = driver.findElement(By.cssSelector(".login-form > h2")).getText();
    Assert.assertEquals(signupTitle, "Login to your account");

    driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("dil-automation-test@mail.com");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

    String loggedInText = driver.findElement(By.linkText("Logged in as Test Automation user")).getText();
    Assert.assertEquals(loggedInText, "Logged in as Test Automation user");
    driver.findElement(By.linkText("Logout")).click();
  }

  @Test(description = "Test Case 3: Login User with incorrect email and password")
  public void testLoginWrongCredentials() {

    String title = driver.getTitle();
    Assert.assertEquals(title, "Automation Exercise");
    driver.findElement(By.linkText("Signup / Login")).click();

    String signupTitle = driver.findElement(By.cssSelector(".login-form > h2")).getText();
    Assert.assertEquals(signupTitle, "Login to your account");

    driver.findElement(By.cssSelector("[data-qa='login-email']")).sendKeys("dilson.alzate1@hotmail.com");
    driver.findElement(By.name("password")).sendKeys("password");
    driver.findElement(By.cssSelector("[data-qa='login-button']")).click();

    String loggedInText = driver.findElement(By.cssSelector("[name=password] + p")).getText();
    Assert.assertEquals(loggedInText, "Your email or password is incorrect!");
  }

  @AfterClass
  public void tearDown() {

    driver.quit();
  }

}
