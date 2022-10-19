package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalePage extends BasePage {
    private By lngButton = By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button");
    private By esLng = By.xpath("//*[@id=\"list-item-75\"]");
    private By headerTitle = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    private By enLng = By.xpath("//*[@id=\"list-item-73\"]");
    private By frLng = By.xpath("//*[@id=\"list-item-77\"]");

    public LocalePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getLngButton() {
        return getDriver().findElement(lngButton);
    }

    public void clickOnLgnBtn() {

        getLngButton().click();
    }

    public WebElement getEsLng() {
        return getDriver().findElement(esLng);
    }

    public void clickOnEsLng() {

        getEsLng().click();
    }

    public WebElement getHeaderTitle() {
        return getDriver().findElement(headerTitle);
    }

    public WebElement getEnLng() {
        return getDriver().findElement(enLng);
    }

    public void clickOnEnLng() {

        getEnLng().click();
    }

    public WebElement getFrLng() {
        return getDriver().findElement(frLng);
    }

    public void clickOnFrLng() {

        getFrLng().click();
    }
}
