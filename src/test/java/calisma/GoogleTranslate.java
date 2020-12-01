package calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1-https://translate.google.com/?ui=tob sayfasina gidin
2- ilk text boxa "merhaba" yazin ve enter layin
3- Translet edilen cumlenin "Heelo there" oldugunu dogrulayin
4- Cikan sonuc lardan Interjection basligi altindaki ilk 2 maddeyi ekrana yazdirin
5-cevirdigimiz metnin kac karakterden olurturdunu ekrana yazdirin
6-Ardindan Google apps (9 nokta sagda) ye basip youtuba gecin
7-youtube sayfasina gittigini onaylayin
8- searchboxa techproed yazdirip enter layin
9-geri gelin
10-sayfadaki baslik sayisini yazdirin
11- drive i kapatin
 */
public class GoogleTranslate {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //1-https://translate.google.com/?ui=tob sayfasina gidin
        driver.get("https://translate.google.com/?ui=tob");
    }

    @Test
    public void translateTest(){
        //2- ilk text boxa "merhaba" yazin ve enter layin
        WebElement textBox = driver.findElement(By.className("er8xn"));
        String translateEdilecekKelime = "Merhaba";
        textBox.sendKeys(translateEdilecekKelime + Keys.ENTER);

        //3-
        WebElement ikinciTextBox = driver.findElement(By.xpath("//span[@jsname='W297wb']"));
        String actualMetin = ikinciTextBox.getText();
        String expectedMetin = "Hello there";
        Assert.assertEquals(expectedMetin,actualMetin);

        //4- Cikan sonuc lardan Interjection basligi altindaki ilk 2 maddeyi ekrana yazdirin
        WebElement ilkSonuc = driver.findElement(By.xpath("(//span[@class='kgnlhe'])[1]"));
        WebElement ikinciSonuc = driver.findElement(By.xpath("(//span[@class='kgnlhe'])[2]"));
        System.out.println(ilkSonuc.getText() + "\n"+ ikinciSonuc.getText());

        //5-cevirdigimiz metnin kac karakterden olurturdunu ekrana yazdirin
        System.out.println(driver.findElement(By.cssSelector("span[jsname='qKMVIf']")).getText());

        //6-Ardindan Google apps (9 nokta sagda) ye basip youtuba gecin
        driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
        driver.navigate().to("https://youtube.com");

        //7-Youtube sayfasina gittigini onaylayin
        String beklenenTitle = "You";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(beklenenTitle));

    }

    @After
    public void tearDown(){
        driver.close();
    }
}
