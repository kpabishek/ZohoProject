package com.Listeners;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl extends ExtentReportListener implements ITestListener

{
	public void onTestStart(ITestResult result)
	{
	System.out.println("Method started"+ result.getName());	
	}
	
	public void onFinish(ITestContext contextFinish)
	{
	System.out.println("onFinish method finished");
	}

	public void onStart(ITestContext context) 
	{		
	}	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("Method failed with certain success percentage"+ result.getName());
	}
	
	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destfile= System.getProperty("user.dir")+"\\screenshot\\"+".png";
		try {
			FileUtils.copyFile(srcFile, new File(destfile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
	System.out.println("Method skipped"+ result.getName());
	}
		
	public void onTestSuccess(ITestResult result) {
		
	}

}
