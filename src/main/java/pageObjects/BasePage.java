package pageObjects;

import driver.AndroidDriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.AndroidDriverSingleton.getDriver;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void waitForElementIsClicable(long timeToWait, WebElement webElement) {
        new WebDriverWait(getDriver(), timeToWait).until(
                ExpectedConditions.elementToBeClickable(webElement) );
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWait).getSeconds());
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
