import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.OrderPage;

import java.time.Duration;
import java.util.stream.Stream;

import static page.object.MainPage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImportantQuestionsBlockTest {
    private WebDriver driver;

    @BeforeEach
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    запуск в браузере Firefox
//    @BeforeEach
//    public void setUpFirefox() {
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

    @ParameterizedTest
    @MethodSource("importantQuestionsBlockParam")
    void importantQuestionsParam(String question, String answer, By xpathQuestion, By xpathAnswer) {
        driver.get(MAIN_PAGE_URL);
        OrderPage orderPage = new OrderPage(driver);
        orderPage.clickImportantQuestionsItem();
        orderPage.clickAppCookieButton();
        driver.findElement(xpathQuestion).click();
        String getQuestion = driver.findElement(xpathQuestion).getText();
        String getAnswer = driver.findElement(xpathAnswer).getText();
        assertEquals(question, getQuestion);
        assertEquals(answer, getAnswer);
    }

    static Stream<Arguments> importantQuestionsBlockParam() {
        return Stream.of(
                Arguments.of(
                        "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        question1, answer1
                ),
                Arguments.of(
                        "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        question2, answer2
                ),
                Arguments.of(
                        "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        question3, answer3
                ),
                Arguments.of(
                        "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        question4, answer4
                ),
                Arguments.of(
                        "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        question5, answer5
                ),
                Arguments.of(
                        "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        question6, answer6
                ),
                Arguments.of(
                        "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        question7, answer7
                ),
                Arguments.of(
                        "Я живу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                        question8, answer8
                )
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}