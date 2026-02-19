# Introduction

A [`List`][ref-lists] is a collection of items of a specified type.

There are two types of lists. One is `mutable` and the other is `read-only`

`read-only` means the list contents cannot be directly changed
`mutable` means the list contents can be changed after creation

## Creating
### Read-only
A `read-only` list is created using the `listOf()` builtin function.
```kotlin
listOf(0, 1, 2)
```
In this example, kotlin will automatically recognize the type to be `List<Int>`, a list of integers.
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
You can access an item in a list using it’s [**index**][ref-get-by-index]:
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
for ((index, item) in list.withIndex()) {
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
[ref-get-by-index]: https://kotlinlang.org/docs/list-operations.html#retrieve-elements-by-index       // => 12 (a property, not a function)
str.elementAt(6)        // => W
str.elementAtOrNull(20) // => null (index out of range)
str.substring(6, 11)    // => "World"

str.lowercase()        // => "hello world!"
str.uppercase()        // => "HELLO WORLD!"

str.startsWith("Hel")  // => true
str.endsWith("xyz")    // => false

str.toCharArray()      // => [H, e, l, l, o,  , W, o, r, l, d, !]
"42".toInt() + 1       // => 43  (parsing; see also toFloat)
```


[ref-string]: https://kotlinlang.org/docs/strings.html
[wiki-immutable]: https://en.wikipedia.org/wiki/Immutable_object
[wiki-unicode]: https://en.wikipedia.org/wiki/Unicode
[ref-stringbuilder]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/-string-builder/
[ref-extensions]: https://kotlinlang.org/docs/extensions.html#extensions.md
[ref-string-functions]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
