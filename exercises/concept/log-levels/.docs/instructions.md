# Instructions

In this exercise you'll be processing log-liners.

Each log line is a string formatted as follows: "[<LEVEL>]: <MESSAGE>*".

## 1. Get the message from a log line

Implement the `LogLevels.message()` function to return the message from a log line, with the leading and trailing whitespaces removed.

## 2. Get the log level from a log line

Implement the `LogLevels.logLevel()` function to return the log level from a log line in lower case.

## 3. Reformat a log line

Implement the `LogLevels.reformat()` method that takes a log line and a location string and reformats into a message containing two lines.
The first line is formatted as `<LEVEL>@<LOCATIOON>:`, where:

* `<LEVEL>` is the log level in lower case (as from 2. Get the log level from a log line).
* `<LOCATION>` is the location given as the second parameter.

The second line contains exactly two spaces, followed by the log message (as from 1. Get the message from a log line):

```kotlin
reformat("[TRACE]: Start of function", 2, 8)
// => "trace@208:
  Start of function"
```