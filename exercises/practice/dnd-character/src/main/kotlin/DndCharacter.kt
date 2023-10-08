import java.lang.Math.floorDiv
import kotlin.random.Random

class DndCharacter {

    val strength = ability()
    val dexterity = ability()
    val constitution = ability()
    val intelligence = ability()
    val wisdom = ability()
    val charisma = ability()
    val hitpoints = 10 + modifier(constitution)

    companion object {

        fun ability() = (1..4)
            .map { Random.nextInt(1, 6) }
            .sorted()
            .drop(1)
            .sum()

        fun modifier(score: Int) = floorDiv(score - 10, 2)
    }

}
