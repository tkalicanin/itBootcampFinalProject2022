package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    private By emailProfileField = By.xpath("//*[@id=\"email\"]");
    private By nameProfileField = By.xpath("//*[@id=\"name\"]");
    private By phoneProfileField = By.xpath("//*[@id=\"phone\"]");
    private By countryProfileField = By.xpath("//*[@id=\"country\"]");
    private By twitterProfileField = By.xpath("//*[@id=\"urlTwitter\"]");
    private By githubProfileField = By.xpath("//*[@id=\"urlGitHub\"]");
    private By cityProfilePage = By.xpath("//*[@id=\"city\"]");
    private By firstCity = By.xpath("//*[@id=\"list-item-166-0\"]/div");
    private By firstCityChosen = By.xpath("//*[@id=\"list-item-166-0\"]/div/div");
    private By saveBtn = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private By savedSuccessfullyMsg = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]");

    public ProfilePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getEmailProfileField() {

        return getDriver().findElement(emailProfileField);
    }

    public WebElement getNameProfileField() {

        return getDriver().findElement(nameProfileField);
    }

    public WebElement getPhoneProfileField() {

        return getDriver().findElement(phoneProfileField);
    }

    public void clickOnPhoneProfileField() {

        getPhoneProfileField().click();
    }

    public WebElement getCountryProfileField() {

        return getDriver().findElement(countryProfileField);
    }

    public void clickOnCountryProfileField() {

        getCountryProfileField().click();
    }

    public WebElement getTwitterProfileField() {

        return getDriver().findElement(twitterProfileField);
    }

    public void clickOnTwitterProfileField() {

        getTwitterProfileField().click();
    }


    public WebElement getGithubProfileField() {

        return getDriver().findElement(githubProfileField);
    }

    public void clickOnGithubProfileField() {

        getGithubProfileField().click();
    }

    public WebElement getCityProfileField() {

        return getDriver().findElement(cityProfilePage);
    }

    public WebElement getFirstCity() {

        return getDriver().findElement(firstCity);
    }

    public WebElement getSaveBtn() {

        return getDriver().findElement(saveBtn);
    }

    public void clickOnSaveBtn() {

        getSaveBtn().click();
    }

    public WebElement getSavedSucceslullyMsg() {

        return getDriver().findElement(savedSuccessfullyMsg);
    }

    public WebElement getFirstCityChosen() {

        return getDriver().findElement(firstCityChosen);
    }

}
