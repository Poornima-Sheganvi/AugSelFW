package POMLocaters;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageLocaters {
	WebDriver driver;// null

	By username = By.id("user-name");
	By password = By.name("password");
	By loginButton = By.id("login-button");
	By errorMsg= By.tagName("h3");

	public LoginPageLocaters(WebDriver driver) {
		this.driver = driver;
	}

	public Map<String, Boolean> fetchLoginPageElements() {
		Map<String, Boolean> preCheckMap = new HashMap();
		boolean usernameDisplayed = driver.findElement(username).isDisplayed();
		preCheckMap.put("isusernameDisplayed", usernameDisplayed);

		boolean pwdDisplayed = driver.findElement(password).isDisplayed();
		preCheckMap.put("ispwdDisplayed", pwdDisplayed);

		boolean loginButtonDisplayed = driver.findElement(password).isDisplayed();
		preCheckMap.put("isloginButtonDisplayed", loginButtonDisplayed);
		return preCheckMap;
	}

	public void login(String name, String pwd) {
		driver.findElement(username).sendKeys(name);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}

	public String fetchErrorMsg() {
		return driver.findElement(errorMsg).getText();
	}
}
