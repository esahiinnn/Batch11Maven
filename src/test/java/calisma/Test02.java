package calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test02 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("https://techproeducation.com");

        //Reklam close button
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //Full-stack-automation engineer
        driver.findElement(By.xpath("(//span[@class='txt'])[4]")).click();

        //Automation Testing Process
        WebElement baslik = driver.findElement(By.xpath("(//h3)[2]"));
        System.out.println("Baslik " + baslik.getText());

        //Automation Testing Process Alt Basliklari
        WebElement icerik = driver.findElement(By.xpath("(//ul)[9]"));
        System.out.println(icerik.getText());





    }
}
