package com.runner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import baseClass.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\VIGNESH S\\eclipse-workspace\\MYNTRA\\src\\test\\java\\com\\feature\\Myntra.feature", glue = "com.stepdefinition", monochrome = true, plugin = {
		"html:Reports/HtmlReport.html", "json:Reports/JsonReport.json", "junit:Reports/XmlReport.xml" })
public class RunnerClassMyntra {

	public static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = BaseClass.browserLaunch("chrome");
		BaseClass.implicitWait();
	}

	@AfterClass
	public static void tearDown() {
		BaseClass.windowClose();
	}

}
