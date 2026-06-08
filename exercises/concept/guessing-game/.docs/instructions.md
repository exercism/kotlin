# Instructions

In this exercise, you are playing a number guessing game with a friend. 
The rules are simple: you secretly choose a number between `1` and `100` and your friend tries to guess what number you've chosen. 
To help your friend, you respond differently depending on how close the guess was to the number you've chosen (`42`) and how many guesses have been made. 
These are the rules for the different replies:

- If the guess is `42`: "Correct"
- If the guess is `41` or `43` and there have been less than : "So close"
- If the guess is less than `41`: "Too low"
- If the guess is greater than `43`: "Too high"

You have four tasks to encode the replies to the guesses.

## 1. Reply to a correct guess

Implement the `reply` function to reply to a correct guess:

```kotlin
reply(42, 1)
// => "Correct"
```

## 2. Reply to a close guess

Modify the `reply` function to reply to close guesses:

```kotlin
reply(41, 1)
// => "So close"
```

## 3. Reply to too low guesses

Modify the `reply` function to reply to too low guesses:

```kotlin
reply(25, 1)
// => "Too low"
```

## 4. Reply to too high guesses

Modify the `reply` function to reply to too high guesses:

```kotlin
reply(88, 1)
// => "Too high"
```

## 5. Reply to a close guess after more than 5 guesses

Modify the `reply` function to reply to close guesses after more than 5 guesses have been made.

```kotlin
reply(43, 6)
// => "Try one lower"
```