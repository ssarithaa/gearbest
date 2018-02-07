package com.gearbest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInteraction {
	private WebDriver driver;

	void setDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/saritha.pattathil/geckodriver.exe");// to do: remove
																										// path
																										// reference
			this.driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/saritha.pattathil/chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		default:
			System.out.println("Unsupported browser");

		}

	}

	WebDriver getDriver() {
		if (this.driver == null) {
			this.setDriver(null);
		}

		return this.driver;

	}

	void click(String elementXpath) {
		this.driver.findElement(By.xpath(elementXpath)).click();

	}

	void enterText(String elemantXpath, String ValueToEnter) {
		this.driver.findElement(By.xpath(elemantXpath)).sendKeys(ValueToEnter);
	}

}
