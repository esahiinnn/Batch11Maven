package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAnnotations {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void test01(){

        driver.get("https://techproeducation.com");

    }

    @Test
    @Ignore
    public void test02(){

        driver.get("https://google.com");

    }

    @Test
    public void test03(){


        driver.get("https://youtube.com");

    }

    @After
    public void tearDown(){
        driver.close();
    }

}
