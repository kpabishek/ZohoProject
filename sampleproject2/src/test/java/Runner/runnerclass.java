package Runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.utli.BaseClass;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
				
		features ="src/test/resources/featurefolder/",
		glue= {"com.stepdefinition"},
		//tags = "@z or@o or @h",
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		monochrome=true
		
		
		)

public class runnerclass extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	@BeforeClass
	public void sample() throws InterruptedException{
		driver=BaseClass.launch("chrome");
	}
	

}
