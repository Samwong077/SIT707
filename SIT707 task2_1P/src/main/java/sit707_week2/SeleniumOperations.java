package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	private static final String SCREENSHOT_PATH = "C:/Users/wongf/OneDrive/桌面/Deakin/2025 Sem1/SIT 707/";
	
    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate ChromeDriver in the local drive.
        System.setProperty("webdriver.chrome.driver", "C:/Users/wongf/Downloads/chromedriver-win64/chromedriver.exe");

        // Step 2: Use the ChromeDriver to open a Chromium browser.
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        System.out.println("Opening Officeworks registration page...");
        driver.get(url);

        try {
            // Locate and fill input fields using explicit waits
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys("Fuk Sang");
            driver.findElement(By.id("lastname")).sendKeys("Wong");
            driver.findElement(By.id("email")).sendKeys("s224078886@deakin.edu.au");
            driver.findElement(By.id("phoneNumber")).sendKeys("0477335760");
            driver.findElement(By.id("password")).sendKeys(""); // Leave blank to fail password validation

            // Locate and click the "Create Account" button
            WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='account-action-btn']")));
            createAccountButton.click();

            // Take a screenshot before submission
            takeScreenshot(driver, "officeworks_registration.png");
        } catch (Exception e) {
            System.out.println("Error in Officeworks registration: " + e.getMessage());
        } finally {
            sleep(2);
            driver.quit();
        }
    }

    public static void alternative_registration_page(String url) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/wongf/Downloads/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        System.out.println("Opening alternative site registration page...");
        driver.get(url);

        try {
            // Adjust the fields according to the alternative website
        	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys("Fuk Sang");
             driver.findElement(By.id("lastname")).sendKeys("Wong");
             driver.findElement(By.id("email_address")).sendKeys("s224078886@deakin.edu.au");
             driver.findElement(By.id("password")).sendKeys("");
             driver.findElement(By.id("password-confirmation")).sendKeys("");
             
             WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Create an Account']")));
             createAccountButton.click();

            // Take a screenshot
            takeScreenshot(driver, "alternative_registration.png");
        } catch (Exception e) {
            System.out.println("Error in alternative registration: " + e.getMessage());
        } finally {
            sleep(2);
            driver.quit();
        }
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Capture screenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot captured successfully.");

            // Ensure the directory exists
            File directory = new File(SCREENSHOT_PATH);
            if (!directory.exists()) {
                directory.mkdirs(); // Create folder if it doesn't exist
            }

            // Define full path for the screenshot
            String fullPath = SCREENSHOT_PATH + fileName;
            File destination = new File(fullPath);

            // Save the screenshot file
            FileHandler.copy(screenshot, destination);

            // Confirm screenshot is saved
            if (destination.exists()) {
                System.out.println("Screenshot saved successfully at: " + fullPath);
            } else {
                System.out.println("File was not created!");
            }

        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        alternative_registration_page("https://magento.softwaretestingboard.com/customer/account/create/"); // Change if necessary
    }
}