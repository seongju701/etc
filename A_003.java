package tests;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.junit.Test;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cj.util.SmartProperties;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class A_003 {
	private WebDriver driver;
	String devices = null;
	@Before
	public void setUp() throws Exception {
		SmartProperties sp = SmartProperties.getInstance();
		devices = sp.getProperty("devices");
		System.out.println(devices);
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", devices);
		caps.setCapability("udid", devices); // 핸드폰 adb devices 값 입력
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("appPackage", "com.android.vending"); 
		caps.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity");
		caps.setCapability("noReset", "true");
		URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
		System.out.println("Start driver.");
		driver = new AndroidDriver<WebElement>(appiumUrl, caps);
		
	}

	@Test
	 public void ScrollToText() throws InterruptedException {
		  //Scroll till element which contains "Views" text If It Is not visible on screen.


		WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.android.vending:id/li_title\")).scrollIntoView("
						+ "new UiSelector().textContains(\"천녀유혼 for kakao\").instance(1))"));

		// Perform the action on the element
		System.out.println(element.getAttribute("text"));
		
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	public boolean existElement(WebDriver wd, By by, String meaning) {
		WebDriverWait wait = new WebDriverWait(wd, 2);
		// wait.ignoring(NoSuchElementException.class);

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (TimeoutException e) {

			System.out.println("[" + meaning + "] WebElement does not Exist. time out ");
			return false;
		}
		System.out.println("[" + meaning + "] WebElement Exist.");
		return true;
	}


	
}
