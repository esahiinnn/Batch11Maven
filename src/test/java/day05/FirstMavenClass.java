package day05;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Class Work Amazon Search Test
1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim
 */
public class FirstMavenClass {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        String arananKelime = "Samsung headphones";

        //3- “Samsung headphones” ile arama yapalim
        searchBox.sendKeys(arananKelime);
        searchBox.submit();

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucSayisi.getText() + " " + arananKelime);
        System.out.println("=============================");


        //5- Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal' and @dir='auto'])[1] "));
        ilkUrun.click();

        //6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//span[@dir='auto']"));
        int i = 0;
        for(WebElement w: sayfaBasliklari){
            i++;
            System.out.println(i + ".ci baslik " + w.getText());
        }


    }
}
