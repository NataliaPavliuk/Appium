import businessObjects.GmailBuisnessObj;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.JsonReader;

import java.lang.reflect.Method;

import static util.ExtendTestManager.startTest;

@Listeners({ CustomerTestLisener.class })
@Epic("Tests")
@Feature("Gmail tests")
public class GmailTest extends BaseTest{
    private final GmailBuisnessObj gmailBuisnessObj=new GmailBuisnessObj();

    @DataProvider(name = "dp")
    public Object[][] readJson(){
        JsonReader jsonReader=new JsonReader();
        jsonReader.jsonReader();
        JsonArray data=jsonReader.getData();
        String[][] arr = new String[1][data.size()-1];
            JsonObject field = (JsonObject) data.get(0);
            String recipient= (String) field.get("recipient");
            String subject= (String) field.get("subject");
            String text= (String) field.get("text");
            arr[0][0] = recipient+ "," + subject+","+text;
        return arr;
    }


    @Test(dataProvider="dp", description = "Check letter")
    public void Test(String data, Method method) throws InterruptedException {
        startTest(method.getName(), "Check letter");
        String[] field = data.split(",");
        JsonReader jsonReader=new JsonReader();
        jsonReader.jsonReader();
        gmailBuisnessObj
                .sendLetter(field[0], field[1], field[2])
                .openSentLetters();
        Assert.assertEquals(gmailBuisnessObj.isLetterSent(field[1]), field[1]);
        gmailBuisnessObj.deleteLetter();
        Assert.assertEquals(gmailBuisnessObj.isLetterDelete(),"Nothing in Sent");
    }
}
