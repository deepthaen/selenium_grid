package grid.Selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridFunctions {
	
	public RemoteWebDriver brwser() {
		RemoteWebDriver rdriver = new RemoteWebDriver(url(),capability());
		
		//java -jar seleleniumserver.jar -role hub   -->to start selenum server in local machine
		//java -Dwebdriver.chrome.driver="chromedriver" -jar selenium-server-standalone-3.141.59.jar 
		//-role webdriver -hub http://192.168.0.106:4444/grid/register -port 5566
		return rdriver;
	}

	
	public URL url() {
		URL url = null;
		try {
			 url = new URL("http://172.20.10.2:5566/wd/hub"); // this is others machine ip -- hari lap ip
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public DesiredCapabilities capability() {
		DesiredCapabilities ds = new DesiredCapabilities().chrome();
		ds.setBrowserName("chrome");
		ds.setPlatform(Platform.WIN10);
		return ds;
	}
	
	
	public void initialBrowser(String browser) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL-E7470\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL-E7470\\Downloads\\chromedriver_win32_1\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get("http://www.google.com");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
