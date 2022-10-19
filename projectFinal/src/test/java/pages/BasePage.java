package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;
    private WebDriver webDriverWait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWebDriverWait() {
        return getWebDriverWait();
    }

    public void setWebDriverWait(WebDriver webDriverWait) {
        this.driver = webDriverWait;
    }

}
