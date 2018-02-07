package com.gearbest;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Mainflow {
	public static void main(String[] args) throws InterruptedException {

		String browser = "chrome";
		String url = "https://login.gearbest.com/m-users-a-sign.htm?type=1";
		String fbLinkXpath = "//a[@id='loginFaceBook']";
		String fbEmailXpath = "//input[@id='email']";
		String fbEmailValue = "harilal.ib@gmail.com";
		String fbPassXpath = "//input[@id='pass']";
		String fbPassValue = "<password>";
		String fbLoginXpath = "//input[@name='login' and @type='submit']";

		BrowserInteraction browserClassInstance = new BrowserInteraction();
		browserClassInstance.setDriver(browser);
		WebDriver driver = browserClassInstance.getDriver();
		driver.get(url);
		browserClassInstance.click(fbLinkXpath);
		String parenthandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!(handle.equals(parenthandle))) {
				driver.switchTo().window(handle);
				browserClassInstance.enterText(fbEmailXpath, fbEmailValue);
				browserClassInstance.enterText(fbPassXpath, fbPassValue);
				browserClassInstance.click(fbLoginXpath);

			}
		}

	}
}
