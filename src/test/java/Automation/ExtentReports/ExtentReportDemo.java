package Automation.ExtentReports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void ReportSetup() {
		
		String path=System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Elango");
		
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test=extent.createTest("Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println("Git Test");
		System.out.println("Git Test1");
		System.out.println("Git Test2");
		System.out.println("Git Test3");
		driver.close();
		test.fail("Test case failed");
		extent.flush();
	}

}
