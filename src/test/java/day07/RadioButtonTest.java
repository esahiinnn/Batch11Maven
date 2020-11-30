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
1.Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
 - “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin
 */
public class RadioButtonTest {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
    }

    @Test
    public void test(){
        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();

        //- “radio buttons” elementlerini locate edin
        //- femaleButton
        WebElement femaleButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[1]"));
        //- maleButton
        WebElement maleButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[2]"));
        //- customButton
        WebElement customButton = driver.findElement(By.xpath("(//label[@class='_58mt'])[3]"));
            if(!maleButton.isSelected()){
                maleButton.click();
            }
    }

    @After
    public void tearDown(){
        //driver.close();
    }
}
