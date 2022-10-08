package com.POM.Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public static WebDriver driver;

	@FindBy(xpath = "//a[@data-group='kids']")
	private WebElement kids;

	@FindBy(xpath = "//a[@data-reactid='345']")
	private WebElement tshirt;

	public Home_Page(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getKids() {
		return kids;
	}

	public WebElement getTshirt() {
		return tshirt;
	}

}
