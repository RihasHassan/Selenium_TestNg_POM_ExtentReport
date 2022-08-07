package com.ms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ms.base.BaseClass;
import com.ms.pageobjects.HomePage;
import com.ms.pageobjects.ProductDetailPage;
import com.ms.pageobjects.WomenPage;
import com.ms.utility.Log;
import com.ms.utility.MyScreenRecorder;

public class ProductDetailTest extends BaseClass{


	private HomePage homePage;

	private WomenPage womenPage;

	ProductDetailPage productDetailPage;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		launchApp(browser);
	}

	@Test
	public void verifyProductDetailsInProductDetailPage() throws Exception

	{   
		MyScreenRecorder.startRecording("verifyProductDetailsInProductDetailPage");
		Log.startTestCase("verifyProductDetailsInProductDetailPage");

		homePage=new HomePage();
		womenPage=new WomenPage();
        productDetailPage=new ProductDetailPage();

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

		//Product detail check in product detail page 
		
        Log.info("Verifying product details in product details page");

		
		Assert.assertEquals(productNameInDetailPage,productName);
		Assert.assertEquals(productPriceInDetailPage, productPrice);
		
		MyScreenRecorder.stopRecording();
		Log.endTestCase("verifyProductDetailsInProductDetailPage");
	}





	@AfterMethod

	public void tearDown()
	{
		
		getDriver().quit();
	}


}
