package grid.Selenium_Grid;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExecution {
	
	//@Test
	public void test_grid() {
		
		GridFunctions f = new GridFunctions();
		RemoteWebDriver driver = f.brwser();
		driver.get("http://www.google.com");
	}
/**
 * [SelfRegisteringRemote.registerToHub] - Registering the node to the hub: http://192.168.0.106:4444/grid/register
08:17:50.830 INFO [SelfRegisteringRemote$1.run] - 
Couldn't register this node: Error sending the registration request: Failed to connect to /192.168.0.106:4444
 */
	
	@Parameters("browser")
	@Test
	public void testParallel(String browser) {
		GridFunctions f = new GridFunctions();
		f.initialBrowser(browser);
	}
}
