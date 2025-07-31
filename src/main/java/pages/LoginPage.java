package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userIdInput = By.name("email");
    By passwordInput = By.name("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    By eyeIcon = By.xpath("//button[contains(@class,'MuiButtonBase-root')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdInput).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIcon).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButton).isEnabled();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }

    public boolean isLoginErrorDisplayed() {
        return driver.getPageSource().contains("Invalid email or password");
    }

    public boolean areElementsPresent() {
        return driver.findElement(userIdInput).isDisplayed() &&
               driver.findElement(passwordInput).isDisplayed() &&
               driver.findElement(eyeIcon).isDisplayed();
    }
}
