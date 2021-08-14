package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class AdminPage extends Base{

	public AdminPage(WebDriver driver) {
		super(driver);
	}
	
	//Objects
	By imgHeaderOrange = By.xpath("//img[@alt='OrangeHRM']");
	By lnkAdmin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtSearchUsername = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearch = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	
	public void validateLogged() {
		reporter("Validate Logged successfully");
		waitForElementPresent(imgHeaderOrange);		
	}
	
	public void clickAdmin() {
		reporter("Click Admin Module");
		click(lnkAdmin);
		implicitlyWait();
	}
	
	public void searchUser(String username) {
		reporter("Searching... "+username);
		type(txtSearchUsername, username);
		click(btnSearch);
		implicitlyWait();
	}
	
	public void validateUsernameTable(String username) {
		reporter("Verify this value: " + username + " in Admin user table");
		assertEquals(getText(tblUsername), username);
	}
	
	/*
	 * Verify user exist in table after click search
	 * @param (Wrapper)
	 */
	public void verifyUserExistsTableAfterClickSearch(String username) {
		clickAdmin();
		searchUser(username);
		validateUsernameTable(username);
	}
}
