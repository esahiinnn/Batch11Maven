package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
        //1-Test01 isimli bir class olusturun
//2- https://www.walmart.com/ adresine gidin
//3- Browseri tam sayfa yapin
//4-Sayfayi "refresh" yapin
//5- Sayfa basliginin "Save" ifadesi icerdigini control edin
//6-Sayfa basliginin "Walmart.com | Save Money.Live Better" a esit oldugunu control ediniz
//7- URL in walmart.com icerdigini control edin
//8-"Nutella" icin arama yapiniz
//9- Kac sonuc bulundugunu yaziniz
//10-Sayfayi kapatin
     */
public class WallmartSearchTest {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-Sayfayi "refresh" yapin
        driver.navigate().refresh();
    }

    @Test
    public void titleSaveArama(){
        //5- Sayfa basliginin "Save" ifadesi icerdigini control edin
        String pageTitle = driver.getTitle();
        String arananKelime = "Save";
            if(pageTitle.contains(arananKelime)){
                System.out.println("Page title Save ifadesi iceriyor");
            }else{
                System.out.println("Page title Save ifadesini icermiyor");
            }

    }

    @Test
    public void titleEsitMi(){
        String pageTitle = driver.getTitle();
        //6-Sayfa basliginin "Walmart.com | Save Money.Live Better" a esit oldugunu control ediniz
        String arananBaslik = "Walmart.com | Save Money.Live Better";
        if(pageTitle.equals(arananBaslik)){
            System.out.println("Sayfa basligi Testi PASS");
        }else{
            System.out.println("Sayfa basligi Testi FAILED");
        }
    }

    @Test
    public void urlTest(){
        //7- URL in walmart.com icerdigini control edin
        String currentUrl = driver.getCurrentUrl();
        String arananUrl = "walmart.com";
            if(currentUrl.contains(arananUrl)){
                System.out.println("Url Test PASS");
            }else{
                System.out.println("Url Test FAILED");
            }
    }

    @Test
    public void nutellaSearch(){
        //8-"Nutella" icin arama yapiniz
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String arananUrun = "Nutella";
        searchBox.sendKeys(arananUrun);
        searchBox.submit();

        //9- Kac sonuc bulundugunu yaziniz
        WebElement sonucSayisi = driver.findElement(By.className("result-summary-container"));
        System.out.println(sonucSayisi.getText());

    }



    @After
    public void teardown(){
        driver.close();
    }

}
