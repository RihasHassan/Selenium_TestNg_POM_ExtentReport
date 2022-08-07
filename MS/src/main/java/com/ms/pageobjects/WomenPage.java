package com.ms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ms.actiondriver.Action;
import com.ms.base.BaseClass;

public class WomenPage extends BaseClass{

	Action action=new Action();


	@FindBy(xpath = "//select[@name='orderby']")
	WebElement sorting;


	@FindBy(xpath = "//ul[contains(@class,'products')]//li[1]//a//h2")
	WebElement firstProductName;

	@FindBy(xpath = "//ul[contains(@class,'products')]//li[1]//span[@class='price']//ins")
	WebElement firstProductPrice;

	public WomenPage()

	{  

		PageFactory.initElements(getDriver(),this);	



	}

	public void clickOnSort(String sortBy)    

	{
		action.highLight(getDriver(), sorting);

		action.selectByVisibleText(sortBy, sorting);
	}


	public String FirstProductName()

	{
		action.highLight(getDriver(), firstProductName);

		return action.getText(getDriver(), firstProductName);
	}

	public String FirstProductPrice()

	{

		action.highLight(getDriver(), firstProductPrice);

		String price=action.getText(getDriver(), firstProductPrice);

		String Price = price.replace("$","");
		System.out.println(Price);

		return Price;
	}


	public ProductDetailPage clickOnFirstProduct()

	{
		action.highLight(getDriver(), firstProductName);
		action.click(getDriver(), firstProductName);

		return new ProductDetailPage();

	}

}
