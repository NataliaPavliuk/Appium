package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.PropertiesReader;


public class SentLetterPage extends BasePage{
   long DEFAULT_WAITING_TIME = new PropertiesReader().getDefaultWaitTime();

    @FindBy(id="subject")
    private WebElement subjectText;

    @FindBy(id="viewified_conversation_item_view")
    private WebElement sentLetter;

    @FindBy(id="empty_text")
    private WebElement emptyLetter;

    public String isSentLetterExist(String subject){
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, subjectText);
        return subjectText.getText();
    }

    public String isEmptyPage() throws InterruptedException {
        waitVisibilityOfElement(DEFAULT_WAITING_TIME, emptyLetter);
        Thread.sleep(1000);
        return emptyLetter.getText();
    }

    public SentLetterPage clickSentLetter(){
        sentLetter.click();
        return this;
    }
}
