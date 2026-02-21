# Introduction

A [`List`][ref-lists] is an *ordered* collection of items of a specified type.

”Ordered” here means that the items have a specific spot in the list (their *index*), **not** that they are sorted.

You use a list in Kotlin when you have multiple values that all represent the same kind of thing (e.g. chat messages, names) and you want to store and process them together instead of using many separate variables.

There are two common ways to work with lists in Kotlin:
- `List`: a read-only list (no add/remove/set operations).
- `MutableList`: a mutable list that you can modify after creation
## Creating
### Read-only
A `read-only` list is created using the `listOf()` built-in function.
```kotlin
listOf(0, 1, 2)
```
In this example, Kotlin will automatically recognize the type to be `List<Int>`, a list of integers.
You can specify the type in multiple ways:
1. `listOf<type>(…)`
2. `val name: List<type> = listOf()`
These are equivalent, but generally 2. is more idiomatic and more readable as it is easier to figure out the type of the variable/value.

### Mutable
Initializing a `mutable` list works the same way as the `read-only` list, but you use `mutableListOf()`.

~~~~exercism/caution
When creating an empty list using any of the above methods, you **must** specify a type, because kotlin can’t guess the type. Kotlin does not look into future references to guess the type.
~~~~

## Using
### Accessing
You can access an item in a list using its [**index**][ref-get-by-index]:
```kotlin
val list = listOf(1, 2, 3)
println(list[0])  // prints: 1
```

### Looping over a list
To do something for every item in a list, you can use [`for`][ref-for]
```kotlin
val list = listOf(1, 2, 3)
for (item in list) {
    // Do something with the item
}
```

#### With index
Often you need to know the index of the item you are currently dealing with in the loop. For this you use [`for` and `list.withIndex()`][ref-for-withIndex]
```kotlin
for ((index, item) in list.withIndex()) 
    // Do something with the item and the index
}
```

### Writing (only for `mutable` lists)
#### Adding
You can add an element to the end of a list using [`list.add()`][ref-list-add]
```kotlin
val list = mutableListOf(0, 1, 2, 3)
list.add(4)  // 0, 1, 2, 3, 4
```
Or at a specific index in a list:
```kotlin
val list = mutableListOf("one", "three")
list.add(1, "two")  // "one", "two", "three"
```

#### Have fun with lists in Kotlin!

[ref-lists]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/
[ref-for]: https://kotlinlang.org/docs/control-flow.html#for-loops
[ref-for-withIndex]: https://kotlinlang.org/docs/control-flow.html#arrays
[ref-list-add]: https://kotlinlang.org/docs/list-operations.html#add
[ref-get-by-index]: https://kotlinlang.org/docs/list-operations.html#retrieve-elements-by-indexe

str.toCharArray()      // => [H, e, l, l, o,  , W, o, r, l, d, !]
"42".toInt() + 1       // => 43  (parsing; see also toFloat)
```


[ref-string]: https://kotlinlang.org/docs/strings.html
[wiki-immutable]: https://en.wikipedia.org/wiki/Immutable_object
[wiki-unicode]: https://en.wikipedia.org/wiki/Unicode
[ref-stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[ref-extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
