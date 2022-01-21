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

        // Переход по табу в профиль
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = "ru.sportmaster.app.handh.dev:id/profile_graph"
        )

        // Переход в редактирование профиля
        clickToElement(
            locatorType = locatorsTypes.id,
            locator = "ru.sportmaster.app.handh.dev:id/buttonEditProfile"
        )

//        swipeOnScreen(
//            startCordX = 10,
//            startCordY = 23,
//            moveCordX = 23,
//            moveCordY = 43
//        )

//        element9 = driver.findElement(MobileBy.id("ru.sportmaster.app.handh.dev:id/buttonLogout"))
//        element9.click()

        TimeUnit.SECONDS.sleep(5)
    }
}