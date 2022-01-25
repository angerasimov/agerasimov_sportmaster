package locators

import constructor_classes.LocatorsConstructor

class ProductScreenLocators {
    val favoriteButtonOnProductScreen = LocatorsConstructor(
        androidXpath = "ru.sportmaster.app.handh.dev:id/favorite",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"notAdded\"`]"
    )

    val addToCartButtonOnProductScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonAddToCart",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"В корзину\"`][1]"
    )

    val addReviewButtonOnProductScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonAddReview",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"+ Добавить отзыв\"`]"
    )

    val askQuestionButtonOnProductScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/buttonAskQuestion",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"+ Задать вопрос\"`]"
    )
}