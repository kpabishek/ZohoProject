package com.stepdefinition;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.POM.Dashboard;
import com.utli.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass {
	Dashboard zoho = new Dashboard(driver);

	@Test
	@Given("launching zoho presentation screen")
	public void launching_zoho_presentation_screen() {
		
		System.out.println("User navigates to the presentation screen");
		/*
		 * Thread.sleep(5000); driver.findElement(By.
		 * cssSelector("input[placeholder='Email address or mobile number']"))
		 * .sendKeys("georgeabishek03@gmail.com");                                              // I logged in using credentials as the jar file was not working for me
		 * driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		 * driver.findElement(By.cssSelector("input[placeholder='Enter password']")).
		 * sendKeys("********");
		 * driver.findElement(By.cssSelector("button[id='nextbtn']")).click();
		 */
	}

	@When("in presentation screen click Listview")
	public void in_presentation_screen_click_listview() 
	{
		zoho.ListView();
	}

	@Then("click Grid view")
	public void click_grid_view() 
	{
//		dash.GridView();
	}

	@Then("make a copy of it")
	public void make_a_copy_of_it() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		actions.moveToElement(driver
				.findElement(By.xpath("//li[@id='079e8fdcdd950f18740749e54e3e104273979']//div[@class='ui-overflow']")))
				.perform();
		zoho.ClickThreedots();
		zoho.ClickMakeacopy();
		zoho.Copythepresentation();

	}

	@Given("user create a new presentation")
	public void user_create_a_new_presentation() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String oldwindow = driver.getWindowHandle();
		zoho.CreateNewPresentation();                        // new tab will be opened
		Set<String> handles = driver.getWindowHandles();
		for (String newwindow : handles) {
			driver.switchTo().window(newwindow);
		}

	}

	@When("user choose the theme")
	public void user_choose_the_theme() throws InterruptedException
	{
		zoho.ChooseTheme();
	}

	@Then("user changes the presentation name")
	public void user_changes_the_presentation_name()
    {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.cssSelector("span[id='zsdocumentnamenonedit']"))).click().build()
				.perform();
		ac.doubleClick(driver.findElement(By.cssSelector("input[id='zsdocumentname']"))).build().perform();
		ac.sendKeys(Keys.CONTROL + "a");
		ac.sendKeys(Keys.BACK_SPACE);
		zoho.Rename();
	}

	@Given("user is on presentation screen")
	public void user_is_on_presentation_screen() {
		System.out.println("User is on the presentation screen");
	}

	@When("user do right click and duplicate a slide")
	public void user_do_right_click_and_duplicate_a_slide() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='thumbnail_scrollable']"))).contextClick().build()
				.perform();
		zoho.DuplicateSlide();
	}

	@Given("user again do a right click to change the layout")
	public void user_again_do_a_right_click_to_change_the_layout() {
		
		Actions acts = new Actions(driver);
		acts.moveToElement(driver.findElement(By.xpath("(//div[@class='thumbnail_scrollable'])[2]"))).contextClick()
				.build().perform();
		acts.moveToElement(
				driver.findElement(By.xpath("//li[@id='changeLayout']//span[@class='ui-zmenu-icon-layout']"))).build()
				.perform();
		zoho.Selectlayout();

	}

	@Given("user selects a recent file from file option")
	public void user_selects_a_recent_file_from_file_option() {
		zoho.SelectFile();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Open Recent')]"))).perform();
		zoho.RecentFile();

	}

	@When("user will add a comment and post the comment")
	public void user_will_add_a_comment_and_post_the_comment() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions acti = new Actions(driver);
		acti.moveToElement(driver.findElement(By.xpath("(//div[@class='thumbnail_scrollable'])[2]"))).contextClick()
				.build().perform();
		zoho.AddComments();
		zoho.WriteaComment();
		zoho.Postacomment();
	}

	@Then("user Resolve the comment")
	public void user_Resolve_the_comment() {
		zoho.Resolvecomment();
		driver.quit();
	}
}
