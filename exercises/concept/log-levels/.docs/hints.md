# Hints

## General

- Kotlin provides many [functions][ref-strings] for working with Strings. Be sure to check out the `Members & Extensions` tab! 

## 1. Get message from a log line

- There is a [function][ref-string-substringAfter] to extract the part of a `String` after a given delimiter.
- Removing whitespace from a `String` is explored in [Remove All Whitespaces from a String in Kotlin][tutorial-trim-white-space].

## 2. Get log level from a log line

- There is also a [function][ref-string-substringBefore] to extract part of a `String` _before_ a given delimiter.
- There is a [way][ref-string-lowercase] to change a `String` to lowercase.

## 3. Reformat a log line

- [String templates][docs-string-template] can be done with a [multiline string][docs-string-multiline].

[docs-string-multiline]: https://kotlinlang.org/docs/strings.html#multiline-strings
[docs-string-template]: https://kotlinlang.org/docs/strings.html#string-templates
[ref-strings]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/
[ref-string-indexOf]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/#-537588047%2FFunctions%2F-1430298843
[ref-string-lowercase]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/#-648004414%2FFunctions%2F-956074838
[ref-string-substringAfter]: https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/#1564391517%2FFunctions%2F-1430298843
[tutorial-search-text-in-string]: https://javarevisited.blogspot.com/2016/10/how-to-check-if-string-contains-another-substring-in-java-indexof-example.html
[tutorial-trim-white-space]: https://www.baeldung.com/kotlin/string-remove-whitespace
