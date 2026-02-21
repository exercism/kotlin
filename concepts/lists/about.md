# About lists in Kotlin

A [`List`][ref-lists] is an _ordered_ collection of items of a specified type.

”Ordered” here means that the items have a specific spot in the list (their _index_), **not** that they are sorted.

You use a list in Kotlin when you have multiple values that all represent the same kind of thing (e.g. chat messages, names) and you want to store and process them together instead of using many separate variables.

There are two common ways to work with lists in Kotlin:
- `List`: a read-only view of a list (no add/remove/set operations _through this reference_).
- `MutableList`: a mutable list that you can modify after creation.

~~~~exercism/advanced
The reason I say “through this reference” in `List` is because you cannot call e.g. `add` on that object, _but_ if it is a reference to mutable list, that list can be modified in the background (But not through the `List`).
```kotlin
val mutable = mutableListOf(0)
val readOnly: List<Int> = mutable

readOnly.add(1)  // ERROR
mutable.add(1)  // 0, 1
println(readOnly)  // 0, 1 
```
as you see the list has been modified even though `List` is _read only_ (not _immutable_)
~~~~
## Creating
### Read-only
A _read-only_ list is created using the `listOf()` built-in function.
```kotlin
listOf(0, 1, 2)
```
In this example, Kotlin will automatically recognize the type to be `List<Int>`, a list of integers.
You can specify the type in multiple ways:
1. `listOf<type>(…)`
2. `val name: List<type> = listOf()`
These are equivalent, but generally 2. is more idiomatic and more readable as it is easier to figure out the type of the variable/value.

### Mutable
Initializing a mutable list works the same way as the read-only list, but you use `mutableListOf()`.

~~~~exercism/caution
When creating an empty list using any of the above methods, you **must** specify a type, because kotlin can’t guess the type. Kotlin does not look into future references to guess the type.
~~~~
### Converting and copying
You can convert other types of Sequences (collections, strings) to a `List` using `.toList()`, and to a `MutableList` using `.toMutableList()`.
- `String.toList()` → A list of `Char` (single characters): `"funny".toList() == listOf('f', 'u', 'n', 'n', 'y')`

Sometimes you need/should copy a list to prevent modifying a `MutableList` that is also used somewhere else.
You can also use the above-mentioned methods on lists to create a copy.
### Ranges
~~~~exercism/caution
These range operations return _range_ objects (`IntRange` in this case). You need to call `(0..10).toList()` or `.toMutableList`
~~~~
To create a range with values from e.g. 0 to 10, you can use multiple methods:
- `0..10`: Inclusive range. Includes the bottom and the top value.
- `0 until 11`: End-exclusive (half-open) range. It includes the bottom value but excludes the top value.
You can also:
- Change the step size: `0..10 step 2` (`0, 2, 4, …, 10`)
- Go downward: `10 downTo 0` (`10, 9, 8 , …, 0`)
## Using
### Retrieve
You can access an item in a list using its [**index**][ref-get-by-index]:
```kotlin
val list = listOf(1, 2, 3)
println(list[0])  // prints: 1
```
If you don’t know if the index exists, try `list.getOrNull(index)` that returns `null` if the index doesn’t exist.
Further useful retrieve operations:
- `list.first()`, `list.last()` get the first/last item of a list. If the list is empty, this will error (throws `NoSuchElementException`).
- `list.firstOrNull()`, `list.lastOrNull()` same as `first` and `last`, but returns `null` instead of an error.

