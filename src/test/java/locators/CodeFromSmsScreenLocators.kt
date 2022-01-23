package locators

import constructor_classes.LocatorsConstructor

class CodeFromSmsScreenLocators {
    val inputFieldForSmsCode = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/pinCodeEditText",
        iOSClassChain = "**/XCUIElementTypeTextField[`name == \"pinCodeEditText\"`]"
    )
}