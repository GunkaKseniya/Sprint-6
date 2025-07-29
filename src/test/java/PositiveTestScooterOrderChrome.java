import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.OrderPage;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.object.MainPage.*;
import static page.object.OrderPage.*;

public class PositiveTestScooterOrderChrome {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(MAIN_PAGE_URL);
    }
    @ParameterizedTest
    @MethodSource("orderParam")
    void topButtonPositiveOrder(String username, String surname, String address, String metro, String telephone, String date, String comment) {
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