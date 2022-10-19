package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class LocaleTests extends BaseTests {

    @Test
    public void setLocaleToES() {
        localePage.clickOnLgnBtn();
        localePage.getEsLng().isDisplayed();
        localePage.clickOnEsLng();
        localePage.getHeaderTitle().isDisplayed();
        String expectedResult = "Página de aterrizaje";
        String actualResult = localePage.getHeaderTitle().getText();
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

    @Test
    public void setLocaleToEN() {

        localePage.clickOnLgnBtn();
        localePage.getEnLng().isDisplayed();
        localePage.clickOnEnLng();
        localePage.getHeaderTitle().isDisplayed();
        String expectedResult = "Landing";
        String actualResult = localePage.getHeaderTitle().getText();
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

    @Test
    public void setLocaleToFR() {

        localePage.clickOnLgnBtn();
        localePage.getFrLng().isDisplayed();
        localePage.clickOnFrLng();
        localePage.getHeaderTitle().isDisplayed();
        String expectedResult = "Page d'atterrissage";
        String actualResult = localePage.getHeaderTitle().getText();
        Assert.assertEquals(expectedResult, actualResult);
        System.out.println(actualResult);
    }

}
