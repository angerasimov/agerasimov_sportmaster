package locators

import constructor_classes.LocatorsConstructor

class ProfileMenuScreenLocators {
    val editButtonOnProfileMenuScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonEditProfile",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"edit\"`]"
    )

    val loginButtonOnProfileMenuScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonSignIn",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Войти\"`]"
    )
}