package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*

    Assertions: (Verification)
1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest => Sayfa başlığının“YouTube” oldugunu test edin
○ imageTest => YouTube resminingörüntülendiğini (isDisplayed()) test edin
○ gmailLinkTest => “YouTube apps" linkinin görüntülendiğini test edin
○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin

 */
public class YoutubeAssertions {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //2) https://www.youtube.com adresine gidin
        driver.get("https://youtube.com");
    }

    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    @Test
    public void titleTest(){

    }

    //○ imageTest => YouTube resminingörüntülendiğini (isDisplayed()) test edin
    @Test
    public void imageTest(){

    }

    //○ gmailLinkTest => “YouTube apps" linkinin görüntülendiğini test edin
    @Test
    public void gmailLinkTest(){

    }

    //○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
    @Test
    public void wrongTitleTest(){

    }

    @After
    public void tearDown(){
        //driver.close();
    }
}
