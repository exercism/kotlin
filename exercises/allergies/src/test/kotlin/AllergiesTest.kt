import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class AllergiesTest {


    @Test
    fun noAllergiesMeansNotAllergicToAnything() {
        val allergies = Allergies(0)

        assertEquals(false, allergies.isAllergicTo(Allergen.EGGS))
        assertEquals(false, allergies.isAllergicTo(Allergen.PEANUTS))
        assertEquals(false, allergies.isAllergicTo(Allergen.STRAWBERRIES))
        assertEquals(false, allergies.isAllergicTo(Allergen.CATS))
    }

    @Ignore
    @Test
    fun allergicToEggs() {
        val allergies = Allergies(1)

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS))
    }

    @Ignore
    @Test
    fun allergicToPeanuts() {
        val allergies = Allergies(2)

        assertEquals(true, allergies.isAllergicTo(Allergen.PEANUTS))
    }

    @Ignore
    @Test
    fun allergicToShellfish() {
        val allergies = Allergies(4)

        assertEquals(true, allergies.isAllergicTo(Allergen.SHELLFISH))
    }

    @Ignore
    @Test
    fun allergicToStrawberries() {
        val allergies = Allergies(8)

        assertEquals(true, allergies.isAllergicTo(Allergen.STRAWBERRIES))
    }

    @Ignore
    @Test
    fun allergicToTomatoes() {
        val allergies = Allergies(16)

        assertEquals(true, allergies.isAllergicTo(Allergen.TOMATOES))
    }

    @Ignore
    @Test
    fun allergicToChocolate() {
        val allergies = Allergies(32)

        assertEquals(true, allergies.isAllergicTo(Allergen.CHOCOLATE))
    }

    @Ignore
    @Test
    fun allergicToPollen() {
        val allergies = Allergies(64)

        assertEquals(true, allergies.isAllergicTo(Allergen.POLLEN))
    }

    @Ignore
    @Test
    fun allergicToCats() {
        val allergies = Allergies(128)

        assertEquals(true, allergies.isAllergicTo(Allergen.CATS))
    }

    @Ignore
    @Test
    fun isAllergicToEggsInAdditionToOtherStuff() {
        val allergies = Allergies(5)

        assertEquals(true, allergies.isAllergicTo(Allergen.EGGS))
    }

    @Ignore
    @Test
    fun noAllergies() {
        val allergies = Allergies(0)

        assertEquals(0, allergies.getList().size)
    }

    @Ignore
    @Test
    fun isAllergicToJustEggs() {
        val allergies = Allergies(1)
        val expectedAllergens = listOf(Allergen.EGGS)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToJustPeanuts() {
        val allergies = Allergies(2)
        val expectedAllergens = listOf(Allergen.PEANUTS)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToJustStrawberries() {
        val allergies = Allergies(8)
        val expectedAllergens = listOf(Allergen.STRAWBERRIES)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToEggsAndPeanuts() {
        val allergies = Allergies(3)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.PEANUTS
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToEggsAndShellfish() {
        val allergies = Allergies(5)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.SHELLFISH
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToLotsOfStuff() {
        val allergies = Allergies(248)
        val expectedAllergens = listOf(
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun isAllergicToEverything() {
        val allergies = Allergies(255)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.PEANUTS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun ignoreNonAllergenScoreParts() {
        val allergies = Allergies(509)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.SHELLFISH,
                Allergen.STRAWBERRIES,
                Allergen.TOMATOES,
                Allergen.CHOCOLATE,
                Allergen.POLLEN,
                Allergen.CATS
        )

        assertEquals(expectedAllergens, allergies.getList())
    }
}
