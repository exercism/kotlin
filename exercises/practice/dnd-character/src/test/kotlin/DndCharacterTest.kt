import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DndCharacterTest {

    @Test
    fun `ability modifier for score 3 is n4`() = assertEquals(-4, DndCharacter.modifier(3))

    @Ignore
    @Test
    fun `ability modifier for score 4 is n3`() = assertEquals(-3, DndCharacter.modifier(4))

    @Ignore
    @Test
    fun `ability modifier for score 5 is n3`() = assertEquals(-3, DndCharacter.modifier(5))

    @Ignore
    @Test
    fun `ability modifier for score 6 is n2`() = assertEquals(-2, DndCharacter.modifier(6))

    @Ignore
    @Test
    fun `ability modifier for score 7 is n2`() = assertEquals(-2, DndCharacter.modifier(7))

    @Ignore
    @Test
    fun `ability modifier for score 8 is n1`() = assertEquals(-1, DndCharacter.modifier(8))

    @Ignore
    @Test
    fun `ability modifier for score 9 is n1`() = assertEquals(-1, DndCharacter.modifier(9))

    @Ignore
    @Test
    fun `ability modifier for score 10 is 0`() = assertEquals(0, DndCharacter.modifier(10))

    @Ignore
    @Test
    fun `ability modifier for score 11 is 0`() = assertEquals(0, DndCharacter.modifier(11))

    @Ignore
    @Test
    fun `ability modifier for score 12 is 1`() = assertEquals(1, DndCharacter.modifier(12))

    @Ignore
    @Test
    fun `ability modifier for score 13 is 1`() = assertEquals(1, DndCharacter.modifier(13))

    @Ignore
    @Test
    fun `ability modifier for score 14 is 2`() = assertEquals(2, DndCharacter.modifier(14))

    @Ignore
    @Test
    fun `ability modifier for score 15 is 2`() = assertEquals(2, DndCharacter.modifier(15))

    @Ignore
    @Test
    fun `ability modifier for score 16 is 3`() = assertEquals(3, DndCharacter.modifier(16))

    @Ignore
    @Test
    fun `ability modifier for score 17 is 3`() = assertEquals(3, DndCharacter.modifier(17))

    @Ignore
    @Test
    fun `ability modifier for score 18 is 4`() = assertEquals(4, DndCharacter.modifier(18))

    @Ignore
    @Test
    fun `random ability is within range`() {
        val score = DndCharacter.ability()
        assertTrue(score in (3..18))
    }

    @Ignore
    @Test
    fun `random character is valid`() {
        with (DndCharacter()) {
            assertTrue(strength in (3..18))
            assertTrue(dexterity in (3..18))
            assertTrue(constitution in (3..18))
            assertTrue(intelligence in (3..18))
            assertTrue(wisdom in (3..18))
            assertTrue(charisma in (3..18))
            assertEquals(10 + DndCharacter.modifier(constitution), hitpoints)
        }
    }

    @Ignore
    @Test
    fun `each ability is only calculated once`() {
        val char = DndCharacter()
        assertTrue(char.strength == char.strength)
    }
}