### Find or check presence in a list
To find the index of value in a list, use:
- `list.indexOf(value)`, `list.lastIndexOf(value)`: returns the first/last index the value is found at, or -1 if it doesn’t exist
- `list.indexOfFirst { rule }`, `list.indexOfLast { rule }`: return the first/last index for which the `rule` returns true (-1 if it doesn’t exist. The rule gets the item as an input. An example is :
	```kotlin
	val list = listOf(1, 2, 3, 4, 1)
	list.indexOfFirst { it > 2 }  // returns 2 for the value 3
	list.indexOfLast { item ->  // you can explicitly name the input instead of using `it` 
	    item > 1 
	}  // returns 3 for the value 4
	```
to check whether a value exists in a list, use `list.contains(value)` or alternatively `value in list`
### Looping over a list
To do something for every item in a list, you can use [`for`][ref-for]
```kotlin
val list = listOf(1, 2, 3)
for (item in list) {
    // Do something with the item
}
```
Or you could use [`forEach`][ref-forEach]
```kotlin
list.forEach { item ->
    // do something with the item
}
```

Generally speaking you can always do `for`, and it is often preferred. You can use `forEach` when you want to pass a short, often side-effecting lambda, or at the end of a chain transformation:
```kotlin
list
    .filter { ... }
    .map { ... }  // these two are seen later
    .forEach { ... }
```
#### With index
Often you need to know the index of the item you are currently dealing with in the loop. For this you can use [`for` and `list.withIndex()`][ref-for-withIndex]
```kotlin
for ((index, item) in list.withIndex()) {
    // Do something with the item and the index
}
```
or its small sibling `forEach`_`Indexed`_ :
```kotlin
list.forEachIndexed { index, item -> 
    // Do something with the item and the index
}
```

### Writing (only for `MutableList`)
~~~~exercism/note
These functions do **not** return the MutableList, they modify it!

You _cannot_ do 
`list.add(4).filter { ... }`, because the list is not returned by add(4)!
~~~~
~~~~exercism/advanced
If you really want your code to work with a `List` but need `MutableList` operations in one place, you can do 
```kotlin
list.toMutableList().add(1)  // or other operations
```
Later you can `.toList()` it again.

If you plan on doing that, I recommend you wrap your `MutableList` opearions in `.apply { ... }` (see below) because that returns the `MutableList` itself, allowing for something like
```kotlin
list.toMutableList().apply { 
    add(1)
    // other operations
}.toList()
```
~~~~


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
#### Removing
##### At index
For this you can use `removeAt(index)`:
```kotlin
val list = mutableListOf(1, 2, 2, 3)
list.removeAt(2)  // 1, 2, 3
```
##### By Value
Here you need to differentiate:
- Remove the first occurrence: `remove(value)`:
	- ```kotlin
	  val list = mutableListOf(1, 2, 2, 3)
	  list.remove(2)  // 1, 2, 3
	  ```
- Remove all occurrences of one or multiple values, or use a more complex pattern: `removeAll`
`removeAll` has multiple different ways of using it:
1. With a list of values:
	```kotlin
	val list = mutableListOf(1, 2, 2, 3, 4)
	list.removeAll(listOf(2, 3)) // 1, 4 
	```
2. With a lambda:
	```kotlin
	val list = mutableListOf(1, 2, 2, 3, 4)
	list.removeAll { it == 2 } // 1, 3, 4
	```
	This executes the lambda `{ it == 2 }` for all items and removes the items for which it returns true. The lambda must return a boolean.
	Note that `it` is simply the default name for the input of a lambda (only if there is **only one**), you could also do
	```kotlin
	list.removeAll { item -> item == 2 }
	```
#### Updating an element
This is simply done with `=`:
```kotlin
val list = mutableListOf(1, 2, 4, 4)
list[2] = 3  // 1, 2, 3, 4
```

### Advanced operations
#### `map`
`map` is a _really_ powerful tool to produce a transformed copy of a list 1-to-1. It works by executing the given lambda for every element, and putting the value it returns into a new list and returns that list.
```kotlin
val list = listOf(1, 2, 3)
list.map { item ->  // you could omit this and use `it` instead
    item * 2
} 
// 2, 4, 6
```

And of course, we can also do this with the index with (who could have guessed): `mapIndexed`
```kotlin
val list = listOf(1, 2, 3)
list.mapIndexed { index, item ->  // You can’t use `it` here! (2 arguments)
    item * index
}  // [0, 2, 6]
```
#### `filter`
`filter` can be used to create a copy of a list with specific filtering. It uses a lambda just like `removeAll` that returns `true` or `false` given the item, but in this case `false` will remove that item.
The difference in purpose to `removeAll` is that this returns the filtered list and doesn’t alter the list (and with that can be used on both `MutableList` and `List`). 
```kotlin
val list = 1..10.toList()
list.filter {
    it <= 5
}  // 1, 2, 3, 4, 5
```
And of course you can also have the `indexed` version with `filterIndexed`.

##### `flatMap`
This is `map` but your lambda has to return multiple items for every original item. Those multiple items get flattened and added to the output list.
```kotlin
val list = listOf(1, 3, 5)
list.flatMap {
    listOf(it, it + 1)  // [1, 2] for the item `1`, gets added as individual items
}  // [1, 2, 3, 4, 5, 6] 
```
And for this there is also `flatMapIndexed`, of course.
##### `apply`
This function can be used on all kinds of objects, including lists. It allows to call functions on a list and then return the result in a neat way. Inside the `.apply { }` block, you don’t need to write `list.operation()`, you can just call `operation()`
```kotlin
val list = mutableListOf()
list.apply {
	add(0)
	add(2)
	removeAt(0)
}  // [2]
```
~~~~exercism/note
You _can_ call .apply on a `List`, but the write operations will still not be available.
~~~~
#### Have fun with lists in Kotlin!

[ref-lists]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/
[ref-for]: https://kotlinlang.org/docs/control-flow.html#for-loops
[ref-for-withIndex]: https://kotlinlang.org/docs/control-flow.html#arrays
[ref-list-add]: https://kotlinlang.org/docs/list-operations.html#add
[ref-get-by-index]: https://kotlinlang.org/docs/list-operations.html#retrieve-elements-by-index