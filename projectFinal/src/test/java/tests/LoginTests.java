package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTests {

    @Test (priority = 1)
    public void visitsTheLoginPage () {
        loginPage.getLoginButton().click();
        String actualResult = driver.getCurrentUrl(); //"https://vue-demo.daniel-avellaneda.com/login";
        String expectedResult = ("/login");
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println(actualResult);
    }

    @Test (priority = 2)
    public void checksInputTypes () {

        WebElement waitForLoginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loginPage.getLoginButton()));
        loginPage.getLoginButton().click();
        loginPage.getEmailField().isDisplayed();
        String expectedResult = "email";
        String actualResult = loginPage.getEmailField().getAttribute("type");
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(expectedResult + actualResult);

        String expectedResult2 = "password";
        String actualResult2 = loginPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(actualResult2, expectedResult2);
        System.out.println(expectedResult2 + actualResult2);

    }

    @Test (priority = 3)
    public void displaysErrorsWhenUserDoesNotExist () {
        loginPage.getLoginButton().click();
        loginPage.loginWithFakerLibrary("emailF", "passwordF");

        loginPage.clickOnLoginButtonFromLoginPage();
        String expectedResult = "User does not exists";
        String actualResult = loginPage.getErrorMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        System.out.println(loginPage.getErrorMessage().getText());
        System.out.println(driver.getCurrentUrl());
        String expectedResult2 = "/login";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

    @Test (priority = 4)
    public void displaysErrorsWhenPasswordIsWrong () {
        loginPage.getLoginButton().click();
        loginPage.login("admin@admin.com", "11111");
        String expectedResult = "Wrong password";
        String actualResult = loginPage.getErrorMessageWrongPassword().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        System.out.println(actualResult);
        System.out.println(driver.getCurrentUrl());
    }


    @Test (priority = 5)
    public void loginTest () {
        loginPage.getLoginButton().click();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        String expectedResult = driver.getCurrentUrl();
        Assert.assertTrue(expectedResult.contains("/home"));
        //driver.quit();
    }

    @Test (priority = 6)
    public void logoutTest () {
        WebElement waitForLoginButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf( loginPage.getLoginButton()));
        loginPage.getLoginButton().click();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        loginPage.getLogoutButton().isDisplayed();
        Assert.assertTrue(loginPage.getLogoutButton().isDisplayed());

        loginPage.clickOnLogoutButtonFromLoginPage();
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expectedResult2 ="/login";
        String actualResult2 = driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(actualResult2.contains(expectedResult2));

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
