import Direction.RIGHT
import kotlin.math.pow

enum class Direction(val dx: Int, val dy: Int) {
    UP   ( 0, -1),
    RIGHT( 1,  0),
    DOWN ( 0,  1),
    LEFT (-1,  0);

    fun turnRight() = Direction.values()[(ordinal + 1) % Direction.values().size]
}

data class Coordinate(val x: Int, val y: Int) {

    fun step(direction: Direction) = copy(x + direction.dx, y + direction.dy)

    fun isWithinGridOfSize(size: Int) = x in 0 until size && y in 0 until size

}

object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        require(size >= 0) { "size must be a non-negative integer" }

        if (size == 0) return emptyArray()

        val result = Array(size) { IntArray(size) { 0 } }
        val entryCount = size.toDouble().pow(2.0).toInt()

        var coord = Coordinate(0, 0)
        var direction = RIGHT

        for (i in 0 until entryCount) {
            result[coord.y][coord.x] = i + 1

            val maybeNextCoord = coord.step(direction)
            if (maybeNextCoord.isWithinGridOfSize(size) && result[maybeNextCoord.y][maybeNextCoord.x] == 0) {
                coord = maybeNextCoord
            } else {
                direction = direction.turnRight()
                coord = coord.step(direction)
            }
        }

        return result
    }

}
