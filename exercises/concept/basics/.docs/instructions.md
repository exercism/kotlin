# Instructions

The owner of your local pizza place has asked you to help her to calculate cooking times for different pizzas. In this exercise you're going to write few functions to calculate that.

You have three tasks.

## 1. Calculate remaining baking time in minutes

Define and implement the `remainingMinutesInOven()` function that will count how many more minutes you need to keep the pizza in the oven.

The function should accept one **optional** parameter (with default value) for the amount of minutes that passed since you've started baking pizza. If the parameter is missing - assume that you've just put pizza into the oven and **0 (zero)** minutes passed already.

For simplicity - let's assume that all types of pizzas require exactly 40 minutes in the oven to be ready.

```kotlin
remainingMinutesInOven()   // => 40

remainingMinutesInOven(10)   // => 30
```

## 2. Calculate the preparation time in minutes

Before baking the pizza, you need to prepare the dough, roll it out and put toppings onto it.

Define and implement the `preparationTimeInMinutes()` function that will count how many minutes it will take to prepare pizza before putting it into the oven.

The function should accept one **required** parameter (`numberOfIngredientTypes`) for the number of topping ingredient types that will be used.

Assume that you need 5 minutes to make and roll out dough and 2 minutes for using **each** kind of topping.

```kotlin
preparationTimeInMinutes(0) // => 5

preparationTimeInMinutes(1) // => 7
```

## 3. Calculate the elapsed time in minutes

Define and implement the `elapsedCookingTimeInMinutes()` function that will count how many minutes it will take to prepare, bake and serve the pizza. Use the functions from the previous steps while making the calculations.

The function should accept two parameters. The first one is **required** and is the number of topping ingredient types. The second one is **optional** and is the serving time in minutes (assume that is 0 if not provided).

```kotlin
elapsedCookingTimeInMinutes(1)  // => 47

elapsedCookingTimeInMinutes(2, 3)  // => 52
```
