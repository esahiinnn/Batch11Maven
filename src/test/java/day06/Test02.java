package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1. http://zero.webappsecurity.com sayfasina gidin
 2. Signin buttonuna tiklayin
 3. Login alanine  “username” yazdirin
 4. Password alanine “password” yazdirin
 5. Sign in buttonuna tiklayin
 6. Pay Bills sayfasina gidin
 7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
 8. tarih kismina “2020-09-10”
 9. Pay buttonuna tiklayin
 10. “The payment was successfully submitted.” mesajinin ciktigini control edin
 */
public class Test02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
        WebElement loginField = driver.findElement(By.xpath("//input[@id='user_login']"));
        String userName = "username";
        loginField.sendKeys(userName);

        //4. Password alanine “password” yazdirin
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[id='user_password']"));
        String password = "password";
        passwordTextBox.sendKeys(password);

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountTextBox = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        String money = "500";
        amountTextBox.sendKeys(money);

        //8. tarih kismina “2020-09-10”
        WebElement dateTextBox = driver.findElement(By.xpath("//input[@id='sp_date']"));
        String date = "2020-09-10";
        dateTextBox.sendKeys(date);

        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement uyariYazisi = driver.findElement(By.cssSelector("span[title='$ 500 payed to payee sprint']"));
        String expectedYazi = "The payment was successfully submitted.";
            if(uyariYazisi.getText().equals(expectedYazi)){
                System.out.println("PASS");
            }else{
                System.out.println("FAILED");
            }
    }
}
