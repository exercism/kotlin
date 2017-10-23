import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AllergiesTest {

    @Test
    fun noAllergiesMeansNotAllergicToAnything() {
        val allergies = Allergies(0)

        assertFalse(allergies.isAllergicTo(Allergen.PEANUTS))
        assertFalse(allergies.isAllergicTo(Allergen.CATS))
        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES))
    }

    @Ignore
    @Test
    fun allergicToEggs() {
        val allergies = Allergies(1)

        assertTrue(allergies.isAllergicTo(Allergen.EGGS))
    }

    @Ignore
    @Test
    fun allergicToEggsAndOtherThings() {
        val allergies = Allergies(5)

        assertTrue(allergies.isAllergicTo(Allergen.EGGS))
        assertTrue(allergies.isAllergicTo(Allergen.SHELLFISH))
        assertFalse(allergies.isAllergicTo(Allergen.STRAWBERRIES))
    }

    @Ignore
    @Test
    fun noAllergies() {
        val allergies = Allergies(0)

        assertTrue(allergies.getList().isEmpty())
    }

    @Ignore
    @Test
    fun allergicToJustEggs() {
        val allergies = Allergies(1)
        val expectedAllergens = listOf(Allergen.EGGS)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun allergicToJustPeanuts() {
        val allergies = Allergies(2)
        val expectedAllergens = listOf(Allergen.PEANUTS)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun allergicToJustStrawberries() {
        val allergies = Allergies(8)
        val expectedAllergens = listOf(Allergen.STRAWBERRIES)

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun allergicToEggsAndPeanuts() {
        val allergies = Allergies(3)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.PEANUTS
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun allergicToEggsAndShellfish() {
        val allergies = Allergies(5)
        val expectedAllergens = listOf(
                Allergen.EGGS,
                Allergen.SHELLFISH
        )

        assertEquals(expectedAllergens, allergies.getList())
    }

    @Ignore
    @Test
    fun allergicToLotsOfStuff() {
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
    fun allergicToEverything() {
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
