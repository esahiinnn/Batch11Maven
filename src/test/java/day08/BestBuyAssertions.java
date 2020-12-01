package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin
 farkli test method’lari olusturarak asagidaki testleri yapin
  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
 ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
 ○ logoTest => BestBuy logosunun görüntülendigini test edin
 ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
 */
public class BestBuyAssertions {

        static WebDriver driver;

        @BeforeClass
        public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Ayarlari yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }

        @Test
        public void urlTest(){
            //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.bestbuy.com/";
            Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void titleTest() {
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String aranmayanTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(aranmayanTitle));

    }

    @Test
    public void logoTest(){
            //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoGorunme = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoGorunme.isDisplayed());
        System.out.println("BestBuy logosu goruntulendi");
    }

    @Test
    public void dilTest(){
        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement languageGorunme = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(languageGorunme.isDisplayed());
        System.out.println("Fransizca linki goruntulendi");

    }
        @AfterClass
        public static void tearDown(){
            //driver.close();
    }
}

