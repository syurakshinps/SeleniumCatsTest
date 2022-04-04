package company;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TecAdminSeleniumTest {
     private WebDriver driver;

    //locators
    private static final String baseURL = "http://market.yandex.ru";
    private static final String catalogueButton = "/html/body/div[1]/div[3]/noindex/div/div/div[2]/div[1]/div/div/button/span/div/div/div[2]";
    private static final String searchInputField = "//html/body/div[1]/div[3]/noindex/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div/input";
    private static final String searchText ="кошачий корм";
    private static final String clickToFind = "/html/body/div[1]/div[3]/noindex/div/div/div[2]/div[2]/div/div/form/div[1]/button/span";
    private static final String priceFromField = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li[1]/p/input";
    private static final String priceToFiled = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[1]/div/div/fieldset/div/ul/li[2]/p/input";
    private static final String priceMin = "50";
    private static final String priceMax = "150";
    private static final String goodsKind = "//*[@id=\"catalogPopup\"]/div/div/div/div/div/div/div[1]/div/ul/li[13]/a/span";
    private static final String treatsForCatsKind = "/html/body/div[21]/div[3]/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/ul/li[3]/div/a";
    private static final String treatsURL = "https://market.yandex.ru/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668";
    private static final String deliveryServiceRadioBtn ="/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[20]/div/div/fieldset/ul/li[1]/div/label/div";
    private static final String makerName = "/html/body/div[1]/div[3]/div[3]/div[5]/aside/div[2]/div/div/div/div/div[2]/div[4]/div/div/fieldset/ul/li[11]/div/a/label/div";
    private static final String firstBestChoice = "/html/body/div[1]/div[3]/div[3]/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/article[1]/div[3]/a";

/*
    @Test
    @Order(1)
    */
      @BeforeAll
      //@Test
        public void SetUp() {
          /*
1. chromeOptions.addArguments("user-data-dir=/home/nihil/snap/chromium/common/chromium/SeleniumAutoTests"); //придумываем имя директории, он в нее родит нестираемый профиль
2. в драйвере
а) создаем профиль (используем акк в гугле)
б) логинимся в яндекс
3. при первом запуске снимаем птичку "показывать на старте" в окне для выбора профиля
4. капчи больше нет.
           */

          System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");

          ChromeOptions chromeOptions = new ChromeOptions();
          //chromeOptions.addArguments("--headless");
          //   chromeOptions.addArguments("--no-sandbox");
          chromeOptions.addArguments("log-level=2");
          chromeOptions.addArguments("user-data-dir=/home/nihil/snap/chromium/common/chromium/SeleniumAutoTests");
          driver = new ChromeDriver(chromeOptions);

    }

        @Test
        @Order(2)
        @DisplayName("Открытие стартовой страницы")
        public void OpenStartPage() throws InterruptedException {
            driver.get(baseURL);
/*
                //  Assertions.assertTrue(driver.getPageSource().contains("робот"));

                    if (driver.getPageSource().contains("робот")) {
                            System.out.println("капча руками проходится, ибо");
                            //          https://www.browserstack.com/guide/how-to-handle-captcha-in-selenium
                    }
         Thread.sleep(3000); //namefio586
            */
            }

        @Test
        @Order(3)
        @DisplayName("Кликнули на каталог")
        public void CatalogueClick() throws InterruptedException {
        WebElement catalogue = driver.findElement(By.xpath(catalogueButton));
        //    Assertions.assertTrue(driver.getPageSource().contains("Зоо"));

        catalogue.click();
    //    System.out.println("Кликнули на каталог");
        Thread.sleep(1000);
        }

        @Test
        @Order(4)
        @DisplayName("hover Зоотовары")
        public  void HoverPetsGoods() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath(goodsKind));
        action.moveToElement(ele).perform();
   //     System.out.println("hover Зоотовары");
        Thread.sleep(1000);
        }
        @Test
        @Order(5)
        @DisplayName("Переход в лакомства")
        public  void CatsTreats() throws InterruptedException {
            String policyPageWindow = driver.getWindowHandle();
            driver.get(treatsURL);
            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle);
            }
    //        System.out.println("Перешли в лакомства");
            Thread.sleep(1000);
        }
        @Test
        @Order(6)
        @DisplayName("Выбор цены")
        public  void MinMax() throws InterruptedException {
            driver.findElement(By.xpath(priceFromField)).sendKeys(priceMin);
            System.out.println("min price " + priceMin);

            driver.findElement(By.xpath(priceToFiled)).sendKeys(priceMax);
      //      System.out.println("max price " + priceMax);
            Thread.sleep(1000);
        }
        @Test
        @Order(7)
        @DisplayName("выбор радиокнопок")
        public  void RadioButtons() throws InterruptedException {
        WebElement radio1 = driver.findElement(By.xpath(deliveryServiceRadioBtn));
        radio1.click();
     //   System.out.println("Доставка курьером бутон клац");
        Thread.sleep(10000);

        WebElement radio2 = driver.findElement(By.xpath(makerName));
        radio2.click();
    //    System.out.println("Деревенские лакомства - маректолога потом уволили, надеюсь");
        Thread.sleep(1000);
        }
        @Test
        @Order(8)
        @DisplayName("Выбор продукта")
        public  void ChooseTheFood() throws InterruptedException {
        WebElement choice = driver.findElement(By.xpath(firstBestChoice));
        choice.click();
      //  System.out.println("Первый в списке под популярными");
        Thread.sleep(1000);
        }

        @Test
        @Order(9)
        @DisplayName("Стопаем драйвер")
        public  void TearDown() throws InterruptedException {
            driver.quit();
        }
        }

