package task1.apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import task1.models.SecondPage;

import java.time.Duration;

public class MainApp2 {

    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dan\\Documents\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.rshb.ru/");
            Thread.sleep(2000);

            //Кликнуть «Частным лицам»
            WebElement element1 = driver.findElement(By.linkText("Частным лицам"));
            element1.click();
            Thread.sleep(2000);

            //Кликнуть «Все вклады и сбережения»
            String element2 = driver
                    .findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div/div[4]/div[2]/div[2]/div[7]/div/a"))
                    .getAttribute("href");
            driver.get(element2);
            Thread.sleep(2000);

            SecondPage sP = new SecondPage();

            System.out.println("Моя копилка: соответствуют ли проценты - "
                    + sP.returnProcent(driver, 13).equals("4,20%"));
            System.out.println("Мой счет: соответствуют ли проценты - "
                    + sP.returnProcent(driver, 14).equals("4,20%"));
            System.out.println("До востребования: соответствуют ли проценты - "
                    + sP.returnProcent(driver, 15).equals("0,01%"));
            System.out.println("Моя выгода: соответствуют ли проценты - "
                    + sP.returnProcent(driver, 12).equals("4,20%"));
            Assert.assertEquals(sP.returnProcent(driver, 15), "0,01%");
            Assert.assertEquals(sP.returnProcent(driver, 12), "4,20%");
            Assert.assertEquals(sP.returnProcent(driver, 13), "4,20%");
            Assert.assertEquals(sP.returnProcent(driver, 14), "4,20%");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
