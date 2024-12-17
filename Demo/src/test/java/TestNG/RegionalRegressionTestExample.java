package TestNG;

import java.util.Random;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampDetailedPage;
import Object_Repo.CampValidationPage;
import Object_Repo.ContactDetailedPage;
import Object_Repo.ContactValidationPage;
import Object_Repo.CreateCampPage;
import Object_Repo.CreateContactPage;
import Object_Repo.CreateProductPage;
import Object_Repo.ProductDetailedPage;
import Object_Repo.ProductValidationPage;
import Object_Repo.SwitchingWindowCapmWithProd;
import Object_Repo.ValidateCampaignsWithProduct;
import Object_Repo.VtigerHomePage;


public class RegionalRegressionTestExample extends BaseClass {
	@Test(groups="smoke")
	public void campaignWithProductTest() throws Throwable {
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility windowSwitching = new WebDriver_Utility();
		
		int ranNum=jlib.getRandomNum();
		String P1=elib.ReadExcelData("Products", 0, 0) + ranNum;
		String Campaign=elib.ReadExcelData("Campaign", 0, 0) + ranNum;


		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickProdLink();

		ProductDetailedPage img = new ProductDetailedPage(driver);
		img.clickProdLookUpImg();

		CreateProductPage createPage = new CreateProductPage(driver);
		createPage.enterprodName(P1);
		createPage.clickSaveButton();

		Thread.sleep(4000);

		home.ClickMoreLink();
		home.clickCampLink();
		CampDetailedPage img1 = new CampDetailedPage(driver);
		img1.clickCampLookUpImg();

		CreateCampPage createPage1 = new CreateCampPage(driver);
		createPage1.enterCampName(Campaign);
		createPage1.clickSelectButton();

		Thread.sleep(4000);

		windowSwitching.windowSwitching(driver, "Product&action");

		SwitchingWindowCapmWithProd switchProd=new SwitchingWindowCapmWithProd(driver);
		switchProd.enterProdNameInCamp(P1);
		switchProd.clickOnSearchBar();
		switchProd.clickProductName(driver, P1);


		windowSwitching.windowSwitching(driver, "Campaign&action");
		createPage1.clickSaveButton();

		ValidateCampaignsWithProduct validate=new ValidateCampaignsWithProduct(driver);
		validate.validateCampName(driver, Campaign);
		validate.validatePrdName(driver, P1);
	}
	@Test(groups="regression")
	
	public void CreateCampaignTest() throws Throwable {
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		VtigerHomePage home=new VtigerHomePage(driver);
		home.ClickMoreLink();
		home.clickCampLink();
		
		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
		int ranNum=jlib.getRandomNum();

		String Campaign=elib.ReadExcelData("Campaign", 0, 0) + ranNum;
		
		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(Campaign);
		createPage.clickSaveButton();
		Thread.sleep(4000);
		CampValidationPage validate = new CampValidationPage(driver);
		validate.validateCamaign(driver, Campaign);	
	}
	@Test
	public void CreateContactsTest() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		
		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickcontactLink();
		
		ContactDetailedPage img = new ContactDetailedPage(driver);
		img.clickCampLookUpImg();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);


		String firstName=elib.ReadExcelData("Contact", 0, 0) + ranNum;
		String lastName=elib.ReadExcelData("Contact", 1, 0) + ranNum;

		
		CreateContactPage createPage = new CreateContactPage(driver);
		createPage.enterfirstName(firstName);
		createPage.enterlastname(lastName);
		createPage.clickSaveButton();
		
		ContactValidationPage validate = new ContactValidationPage(driver);
		validate.validateCamaign(driver, firstName, lastName);
	}
	
	@Test(groups="smoke")
	public void CreateProductTest() throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		
		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickProdLink();
		
		ProductDetailedPage img = new ProductDetailedPage(driver);
		img.clickProdLookUpImg();
		int ranNum=jlib.getRandomNum();
		
		String P1=elib.ReadExcelData("Products", 0, 0) + ranNum;
		
		CreateProductPage createPage = new CreateProductPage(driver);
		createPage.enterprodName(P1);
		createPage.clickSaveButton();
		Thread.sleep(4000);
		
		ProductValidationPage validate = new ProductValidationPage(driver);
		validate.validateProduct(driver, P1);
	}

}










































