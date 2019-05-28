# Anagram

Given a word and a list of possible anagrams, select the correct sublist.

Given `"listen"` and a list of candidates like `"enlists" "google"
"inlets" "banana"` the program should return a list containing
`"inlets"`.

## Setup

Go through the setup instructions for Kotlin to install the necessary
dependencies:

[https://exercism.io/tracks/kotlin/installation](https://exercism.io/tracks/kotlin/installation)

## Making the test suite pass

Execute the tests with:

```bash
$ gradlew test
```

> Use `gradlew.bat` if you're on Windows

In the test suites all tests but the first have been skipped.

Once you get a test passing, you can enable the next one by removing the
`@Ignore` annotation.

## Source

Inspired by the Extreme Startup game [https://github.com/rchatley/extreme_startup](https://github.com/rchatley/extreme_startup)

## Submitting Incomplete Solutions

It's possible to submit an incomplete solution so you can see how others have
completed the exercise.
