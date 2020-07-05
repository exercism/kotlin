Owner of your local pizza place asked you to help her to count cooking time for different pizzas. In this exercise you're going to write few functions to calculate that.

You have three tasks.

## 1. Calculate remaining baking time in minutes

Define and implement `remainingMinutesInOven()` function that will count how many more minutes you need to keep pizza in the oven.

Function should accept one **optional** parameter (with default value) for the amount of minutes that passed since you've started baking pizza. If parameter is missing - assume that you've just put pizza into the oven and **0 (zero)** minutes passed already.

For the simplicity - let's assume that all types of pizzas requires exactly 40 minutes in the oven to be ready.

```kotlin
remainingMinutesInOven()   // => 40

remainingMinutesInOven(10)   // => 30
```

## 2. Calculate the preparation time in minutes

Before baking pizza you need to prepare dough, roll it out and put toppings onto it.

Define and implement `preparationTimeInMinutes()` function that will count how many minutes it will take to prepare pizza before putting it into the oven.

Function should accept one **required** parameter (`numberOfIngredientTypes`) for the number of topping ingredient types that will be used.

Assume that you need 5 minutes to make and roll out dough and 2 minutes for using **each** kind of topping.

```kotlin
preparationTimeInMinutes(0) // => 5

preparationTimeInMinutes(1) // => 7
```

## 3. Calculate the elapsed time in minutes

Define and implement `elapsedCookingTimeInMinutes()` function that will count how many minutes it will take to prepare, bake and serve pizza. Use functions from previous steps while making the calculations.

Function should accept two parameters. First one is **required** and is the number of topping ingredient types. Second one is **optional** and is the serving time in minutes (assume that is 0 if not provided).

```kotlin
elapsedCookingTimeInMinutes(1)  // => 47

elapsedCookingTimeInMinutes(2, 3)  // => 52
```

_Hint_: Use variables to give nice and readable names for your values. Remember that code readability is much more important than amount of code lines.
