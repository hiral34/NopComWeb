package InfoSys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils{

    public static LoadProp loadProp= new LoadProp();
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "HTTPS://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String strBrowser = System.getProperty("browser");
    public void closeBrowser()    {
        driver.quit();
    }
    public void openBrowser(){
        System.out.println(System.getProperty("Sauce"));
        System.out.println(System.getProperty("browser"));
        if (SAUCE_LAB) {
            System.out.println("Running in SauceLab............................................");

            if (strBrowser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 8");
                caps.setCapability("version", "78.0");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (strBrowser.equalsIgnoreCase("ie")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (strBrowser.equalsIgnoreCase("Firefox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on Firefox 56");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (strBrowser.equalsIgnoreCase("Safari")) {
                DesiredCapabilities caps = DesiredCapabilities.safari();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8.0");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (strBrowser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.edge();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");
                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid of empty browser: " + strBrowser);
            }
        }
        //if sauce lab is false..............................................................................................
        else{
            String strBrowser = loadProp.getProperty("browser");
            if(strBrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            }else if(strBrowser.equalsIgnoreCase("fireFox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            }else if(strBrowser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }else if(strBrowser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }else {
                System.out.println("Invalid of empty browser: " + strBrowser);
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
}
