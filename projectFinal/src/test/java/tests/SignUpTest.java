package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

public class SignUpTest extends BaseTests {

    @Test
    public void visitsTheSignUpPage() {
        signUpPage.clickOnSignUp();

        String actualResult = driver.getCurrentUrl();
        String expectedResult = "/signup";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    @Test
    public void checksInputTypes() {
        signUpPage.clickOnSignUp();
        String expectedResult = "name";
        String actualResult = signUpPage.getNameField().getAttribute("name");
        Assert.assertEquals(expectedResult, actualResult);

        String expectedResult2 = "email";
        String actualResult2 = signUpPage.getEmailField().getAttribute("type");
        Assert.assertEquals(expectedResult2, actualResult2);

        String expectedResult3 = "password";
        String actualResult3 = signUpPage.getPasswordField().getAttribute("type");
        Assert.assertEquals(expectedResult3, actualResult3);

        String expectedResult4 = "confirmPassword";
        String actualResult4 = signUpPage.getConfirmPasswordField().getAttribute("name");
        Assert.assertEquals(expectedResult4, actualResult4);

    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        signUpPage.clickOnSignUp();
        signUpPage.signUpProcess("TestTest", "admin@admin.com", "123654", "123654");
        WebElement waitForClickOnSignUp = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(signUpPage.getSignMeUpButton()));
        signUpPage.clickOnSignMeUpButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(signUpPage.getMessageEmailAlreadyExists().getText());

        String expectedResult = "E-mail already exists";
        String actualResult = signUpPage.getMessageEmailAlreadyExists().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        String expectedResult2 = "/signup";
        String actualResult2 = driver.getCurrentUrl();
        Assert.assertTrue(actualResult2.contains(expectedResult2));
    }

    @Test
    public void signUpTest() {
        driver.manage().deleteAllCookies();
        signUpPage.clickOnSignUp();
        signUpPage.signUpProcessEmailWithFaker("Tatjana Kalicanin", "email", "123456", "123456");

        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(signUpPage.getVeryImportantMessage()));
        String expectedResult = "IMPORTANT: Verify your account";
        System.out.println(signUpPage.getVeryImportantMessage().getText());
        String actualResul = signUpPage.getVeryImportantMessage().getText();
        Assert.assertTrue(actualResul.contains(expectedResult));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
