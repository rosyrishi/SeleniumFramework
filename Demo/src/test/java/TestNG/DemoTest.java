package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DemoTest {
		@Test
			public void demoTest()
			{
				String BROWSER = System.getProperty("browser");
				String URL = System.getProperty("url");
				System.out.println(BROWSER);
				System.out.println(URL);
				
				WebDriver driver=new FirefoxDriver();;
//				if(BROWSER.equalsIgnoreCase("chrome"))
//				{
////					WebDriverManager.chromedriver().setup();
//					WebDriver driver=new ChromeDriver();
//				}
//				else {
//					driver=new FirefoxDriver();
//							
//				}
				driver.get(URL);
				}
		}

