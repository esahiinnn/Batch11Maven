package day05;

/*
1. Bir class oluşturun: XpatchCssLocatorTest
2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
 a. http://a.testaddressbook.com adresine gidiniz.
  b. Sign in butonuna basin
 c. email textbox,password textbox, and signin button elementlerini locate ediniz..
 d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
 i. Username : testtechproed@gmail.com
 ii. Password : Test1234!
 e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
 f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
 doğrulayin(verify).
3. Sayfada kac tane link oldugunu bulun.
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XpathCssTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //a. http://sahibinden.com adresine gidiniz.
        driver.get("https://sahibinden.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //b. Arama textboxina macbook pro yazin Xpath ile
        WebElement searchButton = driver.findElement(By.xpath("//input[@id=\"searchText\"]"));
        String arananKelime = "macbook pro";
        searchButton.sendKeys(arananKelime);
        searchButton.submit();

        WebElement siralama = driver.findElement(By.cssSelector("a[href='#!']"));
        siralama.click();

        WebElement fiyataGore = driver.findElement(By.xpath("//a[@title='Fiyata göre (Önce en yüksek)']"));
        fiyataGore.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@data-id=\"condition\"])[1]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.xpath("//a[@class='faceted-select']")).click();

        //Ankara Button
        driver.findElement(By.xpath("(//li[@data-level='city'])[4]")).click();


        //Ekranda bos bir alana tiklama
        driver.findElement(By.xpath("//html")).click();

        //minTl textBox
        WebElement minTextBox = driver.findElement(By.cssSelector("input[placeholder='min TL']"));
        WebElement maxTextBox = driver.findElement(By.cssSelector("input[placeholder='max TL']"));
        minTextBox.sendKeys("7000");
        maxTextBox.sendKeys("9000");

        //Ara Button ve urunleri listeleme
        driver.findElement(By.cssSelector("button[class='btn btn-link js-manual-search-button']")).click();



    }
}

