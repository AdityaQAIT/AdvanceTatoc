package com.qainfotech.automation.TatocAdvance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class QueryGate {
	
	JavascriptExecutor js;
	
	public QueryGate(JavascriptExecutor js) {
		this.js = js;
	}

	public Connection EstablishConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://10.0.1.86/tatoc","tatocuser","tatoc01");
		return con;
	}
	
	public String[] getCredentials(String symbol) throws ClassNotFoundException, SQLException {
		String[] cred = new String[2];
		int id=0;
		Statement stmt = EstablishConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from identity where symbol='"+symbol+"'");
	    if(rs.next()) {
	    	id=rs.getInt("id");
	    }
	    
	    rs = stmt.executeQuery("select * from credentials where id="+id+"");
	    if(rs.next()) {
	    	cred[0]=rs.getString("name");
	    	cred[1]=rs.getString("passkey");
	    }
	    
	    return cred;
	}


		public void EnterCorrectCredentials() throws ClassNotFoundException, SQLException{
			String[] cred = getCredentials((String)js.executeScript("return document.getElementById('symboldisplay').textContent"));
		    js.executeScript("document.getElementById('name').value='"+cred[0]+"'");
		    js.executeScript("document.getElementById('passkey').value='"+cred[1]+"'");
		    js.executeScript("document.getElementById('submit').click()");
			Assert.assertEquals(js.executeScript("return document.querySelector(\".page>h1\").textContent"), "Ooyala Video Player");
			js.executeScript("window.open");
	}

}
