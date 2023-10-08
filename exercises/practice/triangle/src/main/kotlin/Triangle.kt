import java.lang.IllegalArgumentException

class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

    init {
        require(a > 0 && b > 0 && c > 0) { "Sides must be > 0" }
        require(a + b >= c && b + c >= a && c + a >= b) { "Sides must satisfy triangle inequality" }
    }

    val isEquilateral: Boolean = a == b && b == c
    val isIsosceles: Boolean = a == b || b == c || a == c
    val isScalene: Boolean = a != b && b != c && a != c

    private infix operator fun <T: Number> T.compareTo(other: T): Int = this.toDouble().compareTo(other.toDouble())
    private infix operator fun <T: Number> T.plus(b: T): Double = this.toDouble().plus(b.toDouble())
}
