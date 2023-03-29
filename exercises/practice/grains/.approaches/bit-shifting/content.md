# Bit-shifting

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

An [object declaration][object] is used to define `Board` as essentially a [singleton][singleton] object instantiation of the class.
This is sufficient, since there is no object state that needs to change with each call of the `getGrainCountForSquare` or `getTotalGrainCount` methods.

The `getGrainCountForSquare` method is implemented by an `if/else` expression.
Although the function has multiple lines, it consists only of the one `if/else` expression,
so it is defined using [single-expression function][single-expression-function] syntax,
with the curly braces omitted from the function call and the return type [inferred][type-inference].

An `IllegalArgumentException` is thrown if the number is out of bounds.

Otherwise, to calculate the grains on a square you can set a bit in the correct position of a [`BigInteger`][biginteger] value.

To understand how this works, consider just two squares that are represented in binary bits as `00`.

You use the [`BigInteger.shiftLeft()`][shiftleft] method to set `1` (i.e. [`BigInteger.ONE`][one]) at the position needed to make the correct decimal value.

- To set the one grain on Square One you shift `1` for `0` positions to the left.
So, if `square` is `1` for square One, you subtract `square` by `1` to get `0`, which will not move it any positions to the left.
The result is binary `01`, which is decimal `1`.
- To set the two grains on Square Two you shift `1` for `1` position to the left.
So, if `square` is `2` for square Two, you subtract `square` by `1` to get `1`, which will move it `1` position to the left.
The result is binary `10`, which is decimal `2`.

| Square  | Shift Left By | Binary Value | Decimal Value |
| ------- | ------------- | ------------ | ------------- |
|       1 |             0 |         0001 |             1 |
|       2 |             1 |         0010 |             2 |
|       3 |             2 |         0100 |             4 |
|       4 |             3 |         1000 |             8 |

For `getTotalGrainCount` we want all of the 64 bits set to `1` to get the sum of grains on all sixty-four squares.
The easy way to do this is to set the 65th bit to `1` and then subtract `1`.
To go back to our two-square example, if we can grow to three squares, then we can shift `BigInteger.ONE` two positions to the left for binary `100`,
which is decimal `4`.
By subtracting `1` we get `3`, which is the total amount of grains on the two squares.

| Square  | Binary Value | Decimal Value |
| ------- | ------------ | ------------- |
|       3 |         0100 |             4 |

| Square  | Sum Binary Value | Sum Decimal Value |
| ------- | ---------------- | ----------------- |
|       1 |             0001 |                 1 |
|       2 |             0011 |                 3 |

[object]: https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
[singleton]: https://en.wikipedia.org/wiki/Singleton_pattern
[single-expression-function]: https://kotlinlang.org/docs/functions.html#single-expression-functions
[type-inference]: https://kotlinlang.org/spec/type-inference.html
[biginteger]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
[shiftleft]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#shiftLeft(int)
[one]: https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html#ONE
