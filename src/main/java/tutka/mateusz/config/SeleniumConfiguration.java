package tutka.mateusz.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import tutka.mateusz.techutils.WaitUtils;

import com.opera.core.systems.OperaDriver;

public class SeleniumConfiguration {
	private static final String START_PAGE = "http://finser.pl";
	private static WebDriver driver;

	protected void launchSelenium() {
		if (driver == null) {
			Browsers browser = Browsers.valueOf((System.getProperty("browser",
					Browsers.FIREFOX.name())));
			switch (browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				driver = new ChromeDriver();
				break;
			case OPERA:
				DesiredCapabilities operaCapabilities = DesiredCapabilities
						.opera();
				operaCapabilities.setCapability("opera.binary",
						"/usr/bin/opera");
				operaCapabilities.setCapability("opera.port", -1);
				operaCapabilities.setCapability("opera.profile", "");

				driver = new OperaDriver(operaCapabilities);
				break;
			default:
				driver = new FirefoxDriver();
				break;
			}
			if (!(driver instanceof OperaDriver))
				driver.manage().window().maximize();
			driver.get(START_PAGE);
		}
		WaitUtils.setImplicitTimeout(20);
	}
	protected void stopSelenium(){
		driver.quit();
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	enum Browsers {
		FIREFOX, CHROME, OPERA;
	}
}
