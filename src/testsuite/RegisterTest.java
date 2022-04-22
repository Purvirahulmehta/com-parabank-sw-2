package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

        @After
    public void teardown(){
        closeBrowser();
      }
    @Test
    public void verifyThatSigningUpPageDisplay() {
        //finding the element for register tab
        WebElement register = driver.findElement(By.linkText("Register"));
        //sending the click on register tab
        register.click();
        WebElement actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]"));
        String actualMessage = actualResult.getText();
        String expectedMessage = "Signing up is easy!";
        Assert.assertEquals("Message is not match", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //finding the element for register tab
       WebElement register=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        //sending the click on register tab
        register.click();
        // finding first name element
        WebElement firstName=driver.findElement(By.xpath("//input[@id='customer.firstName']"));
        //sending firstname to first name field
        firstName.sendKeys("Kaan");
        //finding element of lastname field
       WebElement lastName=driver.findElement(By.xpath("//input[@name='customer.lastName']"));
       //sending lastname to lastName field
        lastName.sendKeys("Shah");
        //finding element of Addrees text box
       WebElement address=driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        //sending address to address field
        address.sendKeys("Laxmi Nivas");
        //finding element of city
        WebElement city=driver.findElement(By.xpath("//input[@name='customer.address.city']"));
        //sending city name to city field
        city.sendKeys("Ahmedabad");
        //finding element of state tab
        WebElement state=driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        //sending city name to city field
        state.sendKeys("Gujarat");
         //finding element of zip code
        WebElement zipCode=driver.findElement(By.xpath("//input[@name='customer.address.zipCode']"));
        //sending zipcode to the  field
        zipCode.sendKeys("380009");
        //finding element of phone number
       WebElement phoneNumber=driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        //sending numbers  to phone number  field
        phoneNumber.sendKeys("9824031235");
        //finding element of ssn
        WebElement ssn=driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        //sending numbers to snn field
       ssn.sendKeys("1234567890");
       //finding element of user name
        WebElement userName=driver.findElement(By.xpath("//input[@id='customer.username']"));
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
        WebElement actualMessage=driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualTextMessage=actualMessage.getText();
        String expectedTextMessage="Your account was created successfully. You are now logged in.";
       Assert.assertEquals("Message is not match",expectedTextMessage,actualTextMessage);

    }
}