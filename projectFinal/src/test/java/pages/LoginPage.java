package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    private By loginButton = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By loginButtonFromLoginPage = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By errorMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    private By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]");
    private By errorMessageWrongPassword = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div");
    private By homeButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage (WebDriver driver, WebDriverWait webDriverWait) {
        super (driver, webDriverWait);
    }
    public WebElement getLoginButton() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getDriver().findElement(loginButton);
    }
    public void clickOnLoginButton () {
        getLoginButton().click();
    }
    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public void clickOnEmailField () {
        getEmailField().click();
    }
    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public void clickOnPasswordField () {
        getPasswordField().click();
    }
    public void loginWithFakerLibrary (String emailF, String passwordF) {
        Faker faker = new Faker();
        String emailFaker = faker.internet().emailAddress();
        String passwordFaker = faker.internet().password();
        getEmailField().sendKeys(emailFaker);
        getPasswordField().sendKeys(passwordFaker);
    }

    public WebElement getLoginButtonFromLoginPage() {

        return getDriver().findElement(loginButtonFromLoginPage);
    }

    public void clickOnLoginButtonFromLoginPage () {

        getLoginButtonFromLoginPage().click();
    }

    public WebElement getErrorMessage() {
        return getDriver().findElement(errorMessage);
    }

    public void login (String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        clickOnLoginButtonFromLoginPage();
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public void clickOnLogoutButtonFromLoginPage () {
        getLogoutButton().click();
    }

    public WebElement getErrorMessageWrongPassword() {
        return getDriver().findElement(errorMessageWrongPassword);
    }

    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
    }

    public void clickOnHomeButton () {
        getHomeButton().click();
    }
}
