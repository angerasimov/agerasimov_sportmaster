package locators

import constructor_classes.LocatorsConstructor

class PermissionsLocators {
    val whenUsingAppButtonInPermissionGeolocation = LocatorsConstructor(
        androidId = "com.android.permissioncontroller:id/permission_allow_foreground_only_button",
        iOSClassChain = "**/XCUIElementTypeButton[`label == \"Allow While Using App\"`]"
    )
}