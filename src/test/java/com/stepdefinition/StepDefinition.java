package com.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.POM.Page.SDP;
import com.runner.RunnerClassMyntra;

import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = RunnerClassMyntra.driver;
	public static List<Integer> l;
	public static int minprice;
	public static String brand;
	public static List<WebElement> totalproductprice;
	SDP st = new SDP(driver);

	@Given("user Launch The Url")
	public void user_launch_the_url() {
		launchUrl("https://www.myntra.com/");

	}

	@When("user Mouseover To Kids Section")
	public void user_mouseover_to_kids_section() {
		actionMethod(st.getHome_Page().getKids(), "MTE");
	}

	@When("select For T-Shirt")
	public void select_for_t_shirt() {
		clickonElement(st.getHome_Page().getTshirt());
	}

	@Then("getting The Count Of The Product")
	public void getting_the_count_of_the_product() {
		List<WebElement> productcount = st.getProduct_Page().getProductcount();
		System.out.println("total count of products is : " + productcount.size());
	}

	@When("taking X-path For Discounted Price With Reference Of product Base")
	public void taking_x_path_for_discounted_price_with_reference_of_product_base() {
		totalproductprice = st.getProduct_Page().getTotalProductPrice();
	}

	@When("add All Price To The List")
	public void add_all_price_to_the_list() {
		l = new ArrayList<>();
		for (WebElement singleproduct : totalproductprice) {
			String productprice = singleproduct.getText().replace("Rs. ", "");
			int price = Integer.parseInt(productprice);
			l.add(price);
		}
	}

	@Then("getting Min Price")
	public void getting_min_price() {
		minprice = Collections.min(l);
		System.out.println("min price of all products is :" + minprice);
	}

	@When("user Pass The Min Price On X-path")
	public void user_pass_the_min_price_on_x_path() {
		WebElement brandname = driver.findElement(By.xpath("//li[@class='product-base']//descendant::span[text()='"
				+ minprice + "']//ancestor::div[@class='product-productMetaInfo']/h3"));
		String text = brandname.getText();
		brand = text;
	}

	@Then("validate The Brand name")
	public void validate_the_brand_name() {
		System.out.println("brand name of min price is : " + brand);
	}

	@Then("getting The Sub-brand Name")
	public void getting_the_sub_brand_name() {
		WebElement subbrand = driver.findElement(By.xpath("//h3[text()='" + brand + "']//following-sibling::h4[@class='product-product']"));
		System.out.println("subbrand name of brand is : " + subbrand.getText());
	}

}
