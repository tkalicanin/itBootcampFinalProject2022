package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.SignUpPage;
import pages.ProfilePage;
import pages.LocalePage;
import pages.AdminCitiesPage;

import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected LocalePage localePage;
    protected LoginPage loginPage;
    protected AdminCitiesPage adminCitiesPage;
    protected SignUpPage signUpPage;
    protected ProfilePage profilePage;

    public BaseTests() {
    }

    public LocalePage getLocalePage() {
        return localePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ProfilePage getProfilePage() {
        return profilePage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public AdminCitiesPage getAdminCitiesPage() {
        return adminCitiesPage;
    }

    @BeforeClass
    public void befClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\3200g\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        loginPage = new LoginPage(driver, webDriverWait);
        signUpPage = new SignUpPage(driver, webDriverWait);
        localePage = new LocalePage(driver, webDriverWait);
        profilePage = new ProfilePage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
    }

    @AfterClass
    public void aftClass() {
        driver.quit();
    }
}
