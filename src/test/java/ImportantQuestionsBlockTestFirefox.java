import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.OrderPage;
import java.util.stream.Stream;

import static page.object.MainPage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantQuestionsBlockTestFirefox {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get(MAIN_PAGE_URL);
    }

    @ParameterizedTest
    @MethodSource("importantQuestionsBlockParam")
    void importantQuestionsParam(String question, String answer, String xpathQuestion, String xpathAnswer) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickImportantQuestionsItem();
        orderPage.clickAppCookieButton();
        driver.findElement(By.xpath(xpathQuestion)).click();
        String getQuestion = driver.findElement(By.xpath(xpathQuestion)).getText();
        String getAnswer = driver.findElement(By.xpath(xpathAnswer)).getText();
        assertEquals(question, getQuestion);
        assertEquals(answer, getAnswer);
    }

    static Stream<Arguments> importantQuestionsBlockParam() {
        return Stream.of(
                Arguments.of("Сколько это стоит? И как оплатить?", //ОР первого вопроса
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", //ОР первого ответа
                        "//*[@id=\"accordion__heading-0\"]", //XPath первого вопроса
                        "//*[@id=\"accordion__panel-0\"]"), //XPath первого ответа
                Arguments.of("Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "//*[@id=\"accordion__heading-1\"]",
                        "//*[@id=\"accordion__panel-1\"]"),
                Arguments.of("Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "//*[@id=\"accordion__heading-2\"]",
                        "//*[@id=\"accordion__panel-2\"]"),
                Arguments.of("Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "//*[@id=\"accordion__heading-3\"]",
                        "//*[@id=\"accordion__panel-3\"]"),
                Arguments.of("Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "//*[@id=\"accordion__heading-4\"]",
                        "//*[@id=\"accordion__panel-4\"]"),
                Arguments.of("Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "//*[@id=\"accordion__heading-5\"]",
                        "//*[@id=\"accordion__panel-5\"]"),
                Arguments.of("Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "//*[@id=\"accordion__heading-6\"]",
                        "//*[@id=\"accordion__panel-6\"]"),
                Arguments.of("Я живу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        "//*[@id=\"accordion__heading-7\"]",
                        "//*[@id=\"accordion__panel-7\"]")
        );
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}