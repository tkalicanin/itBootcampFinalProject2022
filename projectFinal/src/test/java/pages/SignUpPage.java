package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage extends BasePage {
    private By signUp = By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]");
    private By nameField = By.xpath("//*[@id=\"name\"]");
    private By emailField = By.xpath("//*[@id=\"email\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By confirmPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private By signMeUpButton = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By messageEmailAlreadyExists = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div");
    private By veryImportantMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]");
    private By admin = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span/i");
    private By cities = By.xpath("//*[@id=\"list-item-117\"]");
    private By closeInImportantMessage = By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button");
    private By myProfile = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]");

    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSignUp() {
        return getDriver().findElement(signUp);
    }

    public void clickOnSignUp() {
        getSignUp().click();
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getMessageEmailAlreadyExists() {
        return getDriver().findElement(messageEmailAlreadyExists);
    }

    public void clickOnSignMeUpButton() {

        getSignMeUpButton().click();
    }

    public void signUpProcess(String name, String email, String password, String confirmPassword) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);

        clickOnSignMeUpButton();
    }

    public void signUpProcessEmailWithFaker(String name, String email, String password, String confirmPassword) {
        getNameField().sendKeys(name);
        Faker faker = new Faker();
        String emailFaker = faker.internet().emailAddress();
        getEmailField().sendKeys(emailFaker);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(confirmPassword);

        clickOnSignMeUpButton();
    }

    public WebElement getSignMeUpButton() {

        return getDriver().findElement(signMeUpButton);
    }

    public WebElement getVeryImportantMessage() {

        return getDriver().findElement(veryImportantMessage);
    }

    public WebElement getAdmin() {

        return getDriver().findElement(admin);
    }

    public void clickOnAdmin() {

        getAdmin().click();
    }

    public WebElement getCities() {

        return getDriver().findElement(cities);
    }

    public void clickOnCities() {

        getCities().click();
    }

    public void signUpWithoutConfirmPass(String name, String email, String password) {
        getNameField().sendKeys(name);
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
    }

    public void confirmPasswordFromFaker(String pass) {
        String confPass = getPasswordField().getText();
        getConfirmPasswordField().sendKeys();
    }

    public WebElement getCloseInImportantMessage() {

        return getDriver().findElement(closeInImportantMessage);
    }

    public void clickOnCloseInImportantMessage() {

        getCloseInImportantMessage().click();
    }

    public WebElement getMyProfile() {

        return getDriver().findElement(myProfile);
    }

    public void clickOnMyProfile() {

        getMyProfile().click();
    }


}
