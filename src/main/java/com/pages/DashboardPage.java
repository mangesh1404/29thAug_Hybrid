package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	@FindBy(tagName="h3")
	private List<WebElement> courses;
	
	@FindBy(xpath="//span[text()='Users']")
	private WebElement userlink;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ArrayList<String> verifyCourses() {
		ArrayList<String> actualCourseNames= new ArrayList<String>();
		for(WebElement course: courses)
		{
			String text = course.getText();
			actualCourseNames.add(text);
		}	
		return actualCourseNames;
	}
	
	public UserPage clickUsersLink() {
		userlink.click();
		return new UserPage(driver);
	}
	
}
