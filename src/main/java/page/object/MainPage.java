package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    public WebDriver driver;

    //локатор кнопки куки
    static By appCookieButton = By.id("rcc-confirm-button");

    //закрытие блока куки
    public void clickAppCookieButton() {
        driver.findElement(appCookieButton).click();
    }

    //локатор блока "Вопросы о важном"
    static By importantQuestionsItem = By.xpath(".//div[text()='Вопросы о важном']");

    //локатор кнопки "Заказать" в верхней части страницы
    public static By signInTopButton = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");

    //локатор кнопки "Заказать" в нижней части страницы
    static By signInBottomButton = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[text()='Заказать']");

    //нажатие по кнопке "Заказать" в верхней части страницы
    public void clickSignInTopButton() {
        driver.findElement(signInTopButton).click();
    }

    //нажатие по кнопке "Заказать" в нижней части страницы
    public void clickSignInButtonBottom() {
        driver.findElement(signInBottomButton).click();
    }

    //локатор кнопки "Go!"
    static By goButton = By.xpath(".//button[text()='Go!']");

    // Локаторы для блока "Вопросы о важном"
    public static By question1 = By.xpath("//*[@id=\"accordion__heading-0\"]");
    public static By answer1 = By.xpath("//*[@id=\"accordion__panel-0\"]");

    public static By question2 = By.xpath("//*[@id=\"accordion__heading-1\"]");
    public static By answer2 = By.xpath("//*[@id=\"accordion__panel-1\"]");

    public static By question3 = By.xpath("//*[@id=\"accordion__heading-2\"]");
    public static By answer3 = By.xpath("//*[@id=\"accordion__panel-2\"]");

    public static By question4 = By.xpath("//*[@id=\"accordion__heading-3\"]");
    public static By answer4 = By.xpath("//*[@id=\"accordion__panel-3\"]");

    public static By question5 = By.xpath("//*[@id=\"accordion__heading-4\"]");
    public static By answer5 = By.xpath("//*[@id=\"accordion__panel-4\"]");

    public static By question6 = By.xpath("//*[@id=\"accordion__heading-5\"]");
    public static By answer6 = By.xpath("//*[@id=\"accordion__panel-5\"]");

    public static By question7 = By.xpath("//*[@id=\"accordion__heading-6\"]");
    public static By answer7 = By.xpath("//*[@id=\"accordion__panel-6\"]");

    public static By question8 = By.xpath("//*[@id=\"accordion__heading-7\"]");
    public static By answer8 = By.xpath("//*[@id=\"accordion__panel-7\"]");
}
