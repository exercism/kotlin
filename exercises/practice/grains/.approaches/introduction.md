# Introduction

There are various idiomatic approaches to solve Grains.
One approach can use `BigInteger` bit-shifting calculate the number on grains on a square.

## General guidance

The key to solving Grains is to focus on each square having double the amount of grains as the square before it.
This means that the amount of grains grows exponentially.
The first square has one grain, which is `2` to the power of `0`.
The second square has two grains, which is `2` to the power of `1`.
The third square has four grains, which is `2` to the power of `2`.
You can see that the exponent, or power, that `2` is raised by is always one less than the square number.

| Square | Power | Value                   |
| ------ | ----- | ----------------------- |
| 1      | 0     | 2 to the power of 0 = 1 |
| 2      | 1     | 2 to the power of 1 = 2 |
| 3      | 2     | 2 to the power of 2 = 4 |
| 4      | 3     | 2 to the power of 3 = 8 |

## Approach: Bit-shifting

```kotlin
import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int) =
            if (number < 1 || number > 64)
                    throw IllegalArgumentException("square must be between 1 and 64")
            else BigInteger.ONE.shiftLeft(number - 1)

    fun getTotalGrainCount() = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE)
}
```

For more information, check the [Bit-shifting approach][approach-bit-shifting].

[approach-bit-shifting]: https://exercism.org/tracks/kotlin/exercises/grains/approaches/bit-shifting
