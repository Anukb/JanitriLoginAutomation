package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldsAreEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be disabled when fields are empty");
    }

    @Test
    public void testPasswordMaskedButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword("sample123");
        String beforeClick = loginPage.getPasswordFieldType();
        loginPage.togglePasswordVisibility();
        String afterClick = loginPage.getPasswordFieldType();
        Assert.assertNotEquals(beforeClick, afterClick, "Password visibility should toggle");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserId("random@abc.com");
        loginPage.enterPassword("wrongpass");
        loginPage.clickLogin();
        Thread.sleep(2000); // You can use WebDriverWait instead for real scenarios
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Error message should be displayed for invalid login");
    }

    @Test
    public void testElementsPresentOnLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.areElementsPresent(), "All login elements should be visible");
    }
}
