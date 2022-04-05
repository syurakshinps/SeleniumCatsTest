package company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private static final String BASE_URL = "http://market.yandex.ru";
    protected WebDriver driver;

    @BeforeAll
    public void SetUpAndOpensStartPage() {
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
          /*
          chromeOptions.addArguments("--headless");
          chromeOptions.addArguments("--no-sandbox");
          */
        chromeOptions.addArguments("log-level=0");
        chromeOptions.addArguments("user-data-dir=/home/nihil/snap/chromium/common/chromium/SeleniumAutoTests");
        driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);
        Assertions.assertFalse(driver.getPageSource().contains("робот"));
    }
}
