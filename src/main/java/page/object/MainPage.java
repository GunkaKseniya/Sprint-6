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

}
