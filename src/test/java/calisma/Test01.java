package calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/ASUS/Documents/selenium dependencies/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://udemy.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//span[@class='udlite-text-sm header--dropdown-button-text--2jtIM'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='udlite-block-list-item-content'])[1]")).click();
        driver.findElement(By.xpath("(//a[@href=\"/topic/java/\"])")).click();
        driver.findElement(By.xpath("//div[@class=\"udlite-focus-visible-target udlite-heading-md course-card--course-title--2f7tE\"]")).click();

    }
}
