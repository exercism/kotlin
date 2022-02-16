import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class AnnalynsInfiltrationTest {

    @Test
    fun `Cannot execute fast attack if knight is awake`() {
        val knightIsAwake = true

        assertFalse(canFastAttack(knightIsAwake))
    }

    @Test
    fun `Can execute fast attack if knight is sleeping`() {
        val knightIsAwake = false

        assertTrue(canFastAttack(knightIsAwake))
    }

    @Test
    fun `Cannot spy if everyone is sleeping`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = false

        assertFalse(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if everyone but knight is sleeping`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = false
        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if everyone but archer is sleeping`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = false

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if everyone but prisoner is sleeping`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = true

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if only knight is sleeping`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = true

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if only archer is sleeping`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = true

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if only prisoner is sleeping`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = false

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can spy if everyone is awake`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = true

        assertTrue(canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Can signal prisoner ifarcher is sleeping and prisoner is awake`() {
        val archerIsAwake = false
        val prisonerIsAwake = true

        assertTrue(canSignalPrisoner(archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Cannot signal prisoner ifarcher is awake and prisoner is sleeping`() {
        val archerIsAwake = true
        val prisonerIsAwake = false

        assertFalse(canSignalPrisoner(archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Cannot signal prisoner ifarcher and prisoner are both sleeping`() {
        val archerIsAwake = false
        val prisonerIsAwake = false

        assertFalse(canSignalPrisoner(archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Cannot signal prisoner ifarcher and prisoner are both awake`() {
        val archerIsAwake = true
        val prisonerIsAwake = true

        assertFalse(canSignalPrisoner(archerIsAwake, prisonerIsAwake))
    }

    @Test
    fun `Cannot release prisoner if everyone is awake and pet dog is present`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = true
        val petDogIsPresent = true

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if everyone is awake and pet dog is absent`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = true
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Can release prisoner if everyone is asleep and pet dog is present`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = false
        val petDogIsPresent = true

        assertTrue(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if everyone is asleep and pet dog is absent`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = false
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Can release prisoner if only prisoner is awake and pet dog is present`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = true
        val petDogIsPresent = true

        assertTrue(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Can release prisoner if only prisoner is awake and pet dog is absent`() {
        val knightIsAwake = false
        val archerIsAwake = false
        val prisonerIsAwake = true
        val petDogIsPresent = false

        assertTrue(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only archer is awake and pet dog is present`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = false
        val petDogIsPresent = true

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only archer is awake and pet dog is absent`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = false
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Can release prisoner if only knight is awake and pet dog is present`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = false
        val petDogIsPresent = true

        assertTrue(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only knight is awake and pet dog is absent`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = false
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only knight is asleep and pet dog is present`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = true
        val petDogIsPresent = true

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only knight is asleep and pet dog is absent`() {
        val knightIsAwake = false
        val archerIsAwake = true
        val prisonerIsAwake = true
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Can release prisoner if only archer is asleep and pet dog is present`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = true
        val petDogIsPresent = true

        assertTrue(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only archer is asleep and pet dog is absent`() {
        val knightIsAwake = true
        val archerIsAwake = false
        val prisonerIsAwake = true
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only prisoner is asleep and pet dog is present`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = false
        val petDogIsPresent = true

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }

    @Test
    fun `Cannot release prisoner if only prisoner is asleep and pet dog is absent`() {
        val knightIsAwake = true
        val archerIsAwake = true
        val prisonerIsAwake = false
        val petDogIsPresent = false

        assertFalse(canFreePrisoner(knightIsAwake, archerIsAwake, prisonerIsAwake, petDogIsPresent))
    }
}
