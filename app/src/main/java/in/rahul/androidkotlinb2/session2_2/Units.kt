package `in`.rahul.androidkotlinb2.session2_2

enum class Units(val unit:Double, val unitName:String) {
    // Units
    LENGTH(0.0, "Length"),
    AREA(0.0, "Area"),
    TIME(0.0, "Time"),
    WEIGHT(0.0, "Weight"),

    // Length
    METER(1.0, "Meter"),
    MILI_METER(1000.0, "Mili Meter"),
    CENTIMETER(100.0, "Centimeter"),
    FOOT(3.28, "Foot"),

    // Area
    SQUARE_METER(1.0, "Square Meter"),
    SQUARE_FOOT(10.7639, "Square Foot"),
    SQUARE_INCH(1550.0, "Square Inch"),
    ACRE(0.000247, "Acre"),

    // Time
    MINUTE(1.0, "Minute"),
    SECOND(60.0, "Second"),
    HOUR(0.0167, "Hour"),

    // Weight
    GRAM(1.0, "Gram"),
    KILOGRAM(0.001, "Kilo Gram"),
    MILI_GRAM(1000.0, "Mili Gram"),

}

val categoryList = arrayOf(Units.LENGTH.name to false, Units.AREA.name to false, Units.TIME.name to false, Units.WEIGHT.name to false)

val lengthList = arrayOf(Units.MILI_METER, Units.CENTIMETER, Units.FOOT, Units.METER)
val areaList = arrayOf(Units.SQUARE_METER, Units.SQUARE_FOOT, Units.SQUARE_INCH, Units.ACRE)
val timeList = arrayOf(Units.MINUTE, Units.SECOND, Units.HOUR)
val weightList = arrayOf(Units.GRAM, Units.KILOGRAM, Units.MILI_GRAM)

