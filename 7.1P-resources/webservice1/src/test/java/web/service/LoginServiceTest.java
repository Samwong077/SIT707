package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;

public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebDriver setupDriver() {
        // ✅ Update to your actual path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        return new ChromeDriver();
    }

    private void performLogin(WebDriver driver, String username, String password, String dob) {
        driver.navigate().to("file:///C:/Users/Administrator/Downloads/7.1P-resources/pages/login.html");
        sleep(2);

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);

        // ✅ Set DoB field directly using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value = arguments[0]", dob);

        // ✅ Click the login button
        driver.findElement(By.cssSelector("input[type=submit]")).click();
        sleep(2);
    }

    @Test
    public void testLoginSuccess() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "ahsan_pass", "2000-01-01");
        String title = driver.getTitle();
        System.out.println("Actual title: " + title);
        Assert.assertEquals("success", title);
        driver.quit();
    }

    @Test
    public void testLoginInvalidPassword() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "wrong", "2000-01-01");
        String title = driver.getTitle();
        System.out.println("Actual title: " + title);
        Assert.assertEquals("fail", title);
        driver.quit();
    }

    @Test
    public void testLoginInvalidUsername() {
        WebDriver driver = setupDriver();
        performLogin(driver, "wrong", "ahsan_pass", "2000-01-01");
        String title = driver.getTitle();
        System.out.println("Actual title: " + title);
        Assert.assertEquals("fail", title);
        driver.quit();
    }

    @Test
    public void testLoginInvalidDob() {
        WebDriver driver = setupDriver();
        performLogin(driver, "ahsan", "ahsan_pass", "1999-12-31");
        String title = driver.getTitle();
        System.out.println("Actual title: " + title);
        Assert.assertEquals("fail", title);
        driver.quit();
    }

    @Test
    public void testLoginEmptyFields() {
        WebDriver driver = setupDriver();
        performLogin(driver, "", "", "");
        String title = driver.getTitle();
        System.out.println("Actual title: " + title);
        Assert.assertEquals("fail", title);
        driver.quit();
    }
}