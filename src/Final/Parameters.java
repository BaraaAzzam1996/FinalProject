package Final;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {
	SoftAssert softassert=new SoftAssert();
	static WebDriver driver = new ChromeDriver();
	 Random rand =new Random();
	static String Thewebsite="https://automationteststore.com/";
	static String [] firstNames= {"Sara","Yara","Khaled","Rami"};
	 static String [] lastNames= {"Mustafa","Waleed","Samer","Ziad"};
	 int RandomIndexForTheNames=rand.nextInt(4);
	 String FirstName=firstNames[RandomIndexForTheNames];
	 String LastName=lastNames[RandomIndexForTheNames];
		int RandomIndexForTheEmail=rand.nextInt(2000);
		String Email=FirstName+LastName+RandomIndexForTheEmail+"@gmail.com";
		static String []address= {"Amman","Irbid"};
		int randomIndexForTheAdress=rand.nextInt(2);
		 String Address=address[randomIndexForTheAdress];
		 int RandomIndexfortheZipCode=rand.nextInt(30000);
	String loginName=FirstName+RandomIndexForTheEmail;
	String password=FirstName+"12345@";

	String UrlLogOut="https://automationteststore.com/";
String UrlAftersuccessfulOrder="https://automationteststore.com/index.php?rt=checkout/success";
}
