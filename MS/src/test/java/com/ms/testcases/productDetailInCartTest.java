package com.ms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ms.base.BaseClass;
import com.ms.pageobjects.CartPage;
import com.ms.pageobjects.HomePage;
import com.ms.pageobjects.ProductDetailPage;
import com.ms.pageobjects.WomenPage;
import com.ms.utility.Log;
import com.ms.utility.MyScreenRecorder;

public class productDetailInCartTest extends BaseClass{
	
	
	private HomePage homePage;

	private WomenPage womenPage;

	ProductDetailPage productDetailPage;
	CartPage cartPage;
    
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		launchApp(browser);
	}


	@Test
	public void verifyProductDetailsInCart() throws Exception

	{
		MyScreenRecorder.startRecording("verifyProductDetailsInCart");
		Log.startTestCase("verifyProductDetailsInCart");
		homePage=new HomePage();
		womenPage=new WomenPage();
        productDetailPage=new ProductDetailPage();
        cartPage=new CartPage();
        
        String addingQuantity=prop.getProperty("productQuantity");
        
        Log.info("Clicking on womens Tab");
        
		homePage.clickOnWomenLink();
		
		
        Log.info("Clicking on Sorting");

		womenPage.clickOnSort("Sort by average rating");

		String productName=womenPage.FirstProductName();
		String productPrice=womenPage.FirstProductPrice();
		
		
        Log.info("Clicking on First product on listing");

		
		womenPage.clickOnFirstProduct();
		
		String productNameInDetailPage=productDetailPage.ProductNameInProductDetailPage();

		String productPriceInDetailPage=productDetailPage.ProductPriceInProductDetailPage();
		
        Log.info("Adding quantity");

		productDetailPage.addingQuantity(addingQuantity);
		
        Log.info("Clicking on Add to cart");

		productDetailPage.clickingOnAddToCart();
		
        Log.info("Clicking on View cart");

		
		productDetailPage.clickingOnViewCart();
		
		String ProductNameInProductCartPage=cartPage.ProductNameInProductCartPage();
		String ProductPriceInProductCartPage=cartPage.ProductPriceInProductCartPage();
	    String ProductQuantityInProductCartPage= cartPage.ProductQuantityInProductCartPage();
	    
	    Double actualSubTotalPrice=cartPage.productSubTotalPriceInCartPage();
	    Double expectedSubTotal=cartPage.verifySubTotalPrice();
	    
	    
        //Product Details Check in cart 
	    
        Log.info("Verifying product details in cart");

	    
		Assert.assertEquals(ProductNameInProductCartPage, productNameInDetailPage);
		Assert.assertEquals(ProductPriceInProductCartPage,productPriceInDetailPage);
		Assert.assertEquals(ProductQuantityInProductCartPage,addingQuantity);
		
        //Product SubTotal Check in cart 

		Assert.assertEquals(actualSubTotalPrice, expectedSubTotal);
		
        //Product Total Check in cart 
		
		
		Double actualTotalPrice=cartPage.productTotalPriceInCartPage();
	    Double expectedTotal=cartPage.verifyTotalPrice();
		
		Assert.assertEquals(actualTotalPrice, expectedTotal);
		
		//Entering Address 
		
        Log.info("Changing Address");

		
		cartPage.clickOnaddress();
		cartPage.selectingCountry();
		cartPage.selectingState();
		cartPage.enteringCity();
		cartPage.enteringPostalCode();
		
        Log.info("Clicking on update button");

		cartPage.clickOnUpdate();
		
        Log.info("Clicking on Proceed to checkout");

		cartPage.clickOnProceedTocheckOut();

	    
		
		Log.endTestCase("verifyProductDetailsInCart");
		MyScreenRecorder.stopRecording();
	}





	
	  @AfterMethod
	  
	  public void tearDown() {
	  
	  getDriver().quit(); }
	 


}
