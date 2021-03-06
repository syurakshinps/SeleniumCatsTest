package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class YandexMainPage extends BasePage{

    public YandexMainPage(WebDriver driver) {
        super(driver);
    }

    //private static final String BASE_URL = "http://market.yandex.ru";
    private static final String CATALOGUE_BUTTON = "/html/body/div[1]/div[3]/noindex/div/div/div[2]/div[1]/div/div/button/span/div/div/div[2]";
    private static final String SEARCH_INPUT_FIELD = "//html/body/div[1]/div[3]/noindex/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div/input";
    private static final String SEARCH_TEXT ="кошачий корм";
    private static final String CLICK_TO_FIND = "/html/body/div[1]/div[3]/noindex/div/div/div[2]/div[2]/div/div/form/div[1]/button/span";
    private static final String PRICE_FROM_FIELD = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li[1]/p/input";
    private static final String PRICE_TO_FILED = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li[2]/p/input";
    private static final String PRICE_MIN = "50";
    private static final String PRICE_MAX = "150";
    private static final String GOODS_KIND = "//*[@id=\"catalogPopup\"]/div/div/div/div/div/div/div[1]/div/ul/li[13]/a/span";
    private static final String TREATS_FOR_CATS_KIND = "/html/body/div[21]/div[3]/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[3]/div/a";
    private static final String TREATS_URL = "https://market.yandex.ru/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668";
    private static final String DELIVERY_SERVICE_RADIOBTN ="/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[20]/div/div/fieldset/ul/li[1]/div/label/div";
    private static final String MAKER_NAME = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[4]/div/div/fieldset/ul/li[11]/div/a/label/div";
    private static final String FIRST_BEST_CHOICE = "/html/body/div[1]/div[3]/div[3]/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/article[1]/div[3]/a";



    public void CatalogueClick() throws InterruptedException {
        WebElement catalogue = driver.findElement(By.xpath(CATALOGUE_BUTTON));
        Assertions.assertTrue(driver.getPageSource().contains("Зоо"));

        catalogue.click();
        Thread.sleep(1000);
    }

    public  void HoverPetsGoods() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath(GOODS_KIND));
        action.moveToElement(ele).perform();
        Thread.sleep(1000);
    }

    public  void CatsTreats() throws InterruptedException {
        String policyPageWindow = driver.getWindowHandle();
        driver.get(TREATS_URL);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
    }

    public  void MinMax() throws InterruptedException {
        driver.findElement(By.xpath(PRICE_FROM_FIELD)).sendKeys(PRICE_MIN);
        System.out.println("min price " + PRICE_MIN);

        driver.findElement(By.xpath(PRICE_TO_FILED)).sendKeys(PRICE_MAX);
        Thread.sleep(1000);
    }

    public  void RadioButtons() throws InterruptedException {
        WebElement radio1 = driver.findElement(By.xpath(DELIVERY_SERVICE_RADIOBTN));
        radio1.click();
        Thread.sleep(1000);

        WebElement radio2 = driver.findElement(By.xpath(MAKER_NAME));
        radio2.click();
        Thread.sleep(1000);
    }

    public  void ChooseTheFood() throws InterruptedException {
        WebElement choice = driver.findElement(By.xpath(FIRST_BEST_CHOICE));
        choice.click();
        Thread.sleep(1000);
    }




}
