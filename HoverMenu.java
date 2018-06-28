package com.qainfotech.automation.TatocAdvance;



import org.openqa.selenium.JavascriptExecutor;

import junit.framework.Assert;

public class HoverMenu {
	
	JavascriptExecutor js;
	
	public HoverMenu(JavascriptExecutor js) {
		this.js = js;
	}

	public QueryGate HoverMenuAndClickGoNext() {
		js.executeScript("document.querySelector(\"span[onclick]\").click();");		
		Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent"), "Query Gate");
	    return new QueryGate(js);
	}


}
