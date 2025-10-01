package Stepdefinitions;

import Pages.loginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = null;
    loginPage login;

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        System.out.println("User is on Login Page");
        System.setProperty("webdriver.chrome.driver", "/Users/amitkumarmahto/Downloads/Orangehrm_Automation_Project/OrangeHrm/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @When("User enters (.*) and (.*)$")
    public void user_enters_valid_username_and_password(String username, String password) throws InterruptedException {
        login=new loginPage(driver);
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        login.enterUsername(username);
        login.enterPassword(password);
        Thread.sleep(2000);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        login.clickLoginButton();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User should be redirected to the Home page")
    public void user_should_be_redirected_to_the_home_page() throws InterruptedException {
        Thread.sleep(2000);
        System.out.print(driver.findElement(By.className("oxd-topbar-header-breadcrumb")).getText());
    }


    @Then("User logs out of the application")
    public void user_logs_out_of_the_application() throws InterruptedException {
        login.logout();
        Thread.sleep(2000);
        driver.quit();
    }
}
