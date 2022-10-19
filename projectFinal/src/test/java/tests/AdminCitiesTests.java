package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminCitiesPage;
import pages.LoginPage;
import pages.SignUpPage;

import java.time.Duration;

public class AdminCitiesTests extends BaseTests {
    @Test
    public void adminCitiesPageAndListCities() {
        signUpPage = new SignUpPage(driver, webDriverWait);
        loginPage.clickOnLoginButton();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        signUpPage.clickOnAdmin();
        signUpPage.clickOnCities();
        String expectedResult = driver.getCurrentUrl();
        Assert.assertTrue(expectedResult.contains("/admin/cities"));
    }

    @Test
    public void createNewCity() {
        signUpPage = new SignUpPage(driver, webDriverWait);
        loginPage.clickOnLoginButton();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        signUpPage.clickOnAdmin();
        signUpPage.clickOnCities();
        adminCitiesPage.clickOnNewItemButton();
        adminCitiesPage.clickOnNewItemField();
        Faker faker = new Faker();
        adminCitiesPage.getNewItemField().sendKeys(faker.address().city());
        adminCitiesPage.clickOnSaveButton();
        String expectedResult = "Saved successfully";
        String actualResult = adminCitiesPage.getMessageSaveSuccessfully().getText();
        System.out.println(adminCitiesPage.getMessageSaveSuccessfully().getText());
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void editCity() {
        signUpPage = new SignUpPage(driver, webDriverWait);
        loginPage.clickOnLoginButton();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        signUpPage.clickOnAdmin();
        signUpPage.clickOnCities();
        adminCitiesPage.clickOnNewItemButton();
        adminCitiesPage.clickOnNewItemField();
        Faker faker = new Faker();
        adminCitiesPage.getNewItemField().sendKeys(faker.address().city());
        adminCitiesPage.clickOnSaveButton();
        adminCitiesPage.getNewItemField().getText();
        System.out.println(adminCitiesPage.getNewItemField().getText());

        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getEditItemField().isDisplayed();
        adminCitiesPage.editItemProccess(" - edited");
        adminCitiesPage.clickOnSaveButton();
        String expectedResult = "Saved successfully";
        String actualResult = adminCitiesPage.getMessageSaveSuccessfully().getText();
        System.out.println(adminCitiesPage.getFirstCityName().getText());
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void searchCity() {
        signUpPage = new SignUpPage(driver, webDriverWait);
        loginPage.clickOnLoginButton();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        signUpPage.clickOnAdmin();
        signUpPage.clickOnCities();
        adminCitiesPage.clickOnNewItemButton();
        adminCitiesPage.clickOnNewItemField();
        Faker faker = new Faker();
        adminCitiesPage.getNewItemField().sendKeys(faker.address().city());
        adminCitiesPage.clickOnSaveButton();
        adminCitiesPage.getNewItemField().getText();
        System.out.println(adminCitiesPage.getNewItemField().getText());

        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getEditItemField().isDisplayed();
        adminCitiesPage.editItemProccess(" - edited");
        adminCitiesPage.clickOnSaveButton();
        String expectedResult = "Saved successfully";
        String actualResult = adminCitiesPage.getMessageSaveSuccessfully().getText();
        System.out.println(adminCitiesPage.getFirstCityName().getText());
        Assert.assertTrue(actualResult.contains(expectedResult));

        adminCitiesPage.getSearchField().sendKeys(adminCitiesPage.getFirstCityName().getText());

        Assert.assertTrue(adminCitiesPage.getFirstCityName().isDisplayed());
    }

    @Test
    public void deleteCity() {
        signUpPage = new SignUpPage(driver, webDriverWait);
        loginPage.clickOnLoginButton();
        loginPage.login("admin@admin.com", "12345");
        loginPage.clickOnLoginButtonFromLoginPage();
        signUpPage.clickOnAdmin();
        signUpPage.clickOnCities();
        adminCitiesPage.clickOnNewItemButton();
        adminCitiesPage.clickOnNewItemField();
        Faker faker = new Faker();
        adminCitiesPage.getNewItemField().sendKeys(faker.address().city());
        adminCitiesPage.clickOnSaveButton();
        adminCitiesPage.getNewItemField().getText();
        System.out.println(adminCitiesPage.getNewItemField().getText());

        adminCitiesPage.getEditButton().click();

        adminCitiesPage.getEditItemField().isDisplayed();
        adminCitiesPage.editItemProccess(" - edited");
        adminCitiesPage.clickOnSaveButton();
        adminCitiesPage.getFirstCityName().isDisplayed();
        adminCitiesPage.clickOnDeleteButton();
        adminCitiesPage.getPopupWarningMessage().isDisplayed();
        adminCitiesPage.clickOnDeleteInPopup();
        System.out.println(adminCitiesPage.getDeleteSuccessfullyMessage().getText());
        String expectedResult = "Deleted successfully";
        String actualResult = adminCitiesPage.getDeleteSuccessfullyMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
