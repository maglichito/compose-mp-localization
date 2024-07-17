sealed class Language(val isoFormat : String) {
    data object English : Language("en")
    data object Serbian : Language("sr")
}