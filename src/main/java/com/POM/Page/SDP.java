package com.POM.Page;

import org.openqa.selenium.WebDriver;

public class SDP {

	public static WebDriver driver;

	public SDP(WebDriver driver2) {
		this.driver = driver2;
	}

	public Home_Page getHome_Page() {
		Home_Page h = new Home_Page(driver);
		return h;
	}

	public Product_Page getProduct_Page() {
		Product_Page p = new Product_Page(driver);
		return p;
	}
}
