package com.GenericLibraries.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.ObjectRepositories.selenium.AddNewCategoryPage;
import com.ObjectRepositories.selenium.AddNewCoursePage;
import com.ObjectRepositories.selenium.AddNewUserPage;
import com.ObjectRepositories.selenium.CategoryPage;
import com.ObjectRepositories.selenium.CourseListPage;
import com.ObjectRepositories.selenium.HomePage;
import com.ObjectRepositories.selenium.LoginPage;
import com.ObjectRepositories.selenium.UsersPage;

public class BaseClass {
	
	//@BeforeSuite
	//@BeforeTest
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	protected LoginPage login;
	protected HomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage addUser;
	protected AddNewCoursePage addCourse;
	protected AddNewCategoryPage addCategory;
	
	
	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		
		property.propertiesIntit(IConstantPath.PROPERTIES_PATHS);
		driver = web.launchAndMaximizeBrowser(property.readFromProperties("browser"));
		web.waitTillElementsFound((Long.parseLong(property.readFromProperties("timeouts"))));
		
		sdriver = driver;
		sjutil = jutil;
		
	}
	@BeforeMethod
	public void methodConfig() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUserPage(driver);
		addCategory = new AddNewCategoryPage(driver);
		addCourse = new AddNewCoursePage(driver);
		
		excel.excelIntit(IConstantPath.EXCEL_PATH);
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(login.getPageHeader(), "Login");
		
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		
		Assert.assertEquals(home.getPageHeader(),"Home");
			
	}
	@AfterMethod
	public void methodTearDown() {
		home.signOutLink();
	}
	
	@AfterClass
	public void classTearDown() {
		web.quitAllWindow();
	}
	
}