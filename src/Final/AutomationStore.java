package Final;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationStore extends Parameters {
	@BeforeTest
	public void myBeforeTest() {
		driver.get(Thewebsite);
		 driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void SignupTest() throws InterruptedException {
		WebElement loginSignupbutton =driver.findElement(By.id("customer_menu_top"));
		loginSignupbutton.click();
		WebElement continueButton=driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
		
		
		continueButton.click();
		WebElement firstNameInput=driver.findElement(By.id("AccountFrm_firstname"));
		firstNameInput.sendKeys(FirstName);
		WebElement lastNameInput=driver.findElement(By.id("AccountFrm_lastname"));
		lastNameInput.sendKeys(LastName);
		WebElement emailInput=driver.findElement(By.id("AccountFrm_email"));
		emailInput.sendKeys(Email);
		WebElement addressInput= driver.findElement(By.id("AccountFrm_address_1"));
		addressInput.sendKeys(Address);
		WebElement city=driver.findElement(By.id("AccountFrm_city"));
		city.sendKeys(Address);
		WebElement country=driver.findElement(By.id("AccountFrm_country_id"));
		country.click();
		WebElement JordanSelection=driver.findElement(By.xpath("//option[@value='108']"));
		JordanSelection.click();
		WebElement state=driver.findElement(By.id("AccountFrm_zone_id"));
		state.click();
		WebElement AmmanSelection=driver.findElement(By.xpath("//option[@value='1704']"));
		WebElement IrbidSelection=driver.findElement(By.xpath("//option[@value='1712']"));
		if (Address.equals("Amman")) {
		    AmmanSelection.click();
		} else {
		    IrbidSelection.click();
		}
WebElement zipcode=driver.findElement(By.id("AccountFrm_postcode"));
zipcode.sendKeys(String.valueOf(RandomIndexfortheZipCode));
WebElement LogInName=driver.findElement(By.id("AccountFrm_loginname"));
LogInName.sendKeys(loginName);
WebElement logInPassword= driver.findElement(By.id("AccountFrm_password"));
logInPassword.sendKeys(password);
WebElement passwordConfirmation=driver.findElement(By.id("AccountFrm_confirm"));
passwordConfirmation.sendKeys(password);
WebElement subscribe=driver.findElement(By.xpath("//label[@for='AccountFrm_newsletter1']"));
subscribe.click();
WebElement agree=driver.findElement(By.xpath("//input[@id='AccountFrm_agree']"));
agree.click();
WebElement SignUp=driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
SignUp.click();

driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='https://automationteststore.com/index.php?rt=account/logout'][normalize-space()='']")).click();
driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();



		
		
	}
	@Test(priority = 2)
	public void LogInTest() throws InterruptedException {
		WebElement loginSignupbutton =driver.findElement(By.id("customer_menu_top"));
		loginSignupbutton.click();
	    WebElement loginNameInput = driver.findElement(By.id("loginFrm_loginname"));
	    loginNameInput.sendKeys(loginName);
	    WebElement loginPasswordInput = driver.findElement(By.id("loginFrm_password"));
	    loginPasswordInput.sendKeys(password);
	    WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	    loginButton.click();
	    }
	@Test(priority = 3)
	public void AddToCart () throws InterruptedException {
		WebElement hairCareButton=driver.findElement(By.cssSelector("div[class='col-md-12'] li:nth-child(7)"));
        hairCareButton.click();
        WebElement condtionerSelection=driver.findElement(By.cssSelector("ul[class='thumbnails row'] li:nth-child(1)"));
        condtionerSelection.click();
       
        WebElement MainContainer=driver.findElement(By.cssSelector(".thumbnails.grid.row.list-inline"));
        List <WebElement> ItemsConditioner = MainContainer.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12"));
        
        for (int i = 0; i < ItemsConditioner.size(); i += 2) {
            WebElement conditionerItem = ItemsConditioner.get(i);
            Thread.sleep(1000);
            
            WebElement ItemThumbnail=conditionerItem.findElement(By.className("thumbnail"));
            ItemThumbnail.click();
           WebElement addToCart=driver.findElement(By.className("cart"));
            addToCart.click();
            Thread.sleep(3000);
           driver.navigate().to("https://automationteststore.com/index.php?rt=product/category&path=52_54");
           ItemsConditioner = driver.findElements(By.cssSelector(".col-md-3.col-sm-6.col-xs-12"));
            }
	}
	@Test(priority = 4)
	public void TheSumOfAllItems() {
		driver.findElement(By.className("fa-shopping-cart")).click();
		double sum =0;
	List<WebElement>Price=driver.findElements(By.cssSelector("td:nth-child(6)"));
	
	for(int i=0;i<Price.size();i++) {
	WebElement ThePrice=Price.get(i);
	String textOfThePricString=ThePrice.getText();
	double PriceValue=Double.parseDouble(textOfThePricString.replace("$", ""));
	sum+=PriceValue;
	
	
	
	}
	System.out.println(sum);
	WebElement ActualTotal=driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2)"));
    double actualTotalValue = Double.parseDouble(ActualTotal.getText().replace("$", ""));

	softassert.assertEquals(sum, actualTotalValue);
	
	softassert.assertAll();
	
		
	}
	@Test(priority = 5)
	public void Checkoutprocess () throws InterruptedException {
		WebElement CheckoutButton=driver.findElement(By.id("cart_checkout2"));
		CheckoutButton.click();
		WebElement ConfirmOrderButton=driver.findElement(By.id("checkout_btn"));
		ConfirmOrderButton.click();
		Thread.sleep(1000);

		
		 softassert.assertEquals(driver.getCurrentUrl(), UrlAftersuccessfulOrder);
		 softassert.assertAll();
	}
	
	
	

	 

	@AfterTest
	public void myAfterTest() {}
}
