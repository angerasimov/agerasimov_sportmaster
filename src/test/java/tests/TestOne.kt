package tests

import constructor_classes.locatorsTypes
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import locators.*
import main.TestMethods
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class TestOne: TestMethods() {

    @Test
    fun testOne(){
        TimeUnit.SECONDS.sleep(2)

        try {
            //нажатие на крестик в онбординге
            clickToElement(
                locatorType = locatorsTypes.xpath,
                locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        // Проверка текста заголовка экрана авторизации
        checkTextInElement(
            locatorType = locatorsTypes.id,
            locator = AuthorizationScreenLocators().textOfTitleInAuthScreen.androidId,
            text = "ВХОД ИЛИ\n" +
                    "РЕГИСТРАЦИЯ"
        )

        // Ввод номера телефона в поле (сначала неправильного)
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
            inputText = "99969"
        )

        // Очистка поля номера телефона
        clearField(
            locatorType = locatorsTypes.id,
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId
        )

        // Ввод номера телефона в поле (правильного)
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
            inputText = "9999999969"
        )

        // Клик по кнопке авторизации
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = AuthorizationScreenLocators().getcodeButtonInAuthScreen.androidId
        )

        // Ввод кода (сначала неправильного)
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
            inputText = "41"
        )

        // Очистка поля ввода кода
        clearField(
            locatorType = locatorsTypes.id,
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId
        )

        // Ввод кода (правильного)
        inputTextInField(
            locatorType = locatorsTypes.id,
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
            inputText = "1111"
        )

        // Даем добро на местоположение
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = PermissionsLocators().whenUsingAppButtonInPermissionGeolocation.androidId
        )

        // Подтверждение города
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = AlertsLocators().yesButtonInConfirmationCityAlert.androidId
        )

        // Переход по табу в меню профиля
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = NavbarLocators().profileTab.androidId
        )

        // Переход в редактирование профиля
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = ProfileMenuScreenLocators().editButtonOnProfileMenuScreen.androidId
        )

        // Скролл вниз до кнопки выхода из профиля
        swipeOnScreen(
            startCordX = 405,
            startCordY = 1076,
            moveCordX = 405,
            moveCordY = 746
        )

        // Тап по кнопке выхода из профиля
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.androidId
        )

        // Проверка доступности кнопки Войти на экране профиля
        checkAvailableElement(
            locatorType = locatorsTypes.id,
            locator = ProfileMenuScreenLocators().loginButtonOnProfileMenuScreen.androidId
        )

        TimeUnit.SECONDS.sleep(5)
    }
}