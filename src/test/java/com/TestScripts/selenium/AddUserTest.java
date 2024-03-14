package com.TestScripts.selenium;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericLibraries.selenium.BaseClass;

public class AddUserTest extends BaseClass {
		@Test
		public void addUserTest() {
			SoftAssert soft= new SoftAssert();
			home.clickUserTab();
			soft.assertTrue(users.getPageHeader().contains("Users"));
			users.clickNewButton();
			soft.assertEquals(addUser.getPageHeader(), "Add New User");
			
			Map<String, String> map=excel.readFromExcel("Sheet1", "Add User");
			addUser.setEmail(map.get("Email"));
			addUser.setPwd(map.get("Password"));
			addUser.setFirstName(map.get("Firstname"));
			addUser.setLastName(map.get("Lastname"));
			addUser.setAddress(map.get("Address"));
			addUser.setContact(map.get("Contact Info"));
			addUser.uploadPhoto(map.get("Photo"));
			addUser.clickSave();
			
			soft.assertTrue(users.getSuccessAlertMesssage().contains("Success"));
			soft.assertAll();
		}
}