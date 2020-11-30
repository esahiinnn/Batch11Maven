package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        Thread.sleep(3000);
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@data-test='username']"));
        String gonderilcekUserName = "standard_user";
        usernameTextBox.sendKeys(gonderilcekUserName);

        Thread.sleep(3000);
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@data-test='password']"));
        String gonderilcekPassword = "secret_sauce";
        passwordTextBox.sendKeys(gonderilcekPassword);

        Thread.sleep(3000);
        //4. Login tusuna basin
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        Thread.sleep(3000);
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmi = ilkUrun.getText();
        ilkUrun.click();

        Thread.sleep(3000);
        //6. Add to Cart butonuna basin
        driver.findElement(By.cssSelector("button[class='btn_primary btn_inventory']")).click();

        Thread.sleep(3000);
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@href='./cart.html']")).click();

        Thread.sleep(3000);
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement urunTest = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
           if(urunTest.getText().equals(ilkUrunIsmi)){
               System.out.println("Urun ekleme testi PASS");
           }else{
               System.out.println("Urun ekleme testi FAILED");
               System.out.println("Sectigim urun ile sepetteki urun ayni degil");
           }
        Thread.sleep(3000);

        //9. Sayfayi kapatin
        driver.close();
    }
}
