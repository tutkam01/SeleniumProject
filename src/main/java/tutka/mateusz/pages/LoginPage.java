package tutka.mateusz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;

import tutka.mateusz.model.User;

public class LoginPage extends FinserPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void loginByLogin(User user){
		driver.findElement(By.cssSelector(".username>input")).sendKeys(user.getLogin());
		driver.findElement(By.cssSelector(".password>input")).sendKeys(user.getPassword());
		clickLogin();
		
	}
	private void clickLogin(){
		driver.findElement(By.cssSelector(".submit>input")).click();		
	}

	public String getLoggedUserLogin() {
		return driver
				.findElement(By.cssSelector("[id='session'] a[class='uiMenu']"))
				.getText().trim();

	}

}
