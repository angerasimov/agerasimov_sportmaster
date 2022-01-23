package constructor_classes

data class LocatorsTypesConstrutor constructor(
    val id: String = "id",
    val xpath: String = "xpath",
    val iOSClassChain: String = "iOSClassChain"
)

val locatorsTypes = LocatorsTypesConstrutor()