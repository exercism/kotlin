# Instructions

Hello, Agent Double-Null0111.

Your mission, should you choose to accept it, is to write a pair of tools to help you infiltrate UMBRA (United Minions Being Really Awful) headquarters and retrieve the plans for their latest really awful scheme. 
There are three tools you will need to carry out this mission.

## 1. Generate an id number

Each minion has a unique identifier that changes each day and depends on the number of secrets they hold and the number of hours they sleep.
You will need to write a function that takes the day (as an `Int`) and creates an identifier generating function for the day.
The identifier is calculated by:

1. Multiply the number of secrets held by the number of hours they sleep
2. Add the day (represented as an `Int`) to the result

```kotlin
val idGenerator = makeIdGenerator(4)
idGenerator(3, 6)
// => 22

idGenerator(11, 5)
//  => 59
```

## 2. Protect the recovered secret plans with a secret password

Once you have the secret plans, you will need to protect it so that only those who know the password can recover them.
In order to do this, you will need to implement the function `protectSecret(secret: String, password: String) : (String) -> String`.
This function will return another function that takes possible password strings as input.
If the entered password is correct the new function returns the hidden secret, but if the password is incorrect, the function returns "Sorry. No hidden secrets here."

```kotlin
val secretFunction = protectSecret("Steal the world's supply of french fries!", "5up3r53cr37")

secretFunction("Open sesame")
// Returns "Sorry. No hidden secrets here."

secretFunction("5up3r53cr37")
// Returns "Steal the world's supply of french fries!"
```

## 3. Find the secret password

The UMBRA base has a number of rooms guarded by a security guard who will ask you for the secret password.
The secret password depends on the room'sS number.
Unfortunately, we have know only half of the algorithm for working out the password.
The other half can be found by asking one of the minions.

Implement the `getPassword` function that takes in the room number and the minion's function and returns the secret password.
The secret number is obtained by calling the minion's function with another function representing the algorithm known by us.
Our part of the algorithm:

1. Takes two numbers and adds them together
2. Multiplies the result by the room id

```kotlin
val minionFunction = { yourFunc : (Int, Int) -> Int ->
    "Password=${yourFunc(1, 3)}"
}

getPassword(5, minionFunction)
// Returns "Password=20"
```
