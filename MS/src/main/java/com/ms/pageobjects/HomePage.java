/**
 * 
 */
package com.ms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ms.actiondriver.Action;
import com.ms.base.BaseClass;

/**
 * @author rkattuparambil
 *
 */
public class HomePage extends BaseClass  {
	
	Action action=new Action();
	
	
	
	@FindBy(xpath="//a[.='Women']")
	 WebElement WomenTab;
	
	
	
	public HomePage()
	{
		
		PageFactory.initElements(getDriver(),this);	
		
		
	
	}
	
	public WomenPage clickOnWomenLink()
	
	
	{
		action.switchToFrameById(getDriver(), "iframe");
		action.explicitWait(getDriver(), WomenTab, 10);
		//action.click(getDriver(), WomenTab);
		action.highLight(getDriver(), WomenTab);
		action.JSClick(getDriver(), WomenTab);
		
		return new WomenPage();
	}

}
