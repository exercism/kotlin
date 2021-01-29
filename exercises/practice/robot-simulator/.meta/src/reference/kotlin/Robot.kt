fun Orientation.turnLeft()  = Orientation.values()[Math.floorMod(ordinal - 1, Orientation.values().size)]
fun Orientation.turnRight() = Orientation.values()[Math.floorMod(ordinal + 1, Orientation.values().size)]

class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = Orientation.NORTH) {

    private fun advance() {
        gridPosition = when (orientation) {
            Orientation.NORTH -> gridPosition.copy(y = gridPosition.y + 1)
            Orientation.EAST  -> gridPosition.copy(x = gridPosition.x + 1)
            Orientation.SOUTH -> gridPosition.copy(y = gridPosition.y - 1)
            Orientation.WEST  -> gridPosition.copy(x = gridPosition.x - 1)
        }
    }

    private fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    private fun turnRight() {
        orientation = orientation.turnRight()
    }

    fun simulate(instructions: String) {
        for (instruction in instructions) {
            when (instruction) {
                'A' -> advance()
                'R' -> turnRight()
                'L' -> turnLeft()
                else -> throw IllegalArgumentException(String.format("Invalid instruction: '%s'", instruction))
            }
        }
    }

}
