import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.OrderPage;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.object.MainPage.*;
import static page.object.OrderPage.*;

public class PositiveTestScooterOrder {
    private WebDriver driver;

    @BeforeEach
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//запуск в браузере Firefox
//        @BeforeEach
//    public void setUpFirefox() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @ParameterizedTest
    @MethodSource("orderParam")
    void topButtonPositiveOrder(String username, String surname, String address, String metro, String telephone, String date, String comment) {
        driver.get(MAIN_PAGE_URL);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickSignInTopButton();
        orderPage.setUsernameField(username);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setMetroStation();
        orderPage.setMetroStationField(metro);
        orderPage.secondClickMetroStationField();
        orderPage.setTelephoneField(telephone);
        orderPage.clickNextButton();
        orderPage.setDateField(date);
        orderPage.setLeaseTerm();
        orderPage.setLeaseTermAction();
        orderPage.clickButtonBlackColor();
        orderPage.setCommentField(comment);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        String getRent = driver.findElement(orderIsProcessed).getText();
        assertEquals("Заказ оформлен\n" +
                "Номер заказа: .  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус", getRent);
    }
    static Stream<Arguments> orderParam() {
        return Stream.of(
                Arguments.of("Ксения", "Гунька", "Москва, Коминтерна, 54к2", "Бабушкинская", "89057949000", "31.07.2025", "Когда привезете - звоните"),
                Arguments.of("Александр", "Иванов", "Ленинский проспект, 8", "Бабушкинская", "89057950000", "01.08.2025", "Первая половина дня")
        );
    }
    @ParameterizedTest
    @MethodSource("orderParam")
    void bottomButtonPositiveOrder(String username, String surname, String address, String metro, String telephone, String date, String comment) {
        driver.get(MAIN_PAGE_URL);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickAppCookieButton();
        orderPage.clickSignInButtonBottom();
        orderPage.setUsernameField(username);
        orderPage.setSurnameField(surname);
        orderPage.setAddressField(address);
        orderPage.setMetroStation();
        orderPage.setMetroStationField(metro);
        orderPage.secondClickMetroStationField();
        orderPage.setTelephoneField(telephone);
        orderPage.clickNextButton();
        orderPage.setDateField(date);
        orderPage.setLeaseTerm();
        orderPage.setLeaseTermAction();
        orderPage.clickButtonBlackColor();
        orderPage.setCommentField(comment);
        orderPage.clickOrderButton();
        orderPage.clickYesButton();
        String getRent = driver.findElement(orderIsProcessed).getText();
        assertEquals("Заказ оформлен\n" +
                "Номер заказа: .  Запишите его:\n" +
                "пригодится, чтобы отслеживать статус", getRent);
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}