package com.qainfotech.automation.TatocAdvance;

import java.sql.SQLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestAdvancedTatoc {
	
	WebDriver driver;
	JavascriptExecutor js;
	AdvanceCourse advanceCourse;
	HoverMenu hovermenu;
	QueryGate queryGAte;
	Restful restful;
	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","//home//qainfotech//Downloads//chromedriver");
		driver = new ChromeDriver();
		js=(JavascriptExecutor)driver;
		driver.get("http://10.0.1.86/tatoc/");
		advanceCourse = new AdvanceCourse(js);
	}
	
	@AfterClass
	public void closeWindow() {
		driver.close();
	}
	
	@Test
	public void Step_1_AdvancedCourseLink() {
	    hovermenu=	advanceCourse.ClickOnAdvanceCourseLink();
	}
	 @Test(dependsOnMethods= {"Step_1_AdvancedCourseLink"})
	 public void Step2_HoverMenuGoNExt() {
		queryGAte= hovermenu.HoverMenuAndClickGoNext();
	 }
	 
	 @Test (dependsOnMethods= {"Step2_HoverMenuGoNExt"})
	 public void Step3_QueryGAtePageTest() throws ClassNotFoundException, SQLException {
		 queryGAte.EnterCorrectCredentials();
		
	 }
	 

	
	
	

}
