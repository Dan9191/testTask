package task1.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *PageObject представление страницы рассчета кредита
 */
public class FirstPage {
    WebDriver driver;
    List<WebElement> inputs;
    WebElement out1;
    WebElement out2;

    public void writeInList(WebDriver driver){
        this.driver = driver;
        inputs = driver.findElements(By.xpath("//input[@inputmode='numeric']"));
    }

    public void dataInput(String creditAmount, String creditTerm) throws InterruptedException {
        inputs.get(0).clear();
        Thread.sleep(2000);
        inputs.get(0).sendKeys(creditAmount);
        inputs.get(1).clear();
        Thread.sleep(2000);
        inputs.get(1).sendKeys(creditTerm);
    }

    /**
     * Вывод суммы ежемесячного взноса
     */
    public String dataOutput1(){
        out1 = driver.findElement(By.xpath("//div[@class='loan-calculator-result__value loan-calculator-result__value--green']"));
        return out1.getText();
    }

    /**
     * Вывод процентной ставки
     */
    public String dataOutput2(){
        out2 = driver.findElement(By.xpath("(//div[@class='loan-calculator-result__value'])[1]"));
        return out2.getText();
    }
}
