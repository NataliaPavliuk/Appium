package businessObjects;

import io.qameta.allure.Step;
import pageObjects.*;

public class GmailBuisnessObj {
    private final LetterPage letterPage;
    private final IncomePage incomePage;
    private final ComposePage composePage;
    private final SentLetterPage sentLetterPage;

    public GmailBuisnessObj() {
        incomePage=new IncomePage();
        composePage=new ComposePage();
        sentLetterPage=new SentLetterPage();
        letterPage=new LetterPage();
    }


    @Step("write letter")
    public GmailBuisnessObj sendLetter(String recipient, String subject, String text){
        incomePage.clickComposeButton();
        composePage
                .writeRecipient(recipient)
                .clickToAccount()
                .writeSubject(subject)
                .writeLetter(text)
                .clickSend();
        return this;
    }

    @Step("open sent letters")
    public GmailBuisnessObj openSentLetters() throws InterruptedException {
        incomePage
                .clickNavigationDrawerButton()
                .clickSentButton();
        return this;
    }

    @Step("check is letter sent")
    public String isLetterSent(String subject) throws InterruptedException {
        return sentLetterPage.isSentLetterExist(subject);
    }

    @Step("delete letter")
    public GmailBuisnessObj deleteLetter() throws InterruptedException {
        sentLetterPage.clickSentLetter();
        letterPage.clickDeleteButton();
        return this;
    }

    @Step("check is letter deleted")
    public String isLetterDelete() throws InterruptedException {
        return sentLetterPage.isEmptyPage();
    }
}
