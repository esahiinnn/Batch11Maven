package calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Test03 {

    /*  Test1
        1- https://github.com/ adresine gidin
        2- arama kutusunu locate edin
        3- arama kutusuna salptekin yazin
        4- users'a tiklayin
        5- SULEYMAN ALPTEKIN isimli kullaniciyi secin
        6- aciklamasinin "SDET and Full Stack Automation Tester Instructor" oldugunu onaylayin
        7- takipci sayisini ekrana yazdirin
        Test2
        1- arama kutusunu locate edin
        2- arama kutusuna bulutluoz yazip arayin
        3- users'a tiklayin Bulutluoz isimli kullaniciyi secin
        4- aciklamasinin "selenium code examples for whom learning java and trying to be automation tester" olup olmadini test edin
        5- takipci sayisini yazdirin
        6- driverlari kapatin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //Ayarlari yapin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //1- https://github.com/ adresine gidin
        driver.get("https://github.com");

    }

    @Test
    public void salptekinTest1(){

        //2- arama kutusunu locate edin
        WebElement searchBox = driver.findElement(By.name("q"));

        //3- arama kutusuna salptekin yazin
        searchBox.sendKeys("salptekin");
        searchBox.submit();

        //4- users'a tiklayin
        driver.findElement(By.xpath("(//a[@class='menu-item'])[9]")).click();

        //5- SULEYMAN ALPTEKIN isimli kullaniciyi secin
        driver.findElement(By.xpath("//a[@href='/salptekin']")).click();

        //6- aciklamasinin "SDET and Full Stack Automation Tester Instructor" oldugunu onaylayin
        String beklenenAciklama = "SDET and Full Stack Automation Tester Instructor";
        WebElement actualAciklama = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/div/div[4]/div"));
        String actualText = actualAciklama.getText();
        if(actualText.equals(beklenenAciklama)){
            System.out.println("Aciklama dogru");
        }else{

            System.out.println("Aciklama yanlis dogru aciklama\n" + actualText);
        }

        //7- takipci sayisini ekrana yazdirin
        WebElement takipciSayisi = driver.findElement(By.xpath("//a[@class='link-gray no-underline no-wrap']"));
        System.out.println(takipciSayisi.getText() + " kisi takip ediyor");


        driver.navigate().to("https://github.com/");
        //2- arama kutusuna bulutluoz yazip arayin
        String arananKelime = "bulutluoz";
        WebElement s2= driver.findElement(By.xpath("//input[@type='text'][1]"));

        s2.sendKeys(arananKelime);

        s2.submit();
        //3- users'a tiklayin Bulutluoz isimli kullaniciyi secin
        driver.findElement(By.xpath("(//a[@class='menu-item'])[9]")).click();
        driver.findElement(By.xpath("//img[@alt='@bulutluoz']")).click();
        //4- aciklamasinin "selenium code examples for whom learning java and trying to be automation tester" olup olmadini test edin
        String beklenenAciklamaBulutluoz = "selenium code examples for whom learning java and trying to be automation tester";
        WebElement actualAciklamaBulutluoz = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/div/div[4]/div"));
        if(actualAciklamaBulutluoz.getText().equals(beklenenAciklamaBulutluoz)){
            System.out.println("Aciklama dogru");
        }else{
            System.out.println("Aciklama yanlis");
        }


        //5- takipci sayisini yazdirin
        WebElement takipciSayisi2 = driver.findElement(By.xpath("//a[@href='/bulutluoz?tab=followers']"));

        System.out.println(takipciSayisi2.getText() + " kisi takip ediyor");


    }

    @AfterClass
    public static void tearDown(){
        //6- driverlari kapatin
        driver.close();
    }
}