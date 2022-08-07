package com.ms.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ms.actiondriver.Action;
import com.ms.base.BaseClass;

public class CartPage extends BaseClass{

	Action action=new Action();


	@FindBy(xpath="//td[@class='product-name']")
	WebElement productNameInCartPage;

	@FindBy(xpath="//td[@class='product-price']")
	WebElement productPriceInCartPage;



	@FindBy(xpath="//td[@class='product-quantity']//input")
	WebElement productQuantityInCartPage;

	@FindBy(xpath="//td[@class='product-subtotal']")
	WebElement productSubTotalPriceInCartPage;

	@FindBy(xpath="//tr[@class='order-total']//td")
	WebElement productTotalPriceInCartPage;

	@FindBy(xpath="//a[.='Change address']")
	WebElement changeAdresslink;
	
	@FindBy(xpath="//span[contains(@id,'country')]")
    WebElement countrySelection;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement countryTextField;
	
	@FindBy(xpath="//select[@id='calc_shipping_country']")
	WebElement countrydropdown;
	
	@FindBy(xpath="//ul[contains(@id,'shipping_country')]//li[.='India']")
	WebElement countryIndia;
	
	@FindBy(xpath="//span[contains(@id,'state')]")
	WebElement stateSelection;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement stateTextField;
	
	@FindBy(xpath="//ul[contains(@id,'shipping_state')]//li[.='Kerala']")
	WebElement stateKerala;
	
	@FindBy(xpath="//input[@id='calc_shipping_city']")
	WebElement cityTextField;
	
	@FindBy(xpath="//input[@id='calc_shipping_postcode']")
	WebElement postCodeTextField;
	
	@FindBy(xpath="//button[@name='calc_shipping']")
	WebElement updateBtn;
	
	@FindBy(xpath="//a[contains(@class,'checkout')]")
	WebElement ProceedTocheckOutBtn;
	
	
	
	
	
	
	
	
	

	public CartPage()
	{

		PageFactory.initElements(getDriver(),this);	



	}

	public String ProductPriceInProductCartPage()

	{
		action.highLight(getDriver(), productPriceInCartPage);
		String ProductPriceInProductCartPage=action.getText(getDriver(), productPriceInCartPage);

		ProductPriceInProductCartPage = ProductPriceInProductCartPage.replace("$","");

		return ProductPriceInProductCartPage;


	}

	public String ProductNameInProductCartPage()

	{
		action.highLight(getDriver(), productNameInCartPage);
		String productNameInProductCartPage=action.getText(getDriver(), productNameInCartPage);



		return productNameInProductCartPage;


	}

	public String ProductQuantityInProductCartPage()

	{
		action.highLight(getDriver(), productQuantityInCartPage);
		//String ProductQuantityInProductCartPage=action.getText(getDriver(), productQuantityInCartPage);

		String ProductQuantityInProductCartPage=productQuantityInCartPage.getAttribute("value");

		return ProductQuantityInProductCartPage;


	}


	public Double productSubTotalPriceInCartPage()

	{     action.highLight(getDriver(), productSubTotalPriceInCartPage);

	String TotalPriceInCartPage=action.getText(getDriver(), productSubTotalPriceInCartPage);

	TotalPriceInCartPage = TotalPriceInCartPage.replace("$","");


	Double priceInt = Double.parseDouble(TotalPriceInCartPage);

	return priceInt;


	}


	public Double verifySubTotalPrice()

	{


		String quantity=prop.getProperty("productQuantity");
		int number = Integer.parseInt(quantity);

		String price=ProductPriceInProductCartPage();

		Double priceInt = Double.parseDouble(price);

		Double total=priceInt*number;

		return total;


	}


	public Double productTotalPriceInCartPage()

	{  

		action.scrollByVisibilityOfElement(getDriver(), productTotalPriceInCartPage);
		action.highLight(getDriver(), productTotalPriceInCartPage);

		String TotalPriceInCartPage=action.getText(getDriver(),productTotalPriceInCartPage);

		TotalPriceInCartPage = TotalPriceInCartPage.replace("$","");


		Double priceInt = Double.parseDouble(TotalPriceInCartPage);

		return priceInt;


	}

	public Double verifyTotalPrice()

	{


		String quantity=prop.getProperty("productQuantity");
		String FlatRate=prop.getProperty("FlatRate");

		int Quantitynumber = Integer.parseInt(quantity);
		Double FlateRatenumber = Double.parseDouble(FlatRate);

		String price=ProductPriceInProductCartPage();

		Double priceInt = Double.parseDouble(price);

		Double total=(priceInt*Quantitynumber)+FlateRatenumber;

		return total;


	}
	
	
	public void clickOnaddress()
	{
		
		
		action.click(getDriver(), changeAdresslink);
	}
	
	public void selectingCountry()
	{
		action.click(getDriver(), countrySelection);
		action.type(countryTextField, "ind");
		
		action.click(getDriver(), countryIndia);
	    
	}
	
	
	public void selectingState()
	{
		
		action.click(getDriver(), stateSelection);
		//action.type(countryTextField, "ind");
		
		action.click(getDriver(), stateKerala);
	    
	}
	
	

	
	public void enteringCity()
	{
		String city=action.randomStringGenerator(getDriver(), 6);
		action.type(cityTextField, city);
		
	}

	
	public void enteringPostalCode()
	{
		action.type(postCodeTextField, "680685");
	}
	
	public void clickOnUpdate()
	{
		action.click(getDriver(), updateBtn);
		
	}

	public void clickOnProceedTocheckOut()
	{
		action.explicitWait(getDriver(), ProceedTocheckOutBtn, 10);
		action.JSClick(getDriver(), ProceedTocheckOutBtn);
		
	}

}
