package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class EditsProfileTests extends BaseTests {
    private ProfilePage profilepage;

    @Test
    public void editsProfile() {
        profilepage = new ProfilePage(driver, webDriverWait);
        signUpPage.clickOnSignUp();
        Faker faker = new Faker();
        signUpPage.signUpWithoutConfirmPass(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password());
        signUpPage.getPasswordField().getText();
        System.out.println();
        signUpPage.getPasswordField().click();
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(profilepage.getNameProfileField()));
        String nameValue = profilepage.getNameProfileField().getAttribute("value");
        System.out.println(nameValue);

        signUpPage.getPasswordField().getText();
        System.out.println(signUpPage.getPasswordField().getAttribute("value"));
        String passEntered = signUpPage.getPasswordField().getAttribute("value");

        String emailValue = profilepage.getEmailProfileField().getAttribute("value");
        System.out.println(emailValue);

        String passFromFaker = signUpPage.getPasswordField().getAttribute("value");
        WebElement waiter = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(signUpPage.getConfirmPasswordField()));
        signUpPage.getConfirmPasswordField().click();

        signUpPage.getConfirmPasswordField().sendKeys(passFromFaker);
        signUpPage.clickOnSignMeUpButton();
        signUpPage.getVeryImportantMessage().isDisplayed();

        signUpPage.clickOnCloseInImportantMessage();
        signUpPage.clickOnMyProfile();

        profilepage.getPhoneProfileField().sendKeys(faker.phoneNumber().cellPhone());
        System.out.println(profilepage.getPhoneProfileField().getAttribute("value"));
        String phoneEntered = profilepage.getPhoneProfileField().getAttribute("value");

        profilepage.getCityProfileField().click();
        profilepage.getFirstCity().isDisplayed();

        System.out.println(profilepage.getFirstCityChosen().getText());
        profilepage.getFirstCity().click();
        String cityEntered = profilepage.getFirstCityChosen().getText();

        profilepage.getCountryProfileField().sendKeys(faker.country().name());
        System.out.println(profilepage.getCountryProfileField().getAttribute("value"));
        String countryEntered = profilepage.getCountryProfileField().getAttribute("value");

        profilepage.getTwitterProfileField().sendKeys(faker.internet().avatar());
        System.out.println(profilepage.getTwitterProfileField().getAttribute("value"));
        String twitterEntered = profilepage.getTwitterProfileField().getAttribute("value");

        profilepage.getGithubProfileField().sendKeys(faker.internet().avatar());
        System.out.println(profilepage.getGithubProfileField().getAttribute("value"));
        String gitHubEntered = profilepage.getGithubProfileField().getAttribute("value");

        profilepage.clickOnSaveBtn();

        profilepage.getSavedSucceslullyMsg().getText();
        System.out.println(profilepage.getSavedSucceslullyMsg().getText());

        Assert.assertEquals(nameValue, profilepage.getNameProfileField().getAttribute("value"));
        Assert.assertEquals(emailValue, profilepage.getEmailProfileField().getAttribute("value"));
        Assert.assertEquals(phoneEntered, profilepage.getPhoneProfileField().getAttribute("value"));
        Assert.assertEquals(cityEntered, profilepage.getFirstCityChosen().getText());
        Assert.assertEquals(countryEntered, profilepage.getCountryProfileField().getAttribute("value"));
        Assert.assertEquals(twitterEntered.toLowerCase(), profilepage.getTwitterProfileField().getAttribute("value").toLowerCase());
        Assert.assertEquals(gitHubEntered.toLowerCase(), profilepage.getGithubProfileField().getAttribute("value").toLowerCase());
    }
}


