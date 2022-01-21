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



        // Ввод номера телефона в поле
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

        // Ввод кода
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

        swipeOnScreen(
            startCordX = 495,
            startCordY = 1176,
            moveCordX = 495,
            moveCordY = 746
        )

        clickToElement(
            locatorType = locatorsTypes.id,
            locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.androidId
        )

        TimeUnit.SECONDS.sleep(5)
    }
}