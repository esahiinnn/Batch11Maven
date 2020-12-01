package calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


        //1- https://github.com/ adresine gidin


    }

    @Test
    public void salptekinTest1(){

        //2- arama kutusunu locate edin

        //3- arama kutusuna salptekin yazin

        //4- users'a tiklayin

        //5- SULEYMAN ALPTEKIN isimli kullaniciyi secin

        //6- aciklamasinin "SDET and Full Stack Automation Tester Instructor" oldugunu onaylayin

        //7- takipci sayisini ekrana yazdirin
    }
    @Test
    public void bulutluozTest2(){

        //1- arama kutusunu locate edin

        //2- arama kutusuna bulutluoz yazip arayin

        //3- users'a tiklayin Bulutluoz isimli kullaniciyi secin

        //4- aciklamasinin "selenium code examples for whom learning java and trying to be automation tester" olup olmadini test edin

        //5- takipci sayisini yazdirin



    }



    @AfterClass
    public static void tearDown(){
        //6- driverlari kapatin
        //driver.close();
    }
}
