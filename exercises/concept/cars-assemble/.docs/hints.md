# Hints

## General

- To learn more about type conversions in Kotlin, check [Explicit number conversions][type conversions].

## 1. Calculate the number of working cars produced per hour

- The percentage (passed as an argument) is a number between 0-100. To make this percentage a bit easier to work with, start by dividing it by 100.
- To compute the number of cars produced successfully, multiply the percentage (divided by 100) by the number of cars produced.

## 2. Calculate the number of working cars produced per minute

- Start by calculating the production of successful cars per hour. For this, you can use the function you implemented from the previous step.
- Knowing the production per hour of cars, you can get the production per minute by dividing the production per hour by 60 (the number of minutes in an hour).
- Remember to cast the result to an `Int`

## 3. Calculate the cost of production

- Start by working out how many groups of 10 cars there are. You can do this by dividing the number of cars by 10.
- Then work out how many cars are remaining (the [modulo operator][modulo operator] is useful for this).
- To arrive at the cost, multiply the number of groups by the cost to produce 10 cars and then multiply the number of cars remaining by the cost to produce each individual car. Then sum the results of the multiplication together.

[type conversions]: https://kotlinlang.org/docs/numbers.html#explicit-number-conversions
[modulo operator]: https://www.baeldung.com/kotlin/integer-division-modulus