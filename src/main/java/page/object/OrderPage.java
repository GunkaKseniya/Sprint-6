package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends MainPage{

    public WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //локатор поля "Имя"
    static By nameField = By.xpath(".//input[@placeholder='* Имя']");

    //локатор поля "Фамилия"
    static By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    //локатор поля "Адрес, куда привезти заказ"
    static By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //локатор поля "Станция метро"
    static By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");

    //локатор выбора "Станция метро"
    static By secondClickMetroStationField = By.xpath(".//div[text()='Бабушкинская']");

    //локатор поля "Телефон"
    static By telephoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор кнопки "Далее"
    static By nextButton = By.xpath(".//button[text()='Далее']");

    //локатор поля "Даты"
    static By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //локатор поля "Срок аренды"
    static By leaseTerm = By.className("Dropdown-arrow");

    //локатор выбора "Срок аренды"
    static By leaseTermAction = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");

    //локатор поля "Цвет самоката" (чёрный жемчуг)
    static By blackColor = By.id("black");

    //локатор поля "Цвет самоката" (серая безысходность)
    static By greyColor = By.id("grey");

    //локатор поля "Комментарий"
    static By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //локатор кнопки "Заказать" в конце формы аренды
    static By orderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");

    //локатор кнопки "Да" окна подтверждения
    static By yesButton = By.xpath(".//button[text()='Да']");

    //локатор окна "Заказ оформлен"
    public static By orderIsProcessed = By.xpath(".//div[starts-with(@class, 'Order_ModalHeader')]");

    //нажатие по кнопке "Заказать" в верхней части страницы
    public void clickSignInTopButton() {
        driver.findElement(signInTopButton).click();
    }

    //нажатие по кнопке "Заказать" в нижней части страницы
    public void clickSignInButtonBottom() {
        driver.findElement(signInBottomButton).click();
    }

    //закрытие сообщения о куки
    public void clickAppCookieButton() {
        driver.findElement(appCookieButton).click();
    }

    //ввод данных в поле "Имя"
    public void setUsernameField(String username) {
        driver.findElement(nameField).sendKeys(username);
    }

    //ввод данных в поле "Фамилия"
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    //ввод данных в поле "Адрес"
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //ввод данных в поле "Станция метро"
    public void setMetroStation() {
        driver.findElement(metroStationField).click();
    }

    //подтверждение выбора станции метро
    public void secondClickMetroStationField() {
        driver.findElement(secondClickMetroStationField).click();
    }

    //заполнение поля "Станция метро"
    public void setMetroStationField(String metro) {
        driver.findElement(metroStationField).sendKeys(metro);
    }

    //ввод данных в поле "Телефон"
    public void setTelephoneField(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    //нажатие по кнопке «Далее»
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //ввод данных в поле "Дата"
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    //нажатие по полю "Срок аренды"
    public void setLeaseTerm() {
        driver.findElement(leaseTerm).click();
    }

    //выбор в поле "Срок аренды"
    public void setLeaseTermAction() {
        driver.findElement(leaseTermAction).click();
    }

    //выбор цвета "чёрный жемчуг"
    public void clickButtonBlackColor() {
        driver.findElement(blackColor).click();
    }

    //выбор цвета "серая безысходность"
    public void clickButtonGreyColor() {
        driver.findElement(greyColor).click();
    }

    //ввод данных в поле "Комментарий"
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //нажатие по кнопке "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //нажатие по кнопке "Да" окна "Подтверждения"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Проверка создания заказа
    public void checkOrderOpenAndHasOrderNumber() {
        driver.findElement(orderIsProcessed);
    }

    //нажатие на блок "Вопросы о важном"
    public void clickImportantQuestionsItem() {
        driver.findElement(importantQuestionsItem).click();
    }
}