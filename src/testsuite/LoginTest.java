package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
    WebElement userName=driver.findElement(By.xpath("//input[@id='customer.username']"));
        //WebElement userName=driver.findElement(By.xpath("//input[@id='customer.username']"));
        //sending username to the field
        userName.sendKeys("Krishna");
        //finding element of Password
        WebElement passWord=driver.findElement(By.xpath("//input[@name='customer.password']"));
        //sending password to password field
        passWord.sendKeys("Testing123");
        //finding element of confirm password
        WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='repeatedPassword']"));//sending password to confirm password field
        confirmPassword.sendKeys("Testing123");
        //finding element of REGISTER button
        WebElement register1=driver.findElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
        //sending click to register field
        register1.click();
        WebElement actualMessage = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualTextMessage = actualMessage.getText();
        String expectedTextMessage = "Accounts Overview";
        Assert.assertEquals("Login Failed!", actualTextMessage, expectedTextMessage);
    }
@Test
    public void verifyTheErrorMessage() {
    WebElement userName=driver.findElement(By.xpath("//input[@id='customer.username']"));
        userName.sendKeys("Krishna001");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='customer.password']"));
        passWord.sendKeys("Test456");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
        login.click();
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='The username and password could not be verified.']"));
        String actualTaxtMessage = actualMessage.getText();
        String expectedTaxtMessage = "The username and password could not be verified.";
        Assert.assertEquals("Test Failed", expectedTaxtMessage, actualTaxtMessage);
    }
    @Test

    public void userShouldLogOutSuccessfully() {

        WebElement userName=driver.findElement(By.xpath("//input[@id='customer.username']"));
        userName.sendKeys("Krishna");
        WebElement passWord = driver.findElement(By.xpath("//input[@name='customer.password']"));
        passWord.sendKeys("Testing123");
        WebElement login = driver.findElement(By.xpath("//input[@type='submit' and @class='button' and @value='Register']"));
        login.click();
        WebElement logout = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logout.click();
        WebElement actualMessage = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
        String actualTextMessage = actualMessage.getText();
        String expectedTextMessage = "Customer Login";
        Assert.assertEquals("Failed to Logout!", expectedTextMessage, actualTextMessage);

    }
    @After
    public void teardown(){
        closeBrowser();
    }

}
