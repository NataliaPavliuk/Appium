import driver.AndroidDriverSingleton;
import org.testng.annotations.AfterTest;

public class BaseTest {
    @AfterTest
    public void quiteDriver(){
        AndroidDriverSingleton.quitDriver();
    }
}
