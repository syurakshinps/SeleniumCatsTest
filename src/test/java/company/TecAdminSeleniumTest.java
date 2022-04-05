package company;
import org.junit.jupiter.api.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;
import pages.YandexMainPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TecAdminSeleniumTest extends BaseTest{

    /*
      @Test
        @Order(2)
        @DisplayName("Открытие стартовой страницы")
    public void OpenStartPage() throws InterruptedException{
    yandexMainPage.OpenStartPage();
            }
*/
        @Test
        @Order(3)
        @DisplayName("Кликнули на каталог")
        public void CatalogueClick() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);
            yandexMainPage.CatalogueClick();
        }

        @Test
        @Order(4)
        @DisplayName("hover Зоотовары")
        public  void HoverPetsGoods() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);

            yandexMainPage.HoverPetsGoods();
        }
        @Test
        @Order(5)
        @DisplayName("Переход в лакомства")
        public  void CatsTreats() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);

            yandexMainPage.CatsTreats();
        }
        @Test
        @Order(6)
        @DisplayName("Выбор цены")
        public  void MinMax() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);

            yandexMainPage.MinMax();
        }

        @Test
        @Order(7)
        @DisplayName("выбор радиокнопок")
        public  void RadioButtons() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);

            yandexMainPage.RadioButtons();
        }
        @Test
        @Order(8)
        @DisplayName("Выбор продукта")
        public  void ChooseTheFood() throws InterruptedException{
            YandexMainPage yandexMainPage = new YandexMainPage(driver);

            yandexMainPage.ChooseTheFood();
        }

        @Test
        @Order(9)
        @DisplayName("Стопаем драйвер")
        public  void TearDown() throws InterruptedException {
            driver.quit();
        }
        }

