package locators

import constructor_classes.LocatorsConstructor

class AuthorizationScreenLocators {

    val textOfTitleInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/textViewTitle",
        iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"ВХОД ИЛИ РЕГИСТРАЦИЯ\"`]"
    )

    val inputFieldInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone",
        iOSClassChain = "**/XCUIElementTypeOther[`name == \"editTextPhone\"`]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"
    )

    val getcodeButtonInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Получить код\"`]"
    )
}