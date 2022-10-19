package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class AuthRoutesTests extends BaseTests {

    @Test
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        String homePageUrl = "https://vue-demo.daniel-avellaneda.com/home";
        driver.get(homePageUrl);
        String actualResult = driver.getCurrentUrl();
        Assert.assertNotEquals(actualResult, homePageUrl);
        Assert.assertTrue(actualResult.contains("/login"));
        System.out.println(actualResult);
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        String profilePageUrl = "https://vue-demo.daniel-avellaneda.com/profile";
        driver.get(profilePageUrl);
        String actualResult = driver.getCurrentUrl();
        Assert.assertNotEquals(actualResult, profilePageUrl);
        Assert.assertTrue(actualResult.contains("/login"));
        System.out.println(actualResult);
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        String adminCitiesPageUrl = "https://vue-demo.daniel-avellaneda.com/admin/cities";
        driver.get(adminCitiesPageUrl);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/login"));
        System.out.println(actualResult);
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        String adminUsersPageUrl = "https://vue-demo.daniel-avellaneda.com/admin/users";
        driver.get(adminUsersPageUrl);
        String actualResult = driver.getCurrentUrl();
        Assert.assertTrue(actualResult.contains("/login"));
        System.out.println(actualResult);
    }

}
