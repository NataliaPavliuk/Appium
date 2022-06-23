package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertiesReader;

public class IncomePage extends BasePage{
    long DEFAULT_WAITING_TIME = new PropertiesReader().getDefaultWaitTime();

    @FindBy(id="compose_button")
    private WebElement composeButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private WebElement navigationDrawerButton;

    @FindBy(xpath = "//android.widget.LinearLayout//android.widget.TextView[@text='Sent']")
    private WebElement sentButton;


    public IncomePage clickComposeButton(){
        composeButton.click();
        return this;
    }

    public IncomePage clickNavigationDrawerButton(){
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, navigationDrawerButton);
        waitForElementIsClicable(DEFAULT_WAITING_TIME, navigationDrawerButton);
        navigationDrawerButton.click();
        return this;
    }

    public IncomePage clickSentButton(){
        sentButton.click();
        return this;
    }

}
