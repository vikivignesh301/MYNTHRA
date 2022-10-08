package com.POM.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {

	public static WebDriver driver;

	@FindBy(xpath = "//li[@class='product-base']")
	private List<WebElement> productcount;

	@FindBy(xpath = "//li[@class='product-base']//descendant::span[@class='product-discountedPrice']")
	private List<WebElement> totalProductPrice;

	@FindBy(xpath = "//h3[text()='\" + brand + \"']//following-sibling::h4[@class='product-product']")
	private WebElement subbrand;

	public Product_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getProductcount() {
		return productcount;
	}

	public List<WebElement> getTotalProductPrice() {
		return totalProductPrice;
	}

	public WebElement getSubbrand() {
		return subbrand;
	}

	

}
