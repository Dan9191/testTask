package task1.apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import task1.models.FirstPage;

import java.time.Duration;

public class MainApp1 {

    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dan\\Documents\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.rshb.ru/");
            Thread.sleep(3000);

            //Кликнуть «Частным лицам»
            WebElement element1 = driver.findElement(By.linkText("Частным лицам"));
            element1.click();
            Thread.sleep(3000);

            //Кликнуть «Кредиты»
            WebElement element2 = driver.findElement(By.linkText("Кредиты"));
            element2.click();
            Thread.sleep(3000);

            //- Кликнуть «Потребительский кредит без обечпечения»
            String element3 = driver.findElement(By.xpath("//a[@href='https://retail.rshb.ru/loans/bez_op/" +
                    "?utm_source=rshb_ru&utm_medium=affiliate&utm_campaign=bez_op&utm_content=button&utm_term=oformit_from_all']"))
                    .getAttribute("href");
            driver.get(element3);
            Thread.sleep(3000);

            FirstPage fP = new FirstPage();
            fP.writeInList(driver);
            fP.dataInput("3 000 000 ₽", "60");
            Thread.sleep(3000);
            Assert.assertEquals(fP.dataOutput1(), "62 275 ₽");
            Assert.assertEquals(fP.dataOutput2(), "9%");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
