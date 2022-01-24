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

        //описать логику, нужен ли нам авторизованный пользователь

        try {
            //нажатие на крестик в онбординге
            clickToElement(
                //locatorType = locatorsTypes.xpath,
                locatorType = locatorsTypes.iOSClassChain,
                //locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
                locator = SplashScreenLocators().exitButtonOnSplashScreen.iOSClassChain
            )
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        // Проверка текста заголовка экрана авторизации
//        checkTextInElement(
//            //locatorType = locatorsTypes.id,
//            locatorType = locatorsTypes.iOSClassChain,
//            //locator = AuthorizationScreenLocators().textOfTitleInAuthScreen.androidId,
//            locator = AuthorizationScreenLocators().textOfTitleInAuthScreen.iOSClassChain,
//            text = "ВХОД ИЛИ\n" +
//                    "РЕГИСТРАЦИЯ"
//        )

//        clickToElement(
//            locatorType = locatorsTypes.iOSClassChain,
//            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain
//        )

        // Ввод номера телефона в поле (сначала неправильного)
        inputTextInField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain,
            inputText = "99969"
        )


        // Очистка поля номера телефона
        clearField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain
        )

        // Ввод номера телефона в поле (правильного)
        inputTextInField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain,
            inputText = "9999999969"
        )

        // Клик по кнопке авторизации
        clickToElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = AuthorizationScreenLocators().getcodeButtonInAuthScreen.androidId
            locator = AuthorizationScreenLocators().getcodeButtonInAuthScreen.iOSClassChain
        )

        // Ввод кода (сначала неправильного)
        inputTextInField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain,
            inputText = "41"
        )

        // Очистка поля ввода кода
        clearField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain
        )

        // Ввод кода (правильного)
        inputTextInField(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
            locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain,
            inputText = "1111"
        )

        // Даем добро на местоположение
        clickToElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = PermissionsLocators().whenUsingAppButtonInPermissionGeolocation.androidId,
            locator = PermissionsLocators().whenUsingAppButtonInPermissionGeolocation.iOSClassChain
        )

        // Подтверждение города
//        clickToElement(
//            locatorType = locatorsTypes.id,
//            locator = AlertsLocators().yesButtonInConfirmationCityAlert.androidId
//        )

        // Выбор города (ios)
        tapByCoordinates(
            cordX = 50,
            cordY = 50
        )

        clickToElement(
            locatorType = locatorsTypes.iOSClassChain,
            locator = ListOfCitiesScreen().firstItemOnCitiesScreen.iOSClassChain
        )

        // Переход по табу в меню профиля
        clickToElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = NavbarLocators().profileTab.androidId
            locator = NavbarLocators().profileTab.iOSClassChain
        )

        // Переход в редактирование профиля
        clickToElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = ProfileMenuScreenLocators().editButtonOnProfileMenuScreen.androidId
            locator = ProfileMenuScreenLocators().editButtonOnProfileMenuScreen.iOSClassChain
        )

        // Скролл вниз до кнопки выхода из профиля
//        swipeOnScreen(
//            startCordX = 405,
//            startCordY = 1076,
//            moveCordX = 405,
//            moveCordY = 746
//        )

        // Скролл вниз (другой способ)
//        scrollToElement(
//            locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.androidId
//        )

        // Тап по кнопке выхода из профиля
        clickToElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.androidId
            locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.iOSClassChain
        )

        // Проверка доступности кнопки Войти на экране профиля
        checkAvailableElement(
            //locatorType = locatorsTypes.id,
            locatorType = locatorsTypes.iOSClassChain,
            //locator = ProfileMenuScreenLocators().loginButtonOnProfileMenuScreen.androidId
            locator = ProfileMenuScreenLocators().loginButtonOnProfileMenuScreen.iOSClassChain
        )

        TimeUnit.SECONDS.sleep(5)
    }
}