package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl ="https://courses.ultimateqa.com";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        WebElement signinLinkElement = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signinLinkElement.click();
        String expectedMessage="Welcome Back!";
        WebElement actualMessageElement= driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage=actualMessageElement.getText();
        System.out.println(actualMessage);
        Assert.assertEquals("Welcome Back!",expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        WebElement signinLinkElement = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signinLinkElement.click();
        WebElement emailFieldelement= driver.findElement(By.id("user[email]"));
        emailFieldelement.sendKeys("mitesh@tom.com");
        //find password Field Element
        WebElement passwordFieldElement = driver.findElement(By.id("user[password]"));
        //send key to password field
        passwordFieldElement.sendKeys("123");
        // find sign in field element
        WebElement signinFieldElement= driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        signinFieldElement.click();
        // Requirement is Invalid email or password
        String exceptedMessage= "Invalid email or password.";
        WebElement actualMessageElement= driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage=actualMessageElement.getText();
        Assert.assertEquals(exceptedMessage,actualMessage);
    }
    @After
    public void close(){
        driver.close();
    }

}
