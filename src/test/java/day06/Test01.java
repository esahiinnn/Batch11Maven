package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test01 {
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
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4-Sayfayi "refresh" yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin "Save" ifadesi icerdigini control edin
        String actualTitle = driver.getTitle();
        String arananKelimeTitle = "Save";
            if(actualTitle.contains(arananKelimeTitle)){
                System.out.println("Title Testi PASS");
            }else{
                System.out.println("Title Testi FAILDED");
                System.out.println("Sayfa basligi " + arananKelimeTitle + " icermiyor");
            }

        // 6-Sayfa basliginin "Walmart.com | Save Money.Live Better" a esit oldugunu control ediniz
        String arananSayfaBasligi = "Walmart.com | Save Money.Live Better";
            if(actualTitle.equals(arananSayfaBasligi)){
                System.out.println("Sayfa basligi Testi PASS");
            }else{
                System.out.println("Sayfa basligi Testi FAILED");
                System.out.println(actualTitle);
            }

        //7- URL in walmart.com icerdigini control edin
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "walmart.com";
            if(actualUrl.contains(arananKelime)){
                System.out.println("Url Testi PASS");
            }else{
                System.out.println("Url Testi FAILED");
            }

        //8-"Nutella" icin arama yapiniz
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-search-input']"));
        String arananUrun = "Nutella";
        searchBox.sendKeys(arananUrun);
        searchBox.submit();

        //9- Kac sonuc bulundugunu yaziniz
        List<WebElement> urunListesi = driver.findElements(By.xpath("//img[@data-pnodetype='item-pimg']"));
        System.out.println("Toplam:" + urunListesi.size() + " tane urun listelenmistir");

        //10-Sayfayi kapatin
        driver.close();
        System.out.println("Iyi gunler dileriz...");
    }
}
