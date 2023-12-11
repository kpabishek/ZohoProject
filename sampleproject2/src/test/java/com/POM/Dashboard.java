package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	WebDriver driver;

	public Dashboard(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[data-title='List View']")
	WebElement listview;

	@FindBy(css = "button[id='grid']")
	WebElement gridview;

	@FindBy(xpath = "/html/body/div[3]/div[1]/div[4]/div[4]/div[8]/div[1]/div[2]/div[7]/div/div[1]/ul[2]/li[6]/div/button")
	WebElement threedots;

	@FindBy(xpath = "//span[normalize-space()='Make a Copy']")
	WebElement makeacopy;

	@FindBy(xpath = "//button[contains(text(),'Make a Copy')]")
	WebElement copythepresentation;

	@FindBy(xpath = "//button[@id='create_new_presentation']//span[contains(text(),'New Presentation')]")
	WebElement createpresentation;

	@FindBy(xpath = "//button[contains(text(),'Choose Theme')]")
	WebElement choosetheme;

	@FindBy(css = "span[id='zsdocumentnamenonedit']")
	WebElement title;

	@FindBy(xpath = "//div[@id='file']/a[contains(text(),'File')]")
	WebElement selectfile;

	@FindBy(xpath = "//span[contains(text(),'Project')]")
	WebElement recentfile;

	@FindBy(xpath = "//span[contains(text(),'Add Comment')]")
	WebElement addcomments;

	@FindBy(css = "rect[id='textEditingDiv']")
	WebElement writeacomment;

	@FindBy(xpath = "//div[@id='postCommentList']")
	WebElement postacomment;

	@FindBy(xpath = "//span[contains(text(),'Resolve')]")
	WebElement resolveit;

	@FindBy(css = "input[id='zsdocumentname']")
	WebElement rename;

	@FindBy(xpath = "//span[normalize-space()='Duplicate Slide']")
	WebElement duplicateslide;

	@FindBy(xpath = "//span[normalize-space()='Comparison']")
	WebElement selectlayout;

	public void Selectlayout() {
		selectlayout.click();
	}

	public void DuplicateSlide() {
		duplicateslide.click();
	}

	public void Rename() {
		rename.sendKeys("rename");
	}

	public void Resolvecomment() {
		resolveit.click();
	}

	public void Postacomment() {
		postacomment.click();
	}

	public void WriteaComment() {
//		writeacomment.click();
		writeacomment.sendKeys("test writing");
	}

	public void AddComments() {
		addcomments.click();
	}

	public void RecentFile() {
		recentfile.click();
	}

	public void SelectFile() {
		selectfile.click();
	}

	public void RenameTitle() throws InterruptedException {
		title.click();
	}

	public void RenameTitles() throws InterruptedException {
		title.clear();
	}

	public void RenameTitless() throws InterruptedException {
		title.sendKeys("Renamed presentation");
	}

	public void ListView() {
		listview.click();
	}

	public void GridView() {
		gridview.click();
	}

	public void ClickThreedots() {
		threedots.click();
	}

	public void ClickMakeacopy() {
		makeacopy.click();
	}

	public void Copythepresentation() {
		copythepresentation.click();
	}

	public void CreateNewPresentation() {
		createpresentation.click();
	}

	public void ChooseTheme() throws InterruptedException {
		Thread.sleep(5000);
		choosetheme.click();
	}

}
