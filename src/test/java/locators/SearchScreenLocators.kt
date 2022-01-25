package locators

import constructor_classes.LocatorsConstructor

class SearchScreenLocators {
    val searchFieldOnSearchScreen = LocatorsConstructor(
        androidId = "ru.sportmaster.app.handh.dev:id/editText",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Войти\"`]"
    )

    val previewOfFirstProductInAutocompleteResults = LocatorsConstructor(
        androidXpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.view.View",
        iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[7]/XCUIElementTypeOther/XCUIElementTypeOther[1]"
    )
}