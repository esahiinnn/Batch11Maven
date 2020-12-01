package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertion {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // "https://techproeducation.com'a gitme
        driver.get("https://techproeducation.com");

        //Reklam butonu kapama
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
    }

    @Test
    public void positiveTest(){
        //Sayfa basliginin TECHPROED icerdigini dogrulayin
        String arananKelime = "TECHPROED";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananKelime));

    }

    @Test
    public void negativeTest(){
        //Sayfa basliginin Mehmet kelimesini icermedigini dogrulayin
        String arananKelime = "Mehmet";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(arananKelime));

    }

    @Test
    public void equalsTest() {
        //Sayfa basliginin ....... oldugunu test ediniz
        String actualTitle = driver.getTitle();
        String expectedTitle = "TECHPROED | SDET | Java Developer | Web Developer | DevOps Engineer";
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("Bu yazi yazilacak mi");
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
