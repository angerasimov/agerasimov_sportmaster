package constructor_classes

data class LocatorsConstructor constructor(
    val androidAccessibilityId: String = "",
    val androidId: String = "",
    val androidXpath: String = "",
    //val androidText: String = "",
    val iOSClassChain: String = ""
)

val example = LocatorsConstructor(
    androidAccessibilityId = "",
    androidId = "",
    androidXpath = "",
    iOSClassChain = ""
)
