package locators

import constructor_classes.LocatorsConstructor

class MainScreenLocators {
    val searchFieldOnMainScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editText",
        iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Поиск\"`]"
    )

    val loginButtonOnMainScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonAuth",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Войти\"`]"
    )
}