import org.junit.Ignore
import org.junit.Test
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BankAccountTest {

    @Test
    fun zeroBalanceWhenOpened() {
        val account = BankAccount()
        assertEquals(0, account.balance)
    }

    @Ignore
    @Test
    fun sequentialBalanceAdjustments() {
        val account = BankAccount()

        account.adjustBalance(1000)
        assertEquals(1000, account.balance)

        account.adjustBalance(-958)
        assertEquals(42, account.balance)
    }

    @Ignore
    @Test
    fun closedAccountHasNoBalance() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class) { account.balance }
    }

    @Ignore
    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class) { account.adjustBalance(1000) }
    }

    @Ignore
    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 100
        val iterations = 500
        val random = Random()

        val account = BankAccount()

        val executor = Executors.newFixedThreadPool(8)

        repeat(threads) {
            executor.submit {
                repeat(iterations) {
                    account.adjustBalance(1)
                    Thread.sleep(random.nextInt(10).toLong())
                    account.adjustBalance(-1)
                }
            }
        }

        executor.shutdown()
        executor.awaitTermination(10, TimeUnit.MINUTES)

        assertEquals(0, account.balance)
    }

}

