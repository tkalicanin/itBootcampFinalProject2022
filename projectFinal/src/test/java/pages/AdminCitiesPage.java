package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {
    private By newItemButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button");
    private By newItemField = By.xpath("//*[@id=\"name\"]");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]");
    private By messageSaveSuccessfully = By.xpath
            ("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div");
    private By editButton = By.xpath("//*[@id=\"edit\"]");
    private By editItemField = By.xpath("//*[@id=\"name\"]");
    private By searchField = By.xpath("//*[@id=\"search\"]");
    private By firstCityName = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By deleteButton = By.xpath("//*[@id=\"delete\"]");
    private By popupWarningMessage = By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[1]");
    private By deleteInPopup = By.xpath("//*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]");
    private By deleteSuccessfullyMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");

    public AdminCitiesPage(WebDriver driver) {
        super(driver);
    }

    public AdminCitiesPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getNewItemButton() {

        return getDriver().findElement(newItemButton);
    }

    public void clickOnNewItemButton() {

        getNewItemButton().click();
    }

    public WebElement getNewItemField() {

        return getDriver().findElement(newItemField);
    }

    public void clickOnNewItemField() {

        getNewItemField().click();
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public void clickOnSaveButton() {

        getSaveButton().click();
    }

    public WebElement getMessageSaveSuccessfully() {
        return getDriver().findElement(messageSaveSuccessfully);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public void clickOnEditButton() {

        getEditButton().click();
    }

    public WebElement getEditItemField() {
        return getDriver().findElement(editItemField);
    }

    public void clickOnEditItemField() {

        getEditItemField().click();
    }

    public void editItemProccess(String edit) {

        getEditItemField().sendKeys(edit);
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public void clickOnSearchField() {

        getSearchField().click();
    }

    public void enterCityProccess(String enterCity) {

        getSearchField().sendKeys(enterCity);
    }

    public WebElement getFirstCityName() {

        return getDriver().findElement(firstCityName);
    }

    public WebElement getDeleteButton() {
        
        return getDriver().findElement(deleteButton);
    }

    public void clickOnDeleteButton() {

        getDeleteButton().click();
    }

    public WebElement getPopupWarningMessage() {

        return getDriver().findElement(popupWarningMessage);
    }

    public WebElement getDeleteInPopup() {

        return getDriver().findElement(deleteInPopup);
    }

    public void clickOnDeleteInPopup() {

        getDeleteInPopup().click();
    }

    public WebElement getDeleteSuccessfullyMessage() {

        return getDriver().findElement(deleteSuccessfullyMessage);
    }


}
