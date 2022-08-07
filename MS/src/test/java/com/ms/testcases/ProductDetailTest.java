package com.ms.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setup()
	{
		launchApp("Chrome");
	}


	@Test
	public void verifyProductDetailsInProductDetailPage() throws Exception

	{   
		MyScreenRecorder.startRecording("verifyProductDetailsInProductDetailPage");
		Log.startTestCase("verifyProductDetailsInProductDetailPage");

		homePage=new HomePage();
		womenPage=new WomenPage();

		productDetailPage=new ProductDetailPage();

		homePage.clickOnWomenLink();
		
		womenPage.clickOnSort();

		String productName=womenPage.FirstProductName();
		String productPrice=womenPage.FirstProductPrice();
		womenPage.clickOnFirstProduct();
		
		String productNameInDetailPage=productDetailPage.ProductNameInProductDetailPage();

		String productPriceInDetailPage=productDetailPage.ProductPriceInProductDetailPage();

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
