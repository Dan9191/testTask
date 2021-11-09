package task1.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class SecondPage {
    WebDriver driver;

    /**
     * Метод, возвращающий значение процента.
     * @param line номер строки, из которого берется значение процента.
     * @return  Строка со значением процента.
     */
    public String returnProcent(WebDriver driver, int line){
        this.driver = driver;
        return driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[2]/div/div[6]/table/tbody/tr[" + line
                    + "]/td[9]/p/b")).getText();
    }
}
