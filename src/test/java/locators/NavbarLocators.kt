package locators

import constructor_classes.LocatorsConstructor

class NavbarLocators {
    val profileTab = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/profile_graph",
        iOSClassChain = "**/XCUIElementTypeButton[`name == \"profile_graph\"`]"
    )
}