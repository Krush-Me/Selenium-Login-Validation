package loginTestCaseValidation;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginValidation {

	@Test(priority = 1)
	void headingValidation() {
		/* ------ Heading Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		String actualHeading = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/div[1]/h1")).getText();
		// in BRD
		String expectedHeading = "Sign in";
		Assert.assertEquals(actualHeading, expectedHeading);
		System.out.println("1...");
		driver.close();
	}
	
	
	@Test(priority = 2)
	void subHeadingValidation() {
		/* ------ sub Heading Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		String actualSubHeading = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/div[1]/p")).getText();
		// in BRD
		String expectedSubHeading = "Stay updated on your professional world.";
		Assert.assertEquals(actualSubHeading, expectedSubHeading);
		System.out.println("2...");
		driver.close();
	}
	
	
	@Test(priority = 3)
	void validCredentialEmailPass() {
		/* ------ Valid Credential Email & pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("krushamdonakari@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ResumeP@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		String expectedURL = "https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin";
		Assert.assertEquals(currentUrl, expectedURL);
		
		boolean homePageCheck = driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[1]/a")).isDisplayed();
		Assert.assertTrue(homePageCheck);
		//https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin
	
		driver.findElement(By.xpath("//*[@id=\"ember17\"]")).click();
		System.out.println("3...");
	}
	
	
	@Test(priority = 4)
	void invalidCredentialEmailPass() {
		/* ------ invalid Credential Email & pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("abcd@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-password\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Wrong email or password. Try again or create an account .";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("4...");
		driver.close();
	}
	
	
	@Test(priority = 5)
	void validPhonePass() {
		/* ------ Valid Phone & Pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("+917083886065");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ResumeP@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		String expectedURL = "https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin";
		Assert.assertEquals(currentUrl, expectedURL);
		
		boolean homePageCheck = driver.findElement(By.xpath("//*[@id=\"global-nav\"]/div/nav/ul/li[1]/a")).isDisplayed();
		Assert.assertTrue(homePageCheck);
		//https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin
		System.out.println("5...");
		driver.findElement(By.xpath("//*[@id=\"ember17\"]")).click();
	}
	
	
	@Test(priority = 6)
	void validEmail_invalidPass() {
		/* ------ valid  Email & invalid pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("krushamdonakari@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("P@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-password\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Wrong email or password. Try again or create an account .";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("6...");
		driver.close();
	}
	
	
	@Test(priority = 7)
	void invalidEmail_validPass() {
		/* ------ invalid Email & valid pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("krushamd@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ResumeP@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-password\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Wrong email or password. Try again or create an account .";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("7...");
		driver.close();
	}
	
	
	@Test(priority = 8)
	void invalidPhone_validPass() {
		/* ------ invalid Phone & valid pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("+917987256355");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ResumeP@ss2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-password\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Wrong phone number or password. Try again or create an account .";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("8...");
		driver.close();
	}
	
	
	@Test(priority = 9)
	void validPhone_invalidPass() {
		/* ------ valid Phone & invalid pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("+917083886065");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("me Pass2024");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-password\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Wrong phone number or password. Try again or create an account .";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("9...");
		driver.close();
	}
	
	
	@Test(priority = 10)
	void validEmail_NoPass() {  
		/* ------ valid  Email & NO pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("krushamdonakari@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.id("error-for-password")).getText();
		// in BRD
		String expectedErrorMsg = "Please enter a password.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("10...");
		driver.close();
	}
	
	
	@Test(priority = 11)
	void validPhone_NoPass() {  
		/* ------ valid Phone & NO pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("+917083886065");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.id("error-for-password")).getText();
		// in BRD
		String expectedErrorMsg = "Please enter a password.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("11...");
		driver.close();
	}
	
	
	@Test(priority = 12)
	void noEmailNoPassCheck(){
		/* ------ No Email/Phone & NO pass Check -------	*/
		WebDriver driver = new ChromeDriver();
		//driver.get("https://in.linkedin.com/");
		//driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		driver.get("https://www.linkedin.com/login");
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.id("error-for-username")).getText();
		// in BRD
		String expectedErrorMsg = "Please enter an email address or phone number.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("12...");
		driver.close();
	}
	
	
	@Test(priority = 13)
	void invalidEmailFormatValidation() {
		/* ------ invalid Email format Check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("invalidformat");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password1232");
		driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[4]/button")).click();
		
		String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"error-for-username\"]")).getText();
		// in BRD
		String expectedErrorMsg = "Please enter a valid username.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
		System.out.println("13...");
		driver.close();
	}
	
	
	/* 1- invalid email & no pass 2- invalid mobile & no pass -- expected = Please enter a password.*/
	/* 3- No email & valid pass   4- No phone & valid pass   -- id =error-for-username , expected = Please enter an email address or phone number.*/
	/* 5- No email & invalid pass 6- No email & invalid pass -- id =error-for-username , expected = Please enter an email address or phone number.*/
	
	
	@Test(priority = 14)
	void showPassbtn() {  
		/* ------ show password button Check -------	*/
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("password1232");
		driver.findElement(By.xpath("//*[@id=\"password-visibility-toggle\"]")).click();
		
		boolean disPass = driver.findElement(By.xpath("//*[@id=\"password\"]")).isDisplayed();
		Assert.assertTrue(disPass);
		System.out.println("14...");
		driver.close();
	}
	
	
	/*		*/
	@Test(priority = 15)
	void KeepmeLoggedinLabelCheck() {
		/* ------ Keep me logged in Label -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		
		String actualLabel = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]")).getText();
		// in BRD
		String expectedLabel = "Keep me logged in";
		Assert.assertEquals(actualLabel, expectedLabel);
		System.out.println("15...");
		driver.close();
	}
	
	
	@Test(priority = 16)
	void SignInButtonLabelCheck() {
		/* ------ SignInButton Label check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		
		String actualLabel = driver.findElement(By.xpath("//button[@aria-label='Sign in']")).getText();
		// in BRD 
		String expectedLabel = "Login";
		Assert.assertEquals(actualLabel, expectedLabel);
		System.out.println("16...");
		driver.close();
	}
	
	
	@Test(priority = 17)
	void EmailorPhoneLabelCheck() {
		/* ------ Email or Phone Label check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		
		String actualLabel = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[1]/label")).getText();
		// in BRD
		String expectedLabel = "Email or phone";
		Assert.assertEquals(actualLabel, expectedLabel);
		System.out.println("17...");
		driver.close();
	}
	
	
	@Test(priority = 18)
	void PasswordLabelCheck() {
		/* ------ Password Label check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		
		String actualLabel = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[2]/label")).getText();
		// in BRD
		String expectedLabel = "Password";
		Assert.assertEquals(actualLabel, expectedLabel);
		System.out.println("18...");
		driver.close();
	}
	
	
	@Test(priority = 19)
	void AppleSignInbtnLabelCheck() { 
		/* ------ Apple Sign in Label check -------	*/
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/login");
		
		String actualLabel = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/div[2]/button")).getText();
		// in BRD
		String expectedLabel = "Sign in with Apple";
		Assert.assertEquals(actualLabel, expectedLabel);
		System.out.println("19...");
		driver.close();
	}
	
}
