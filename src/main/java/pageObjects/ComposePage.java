package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends BasePage{
    @FindBy(xpath = "//android.widget.EditText")
    private WebElement toField;

    @FindBy(xpath = "//android.webkit.WebView/android.widget.EditText")
    private WebElement textField;

    @FindBy(id="subject")
    private WebElement subjectField;

    @FindBy(id="peoplekit_listview_flattened_row")
    private WebElement toAccount;

    @FindBy(id="body")
    private WebElement textield;

    @FindBy(id="send")
    private WebElement sendButton;


    public ComposePage writeRecipient(String recipient){
        toField.sendKeys(recipient);
        return this;
    }

    public ComposePage clickToAccount(){
        toAccount.click();
        return this;
    }

    public ComposePage writeSubject(String subject){
        subjectField.sendKeys(subject);
        return this;
    }

    public ComposePage writeLetter(String text){
        textField.sendKeys(text);
        return this;
    }

    public ComposePage clickSend(){
        sendButton.click();
        return this;
    }
}
