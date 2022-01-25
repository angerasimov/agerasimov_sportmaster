package locators

import constructor_classes.LocatorsConstructor

class AlertsLocators {
    val yesButtonInConfirmationCityAlert = LocatorsConstructor(
        androidId = "android:id/button1"
    )

    val loginButtonOnAuthorizationAlert = LocatorsConstructor(
        androidId = "android:id/button1",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Авторизоваться\"`]"
    )
}