# About Higher Order Functions

Functions in Kotlin are first class citizens.
This means they can be stored in variables, passed as arguments and even returned by other functions.
For example, assigning a function to the variable `addOne`:

```kotlin
val addOne = fun (num : Int) : Int {
    return num + 1
}
```

A function can also return another function:

```kotlin
fun makeAddOne() : (Int) -> Int {
    return fun(num : Int) : Int {
        return num + 1
    }
}
```

Once assigned, the function can be called through the variable as if it was just another function:
```kotlin
addOne(3)
// => 4
```

## Declaring function types

A variable or parameter type can be declared using the syntax `(parameter types) -> return type`.
For example, declaring a variable:

```kotlin
val addOne : (Int) -> Int = fun (num : Int) : Int {
    return num + 1
}
```

And for a function parameter:

```kotlin
fun perform(operation : (Int) -> Int) {
    operation(3)
}
```

## Lambda expressions

A lambda expression is a shorter way of defining a function.
They are written in the form `{ parameters -> body }`.
The expression returns the last value from the last statement in the body.
For example:

```kotlin
// Assigning to a variable
val addOne = { num : Int -> num +  1}

// In a function call
perform({ num : Int -> num + 1 })
```

Kotlin can infer types when there is enough information.
For example, the above examples can also be written as:

```kotlin
// Assigning to a variable
val addOne : (Int) -> Int = { num -> num + 1 }

// Or ...
val addOne  = { num : Int -> num + 1 }

// Using in a function
perform({ num -> num + 1 })
```

## `it` for single parameter lambdas

When the expression has just one parameter, the parameter can be omitted.
Kotlin will then make a parameter called `it` available in the body.
For example:

```kotlin
val addOne : (Int) -> Int = { it +  1 }
```

## Passing trailing lambdas

When the last argument to a function is a lambda, the lambda expression is written directly _after_ the parentheses.
For example:

```kotlin
// Function that takes a function as last argument
fun calculateFrom(from : Int, operation : (Int) -> Int) : Int {
    return operation(from)
}

// Call the calculateFrom function
calculateFrom(2) { it * 3 }
// => 6
```
