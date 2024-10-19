package POMLocaters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageLocaters {
	WebDriver driver;
	WebDriverWait wait ;

	By menu = By.xpath("//button[text()='Open Menu']");

	public HomePageLocaters(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMenuDisplayed() {
		wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean b = wait.until(ExpectedConditions.visibilityOf(driver.findElement(menu))).isDisplayed();
		return b;
	}

}
