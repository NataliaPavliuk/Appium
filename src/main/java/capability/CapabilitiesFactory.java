package capability;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.PropertiesReader;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesFactory {
    private static final String PLATFORM_NAME_CAPABILITY="Android";
    private static final String DEVICE_NAME_CAPABILITY="Pixel2";
    private static final String UDID_CAPABILITY="emulator-5554";
    private static final String APP_PACKAGE_CAPABILITY="com.google.android.gm";
    private static final String APP_ACTIVITY_CAPABILITY="com.google.android.gm.ConversationListActivityGmail";
    private static final String DEFAULT_TIME_OUT_CAPABILITY="90";

    public static DesiredCapabilities getCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.UDID, UDID_CAPABILITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_CAPABILITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_CAPABILITY);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, DEFAULT_TIME_OUT_CAPABILITY);
        capabilities.setCapability("noReset", true);
        return capabilities;
    }

    public static URL getAppiumServerUrl(){
        try {
            return new URL(new PropertiesReader().getURL());
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        return null;
    }
}
