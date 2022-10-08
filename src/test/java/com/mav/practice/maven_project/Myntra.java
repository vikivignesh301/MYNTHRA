package com.mav.practice.maven_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static WebDriver driver;
	public static int minprice;
	public static String brand;

	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
	}

	public static void productCount() {
		WebElement kids = driver.findElement(By.xpath("//a[@data-group='kids']"));
		Actions a = new Actions(driver);
		a.moveToElement(kids).build().perform();
		WebElement tshirt = driver.findElement(By.xpath("//a[@data-reactid='345']"));
		tshirt.click();
		List<WebElement> productcount = driver.findElements(By.xpath("//li[@class='product-base']"));
		System.out.println("total count of products is : " + productcount.size());
	}

	public static void minPrice() {
		List<WebElement> totalproductprice = driver.findElements(
				By.xpath("//li[@class='product-base']//descendant::span[@class='product-discountedPrice']"));
		List<Integer> l = new ArrayList<>();
		for (WebElement singleproduct : totalproductprice) {
			String productprice = singleproduct.getText().replace("Rs. ", "");
			int price = Integer.parseInt(productprice);
			l.add(price);
		}
		minprice = Collections.min(l);
		System.out.println("min price of all products is :" + minprice);
	}

	public static void brandName(int min_price) {

		WebElement brandname = driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[text()='"
				+ min_price + "']//ancestor::div[@class='product-productMetaInfo']/h3"));
		String text = brandname.getText();
		brand = text; 
		System.out.println("brand name of min price is : "+brand);
	}

	public static void subBrand(String brand_name) {
		WebElement subbrand = driver.findElement(
				By.xpath("//h3[text()='" + brand_name + "']//following-sibling::h4[@class='product-product']"));
		System.out.println("subbrand name of brand is : " + subbrand.getText());
	}						

	public static void main(String[] args) {
		browserLaunch();
		productCount();
		minPrice();
		brandName(minprice);
		subBrand(brand);
	}
}