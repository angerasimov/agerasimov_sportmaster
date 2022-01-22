package locators

import constructor_classes.LocatorsConstructor

class AuthorizationScreenLocators {

    val textOfTitleInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/textViewTitle"
    )

    val inputFieldInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editTextPhone"
    )

    val getcodeButtonInAuthScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonGetCode"
    )
}