package locators

import constructor_classes.LocatorsConstructor

class ListOfCitiesScreen {
    val searchFieldOnCitiesScreen = LocatorsConstructor(
        //androidId = "",
        iOSClassChain = "**/XCUIElementTypeSearchField[`label == \"Найти город\"`]"
    )

    val firstItemOnCitiesScreen = LocatorsConstructor(
        //androidId = "",
        iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther"
    )
}