import org.junit.Ignore
import org.junit.Test
import java.util.concurrent.CountDownLatch
import kotlin.concurrent.thread
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

        assertFailsWith(IllegalStateException::class, {account.balance})
    }

    @Ignore
    @Test
    fun closedAccountCannotBeAdjusted() {
        val account = BankAccount()
        account.close()

        assertFailsWith(IllegalStateException::class, {account.adjustBalance(1000)})
    }

    @Ignore
    @Test
    fun concurrentBalanceAdjustments() {
        val threads = 100
        val iterations = 500
        val startLatch = CountDownLatch(1)
        val endLatch = CountDownLatch(threads)

        val account = BankAccount()

        repeat (threads) {
            thread {
                startLatch.await()
                repeat(iterations) {
                    account.adjustBalance(1)
                    account.adjustBalance(-1)
                }
                endLatch.countDown()
            }
        }

        startLatch.countDown()
        endLatch.await()

        assertEquals(0, account.balance)
    }

}

