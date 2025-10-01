package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    WebDriver driver;
    By txt_username=By.name("username");
    By txt_password=By.name("password");
    By btn_login=By.xpath("//button[@type='submit']");
    By btn_logoutdropdown=By.xpath("//p[@class='oxd-userdropdown-name']");
    By btn_logout=By.xpath("//a[text()='Logout']");

   public loginPage(WebDriver driver){
       this.driver=driver;

   }
    public void enterUsername(String username) {
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(btn_login).click();
    }

    public void loginValidUser(String username, String password) {
       driver.findElement(By.name("username")).sendKeys(username);
       driver.findElement(By.name("password")).sendKeys(password);
       driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void logout() throws InterruptedException {
        driver.findElement(btn_logoutdropdown).click();
        Thread.sleep(2000);
        driver.findElement(btn_logout).click();
    }
}
