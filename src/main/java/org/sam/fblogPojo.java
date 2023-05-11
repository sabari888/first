package org.sam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fblogPojo extends BaseClass {
public fblogPojo() {
	PageFactory.initElements(driver, this);
}
	@FindBy(id="email")
	private WebElement email;
	@FindBy(xpath ="//input[@type='password']")
	private WebElement pass;
	@FindBy(name="login")
	private WebElement logBtn;
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getLogBtn() {
		return logBtn;
	}
}


