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

        var paramPlatformName = ""

        //описать логику, нужен ли нам авторизованный пользователь

        // Тап на крестик в онбординге
        try {
            when(paramPlatformName){
                "iOS" -> {
                    clickToElement(
                        locatorType = locatorsTypes.iOSClassChain,
                        locator = SplashScreenLocators().exitButtonOnSplashScreen.iOSClassChain
                    )
                }
                "Android" -> {
                    clickToElement(
                        locatorType = locatorsTypes.xpath,
                        locator = SplashScreenLocators().exitButtonOnSplashScreen.androidXpath
                    )
                }
            }
        } catch (e: org.openqa.selenium.NoSuchElementException) {
            println("Элемент не найден, тест продолжается")
        }

        // Проверка текста заголовка экрана авторизации
        when(paramPlatformName){
            "iOS" -> {
                checkTextInElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = AuthorizationScreenLocators().textOfTitleInAuthScreen.iOSClassChain,
                    text = "",
                    name = "ВХОД ИЛИ\n" +
                            "РЕГИСТРАЦИЯ"
                )
            }
            "Android" -> {
                checkTextInElement(
                    locatorType = locatorsTypes.id,
                    locator = AuthorizationScreenLocators().textOfTitleInAuthScreen.androidId,
                    text = "ВХОД ИЛИ\n" +
                            "РЕГИСТРАЦИЯ",
                    name = ""
                )
            }
        }

//        //нужно ли кликать в айос?
//        clickToElement(
//            locatorType = locatorsTypes.iOSClassChain,
//            locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain
//        )

        // Ввод номера телефона в поле (сначала неправильного)
        when(paramPlatformName){
            "iOS" -> {
                inputTextInField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain,
                    inputText = "99969"
                )
            }
            "Android" -> {
                inputTextInField(
                    locatorType = locatorsTypes.id,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
                    inputText = "99969"
                )
            }
        }

        // Очистка поля номера телефона
        when(paramPlatformName){
            "iOS" -> {
                clearField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain
                )
            }
            "Android" -> {
                clearField(
                    locatorType = locatorsTypes.id,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId
                )
            }
        }

        // Ввод номера телефона в поле (правильного)
        when(paramPlatformName){
            "iOS" -> {
                inputTextInField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.iOSClassChain,
                    inputText = "9999999969"
                )
            }
            "Android" -> {
                inputTextInField(
                    locatorType = locatorsTypes.id,
                    locator = AuthorizationScreenLocators().inputFieldInAuthScreen.androidId,
                    inputText = "9999999969"
                )
            }
        }

        // Клик по кнопке авторизации
        when(paramPlatformName){
            "iOS" -> {
                clickToElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = AuthorizationScreenLocators().getcodeButtonInAuthScreen.iOSClassChain
                )
            }
            "Android" -> {
                clickToElement(
                    locatorType = locatorsTypes.id,
                    locator = AuthorizationScreenLocators().getcodeButtonInAuthScreen.androidId
                )
            }
        }

        // Ввод кода (сначала неправильного)
        when(paramPlatformName){
            "iOS" -> {
                inputTextInField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain,
                    inputText = "41"
                )
            }
            "Android" -> {
                inputTextInField(
                    locatorType = locatorsTypes.id,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
                    inputText = "41"
                )
            }
        }

        // Очистка поля ввода кода
        when(paramPlatformName){
            "iOS" -> {
                clearField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain
                )
            }
            "Android" -> {
                clearField(
                    locatorType = locatorsTypes.id,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId
                )
            }
        }

        // Ввод кода (правильного)
        when(paramPlatformName){
            "iOS" -> {
                inputTextInField(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.iOSClassChain,
                    inputText = "1111"
                )
            }
            "Android" -> {
                inputTextInField(
                    locatorType = locatorsTypes.id,
                    locator = CodeFromSmsScreenLocators().inputFieldForSmsCode.androidId,
                    inputText = "1111"
                )
            }
        }

        // Даем добро на местоположение
        when(paramPlatformName){
            "iOS" -> {
                clickToElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = PermissionsLocators().whenUsingAppButtonInPermissionGeolocation.iOSClassChain
                )
            }
            "Android" -> {
                clickToElement(
                    locatorType = locatorsTypes.id,
                    locator = PermissionsLocators().whenUsingAppButtonInPermissionGeolocation.androidId
                )
            }
        }

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
        when(paramPlatformName){
            "iOS" -> {
                clickToElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = NavbarLocators().profileTab.iOSClassChain
                )
            }
            "Android" -> {
                clickToElement(
                    locatorType = locatorsTypes.id,
                    locator = NavbarLocators().profileTab.androidId
                )
            }
        }

        // Переход в редактирование профиля
        when(paramPlatformName){
            "iOS" -> {
                clickToElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = ProfileMenuScreenLocators().editButtonOnProfileMenuScreen.iOSClassChain
                )
            }
            "Android" -> {
                clickToElement(
                    locatorType = locatorsTypes.id,
                    locator = ProfileMenuScreenLocators().editButtonOnProfileMenuScreen.androidId
                )
            }
        }

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
        when(paramPlatformName){
            "iOS" -> {
                clickToElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.iOSClassChain
                )
            }
            "Android" -> {
                clickToElement(
                    locatorType = locatorsTypes.id,
                    locator = EditProfileScreenLocators().logoutButtonInEditProfileScreen.androidId
                )
            }
        }

        // Проверка доступности кнопки Войти на экране профиля
        when(paramPlatformName){
            "iOS" -> {
                checkAvailableElement(
                    locatorType = locatorsTypes.iOSClassChain,
                    locator = ProfileMenuScreenLocators().loginButtonOnProfileMenuScreen.iOSClassChain
                )
            }
            "Android" -> {
                checkAvailableElement(
                    locatorType = locatorsTypes.id,
                    locator = ProfileMenuScreenLocators().loginButtonOnProfileMenuScreen.androidId
                )
            }
        }

        TimeUnit.SECONDS.sleep(5)
    }
}