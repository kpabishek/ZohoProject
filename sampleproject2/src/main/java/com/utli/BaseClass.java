package com.utli;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zoho.login.LoginZoho;

public class BaseClass {

	public static WebDriver driver;
	public static final String BASE_URL = "https://accounts.zoho.in/signin?servicename=ZohoShow&signupurl=https://show.zoho.in/show/signup&serviceurl=https%3A%2F%2Fshow.zoho.in%2Fhome%2Fpresentations%2Frecents%2Fmodified%2Fdescending%2Fgrid";

	public static WebDriver launch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "D:\\chrome\\win64\\chromedriver.exe");
			//options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();		
			  LoginZoho logshow = new LoginZoho(); 
			  logshow.setAuth(
			  "1b351563becb2fe9a569ee89a04ea84d18724f400ce7aefe819d768e4d3156d10366444b3cec6efc21491cb5719c5d159b74ffab3463f46dfc00015b5ca2e9ea",
			  "c0d09dad5df241ca0c57afe3a8a1b4e7c2c501368d96a45d1c613bcb865623a39850e4da6ed80ada294e5b438957a25194522a4839bebd01cf41a8c746e72ff0",
			  driver);
			 
			 
			

		} else {
			System.out.println("INVALID BROWSER");
		}
		if (driver != null) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(BASE_URL);
		}
		return driver;
	}

	public static WebElement findElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}


}
