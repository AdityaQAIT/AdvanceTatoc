package com.qainfotech.automation.TatocAdvance;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdvanceCourse {
	

    JavascriptExecutor js;

	
	public AdvanceCourse(JavascriptExecutor js) {
		this.js = js;
	}

	public HoverMenu ClickOnAdvanceCourseLink() {
		js.executeScript("document.querySelector(\".page>a[href='/tatoc/advanced']\").click()");
		Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent"), "Hover Menu");
		return new HoverMenu(js);		
	}

	

}
