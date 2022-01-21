package constructor_classes

data class LocatorsTypesConstrutor constructor(
    val id: String = "id",
    val xpath: String = "xpath"
)

val locatorsTypes = LocatorsTypesConstrutor()