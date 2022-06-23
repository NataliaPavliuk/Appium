package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage{
    @FindBy(id="delete")
    private WebElement deleteButton;

    public LetterPage clickDeleteButton() throws InterruptedException {
        deleteButton.click();
        return this;
    }
}
