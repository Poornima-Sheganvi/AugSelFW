package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeBroswer {
	public static WebDriver driver;// null is default
	public static Properties prop = new Properties();

	@BeforeMethod
	public void openBroswer() {

		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\shiva\\eclipse-workspace\\AugSelFW\\src\\main\\java\\Configurations\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String broswer = prop.getProperty("browser");
		if (broswer.equalsIgnoreCase("chrome")) {
			// open only chrome broswer
			WebDriverManager.chromedriver().setup();// set driver properties
			driver = new ChromeDriver();
			InvokeBroswer.browserSetups();
		} else if (broswer.equalsIgnoreCase("edge")) {
			// open only Edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			InvokeBroswer.browserSetups();
		} else if (broswer.equalsIgnoreCase("firefox")) {
			// open only fix
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			InvokeBroswer.browserSetups();
		}
//		else if(broswer.equalsIgnoreCase("opera")) {
//			//open only opera
//			WebDriverManager.operadriver().setup();
//			driver=new OperaDriver();
//		}
		else {
			System.out.println("Invalid broswer");
		}
	}

	@AfterMethod
	public void tearDownBrowser() {
		if (driver != null) {
			driver.quit();
		}

	}

	public static void browserSetups() {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String implTime=prop.getProperty("Implicit_Wait");//"12"
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implTime)));
		
	}

}
