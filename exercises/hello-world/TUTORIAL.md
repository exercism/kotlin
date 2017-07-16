NOTE: You can also view the HTML version of this file here:
https://github.com/exercism/kotlin/blob/master/exercises/hello-world/TUTORIAL.md

* [Solving "Hello, World!"](#solving-hello-world)
 * [Reading Gradle output](#reading-gradle-output)
 * [Fixing the first failing test](#fixing-the-first-failing-test)
 * [Enabling and fixing the second test](#enabling-and-fixing-the-second-test)
 * [Enabling and fixing the third test](#enabling-and-fixing-the-third-test)
 * [Enabling the last test](#enabling-the-last-test)
 * [Refactoring](#refactoring)
* [Submitting your first iteration](#submitting-your-first-iteration)
* [Next Steps](#next-steps)
 * [Review (and comment on) others' submissions to this exercise](#review-and-comment-on-others-submissions-to-this-exercise)
 * [Extend an exercise](#extend-an-exercise)
 * [Contribute to Exercism](#contribute-to-exercism)

----

# Solving "Hello, World!"

Welcome to the first exercise on the Kotlin track!

This is a step-by-step guide to solving this exercise.

Each exercise comes with a set of tests.  The first pass through the
exercise is about getting all of the tests to pass, one at a time.

If you have not installed the Java Development Kit and Gradle, you must do
so now.  For help with this, see: http://exercism.io/languages/kotlin/installing

----

This guide picks-up where [Running the Tests (in Kotlin)](http://exercism.io/languages/kotlin/tests)
left off.  If you haven't reviewed those instructions, do so now.

The following instructions work equally well on Windows, Mac OS X and Linux.

## Reading Gradle output

Use Gradle to run the tests:

```
$ gradle test
```

This command does a lot and displays a bunch of stuff.  Let's break it down...

```
:compileKotlin
w: /Users/jtigger/exercism/exercises/kotlin/hello-world/src/main/kotlin/HelloWorld.kt: (1, 11): Parameter 'name' is never used
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
```

Each line that begins with a colon (like `:compileKotlin`) is Gradle telling
us that it's starting that task.  The first five tasks are about compiling
the source code of our *solution*.  We've done you a favor and included just
enough code for the solution that it compiles.

When a task is successful, it generally does not output anything.  This is
why `:copyMainKotlinClasses` does not produce any additional output.

A task may succeed but warn of a potential problem.  This is what we see from
`:compileKotlin`.  The Kotlin compiler tells us that on line 1, 11 characters in
of the `HelloWorld.kt` file, there is a parameter called `name` that was
declared but never used.  Usually, warnings _are_ helpful and should be heeded.
We'll address this warning soon enough, but we're okay for now.

The next five tasks are about compiling source code of the *tests*.

```
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
```

... with both sets of source code successfully compiled, Gradle turns to
running the task you asked it to: executing the tests against the solution.

```
:test

HelloWorldTest > helloSampleName SKIPPED

HelloWorldTest > helloBlankName SKIPPED

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure: expected:<[Hello, World!]> but was:<[]>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at HelloWorldTest.helloNoName(HelloWorldTest.kt:10)

HelloWorldTest > helloAnotherSampleName SKIPPED

4 tests completed, 1 failed, 3 skipped
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/jtigger/exercism/exercises/kotlin/hello-world/build/reports/tests/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 7.473 secs
```

Seeing the word "fail" NINE TIMES might give you the impression you've done
something horribly wrong!  You haven't.  It's a whole lot of noise over
a single test not passing.

Let's focus in on the important bits:

```
HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure: expected:<[Hello, World!]> but was:<[]>
```

...is read: "Within the test class named `HelloWorldTest`, the test method
`helloNoName` did not pass because the solution did not satisfy an
assertion.  Apparently, we expected to see the string 'Hello, World!' but
a blank string was returned instead.

The last line of the stack trace tells us exactly where this unsatisfied
assertion lives:

```
        at HelloWorldTest.helloNoName(HelloWorldTest.kt:10)
```

Looks like the scene of the crime is on line 10 in the test file.

Knowing these two facts,

1. the return value was not what was expected, and
2. the failure was on line 10 of the test,

we can turn this failure into success.



## Fixing the first failing test

In your favorite text editor, open `src/test/kotlin/HelloWorldTest.kt`
and go to line 10.

```kotlin
assertEquals("Hello, World!", hello(""))
```

The test is expecting that `hello()`, when given an empty string (`""`),
returns "Hello, World!".  Instead, `hello()` is returning `""`.
Let's fix that.

Open `src/main/kotlin/HelloWorld.kt`.

```kotlin
fun hello(name: String = ""): String {
   return ""
}
```

Let's change that to return the expected string:

```kotlin
fun hello(name: String = ""): String {
   return "Hello, World!"
}
```

Save the file and run the tests again:

```
$ gradle test
:compileKotlin
w: /Users/jtigger/exercism/exercises/kotlin/hello-world/src/main/kotlin/HelloWorld.kt: (1, 11): Parameter 'name' is never used
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses UP-TO-DATE
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test

HelloWorldTest > helloSampleName SKIPPED

HelloWorldTest > helloBlankName SKIPPED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

BUILD SUCCESSFUL

Total time: 7.318 secs
```

"BUILD SUCCESSFUL"!  Woohoo! :)  You can see that `helloNoName()` test is
now passing.

We still see the warning about `name` not being used; we'll get to that
next.

With one win under our belt, we can turn our focus to some other messages
that we've been ignoring: the lines ending in "`SKIPPED`".

Each test suite contains a series of tests, all of which have been marked
to be skipped/ignored except the first one.  We did this to help you focus
on getting one test running at a time.

Let's tackle the next test...



## Enabling and fixing the second test

Right now, that second test is being skipped/ignored.  Let's enable it.

(Re)open `src/test/kotlin/HelloWorldTest.kt` and find the second test:

```kotlin
@Test
@Ignore
fun helloSampleName() {
    assertEquals("Hello, Alice!", hello("Alice"))
}
```

When the JUnit test runner sees that `@Ignore` annotation on the test
method, it knows to skip over that test.  Remove that line:

```kotlin
@Test
fun helloSampleName() {
    assertEquals("Hello, Alice!", hello("Alice"))
}
```

Now, when you run the tests, both tests run:

```
$ gradle test
:test

HelloWorldTest > helloSampleName FAILED
    org.junit.ComparisonFailure: expected:<Hello, [Alice]!> but was:<Hello, [World]!>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at HelloWorldTest.helloSampleName(HelloWorldTest.kt:15)

HelloWorldTest > helloBlankName SKIPPED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

4 tests completed, 1 failed, 2 skipped
```

The first test, `helloNoName()` continues to pass.  We see that
`helloSampleName` -- the test we just un-`@Ignore`'d -- is now running and
failing.  Yay, failing test!  In fact, the "failure" message is just
describing the difference between what the program does now and what it
should do for us to call it "done."

Right now, we've hardcoded the greeting.  Enabling this second test has
unleashed a new expectation: that our program incorporate a name given
into that greeting.  When given the name "`Alice`", that's who should be
greeted instead of "`World`".

(Re)open `src/main/kotlin/HelloWorld.kt`.

```kotlin
fun hello(name: String = ""): String {
   return "Hello, World!"
}
```

While `hello()` does accept a reference to a string named `name`, it is not
using it in the output.  Let's change that:


```kotlin
fun hello(name: String = ""): String {
   return "Hello, $name!"
}
```

_(Kotlin allows you to embed expressions within strings, a feature known as
string interpolation.  For more about this feature, see
https://kotlinlang.org/docs/reference/basic-types.html#string-templates )_

... and rerun the tests ...

```
$ gradle test
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName SKIPPED

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure: expected:<Hello, [World]!> but was:<Hello, []!>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at HelloWorldTest.helloNoName(HelloWorldTest.kt:10)

HelloWorldTest > helloAnotherSampleName SKIPPED

4 tests completed, 1 failed, 2 skipped
```

Wait... didn't we just fix the test?  Why is it failing?  Take a closer look...

In fact, `helloSampleName()` *is* passing.  It's just that at the same time,
we just inadvertently broke that first test: `helloNoName()`.

This is one tiny example of the benefit of maintaining a test suite: if we
use them to drive out our code, the second we break the program the tests
say so.  Since we saw them passing just *before* our latest change,
whatever we *just* did most likely cause that regression.

Our latest change was making the greeting dependent on the name given.  If
no name is given, our function defaults to an empty string.  The intent is
that when `hello()` is called on no one in particular, our function greets
the whole world.  Sound like a job for a default value!

`src/main/kotlin/HelloWorld.kt`:
```kotlin
fun hello(name: String = "World"): String {
   return "Hello, $name!"
}
```

... and re-run the tests ...

```
$ gradle test
:compileKotlin
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName SKIPPED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

BUILD SUCCESSFUL
```

Excellent!  Not only are both our tests passing, but that pesky warning
about not using `name` has faded into the distant past.  We're now
(at least) three-fourth the way done.  Just two more tests to go...



## Enabling and fixing the third test

(Re)open `src/test/kotlin/HelloWorldTest.kt` and find the penultimate test:

```kotlin
@Test
@Ignore
fun helloBlankName() {
    assertEquals("Hello, World!", hello("    "))
}
```

In this test, we're trying to be tricky.  It's one thing to omit a
parameter completely; it's a whole other situation when we provide a blank
string for a name.  This test is telling us that we'd like to treat these
cases the same way.

... and remove it's `@Ignore` to enable it ...

```kotlin
@Test
fun helloBlankName() {
    assertEquals("Hello, World!", hello("    "))
}
```

... and re-run the tests ...

```
$ gradle test
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName FAILED
    org.junit.ComparisonFailure: expected:<Hello, [World]!> but was:<Hello, [    ]!>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at org.junit.Assert.assertEquals(Assert.java:144)
        at HelloWorldTest.helloBlankName(HelloWorldTest.kt:20)

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

4 tests completed, 1 failed, 1 skipped
```

Since `"    "` is an actual value, Kotlin does _not_ substitute in the
default value.

(Re)open `src/main/kotlin/HelloWorld.kt`.

```kotlin
fun hello(name: String = "World"): String {
   return "Hello, $name!"
}
```

One way to handle this case is to check to see if `name` is blank.  Let's
do that:


```kotlin
fun hello(name: String = "World"): String {
   return "Hello, ${if (name.isBlank()) "World" else name}!"
}
```

As you can see, string templates can contain not just references to
variables, but entire expressions!  This is appropriate in a case like this
where we want to apply a simple condition to a value.

... and rerun the tests ...

```
$ gradle test
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName PASSED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName SKIPPED

BUILD SUCCESSFUL
```

We're almost there (perhaps closer than you think)!  Just _one_ more test
to pass before we have a solution we can have real confidence in.



## Enabling the last test

(Re)open `src/test/kotlin/HelloWorldTest.kt` and find the last test:

```kotlin
@Test
@Ignore
fun helloAnotherSampleName() {
    assertEquals("Hello, Bob!", hello("Bob"))
}
```

... and pop-off that `@Ignore` ...

```kotlin
@Test
fun helloAnotherSampleName() {
    assertEquals("Hello, Bob!", hello("Bob"))
}
```

... then rerun the tests ...

```
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName PASSED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName PASSED

BUILD SUCCESSFUL
```

Oh, hello!  Turns out, the solution we put into place didn't just apply for
"`Alice`" but for "`Bob`" equally well.  In this case, the test succeeded
with no additional code on our part.

Congratulations!



## Refactoring

Now that you've got all the tests passing, you might consider whether
the code is in the most readable/maintainable/efficient shape.  What makes
for "good" design of software is a big topic.  The pursuit of it underlies
much of what makes up the more valuable conversations on Exercism.

Kotlin is such a concise language and this exercise is so small, there is
not much room for us to make adjustments.  Most would leave this code, as
is.

That said, we've taken such pains to illustrate two core parts of the
Test-Driven Development approach (i.e. "red", "green"), we'd be remiss if
we skipped the all important final part: "refactor".

More on TDD at http://www.jamesshore.com/Blog/Red-Green-Refactor.html.

The core responsibility of `hello()` is to produce a personalized greeting.
_How_ we determine whether or not a name is given (i.e. `name` is
effectively an empty string) is a lower-level detail.

```kotlin
fun hello(name: String = "World"): String {
   return "Hello, ${if (name.isBlank()) "World" else name}!"
}
```

How would things read if we extracted that detail into a separate method?

```kotlin
fun hello(name: String = ""): String {
   return "Hello, ${whom(name)}!"
}

private fun whom(name: String):String {
   return if(name.isBlank()) "World" else name
}
```

By extracting that logic into the `whom()` method, we've added a little
abstraction to our program — it's not as literal as it was before.  Yet,
it allows us to defer _needing_ to understand _how_ the recipient of the
greeting is determined.

If we can assume that `whom()` just works, we don't have to
downshift in our head to those details.  Instead, we can remain at the same
level of thinking: what's the greeting?

_(Yes, this is considerable more lines of code; again, not a move we'd likely
make typically.  The takeaway is this: when you are "done" with an exercise
ask yourself, "can I adjust the shape of this code to better tell the
story of what's going on through its shape?")_

We made a bunch of changes, let's make sure we didn't break the program!

```
$ gradle test
:compileKotlin
:compileJava UP-TO-DATE
:copyMainKotlinClasses
:processResources UP-TO-DATE
:classes UP-TO-DATE
:compileTestKotlin
:compileTestJava UP-TO-DATE
:copyTestKotlinClasses UP-TO-DATE
:processTestResources UP-TO-DATE
:testClasses UP-TO-DATE
:test

HelloWorldTest > helloSampleName PASSED

HelloWorldTest > helloBlankName PASSED

HelloWorldTest > helloNoName PASSED

HelloWorldTest > helloAnotherSampleName PASSED

BUILD SUCCESSFUL
```

This illustrates another benefit of writing tests: you can make significant
changes to the structure of the program and very quickly restore your
confidence that the program still works.  These tests are a far cry from a
"proof" of correctness, but well-written tests do a much better job of
(very quickly) giving us evidence that it is.  Without them, we manually
run the program with different inputs and/or inspecting the code
line-by-line — time-consuming and error prone.



# Submitting your first iteration

With a working solution that we've reviewed, we're ready to submit it to
exercism.io.

```
$ exercism submit src/main/kotlin/HelloWorld.kt
```



# Next Steps

From here, there are a number of paths you can take.


## Move on to the next exercise

There are many more exercises you can practice with.  Grab the next one!

```
$ exercism fetch kotlin
```


## Review (and comment on) others' submissions to this exercise

The heart of Exercism is the conversations about coding
practices.  It's definitely fun to practice, but engaging with others
both in their attempts and your own is how you get feedback.  That feedback
can help point out what you're doing well and where you might need to
improve.

Some submissions will be nearly identical to yours; others will be
completely different.  Seeing both kinds can be instructive and interesting.

Note that you can only view submissions of others for exercises you have
completed yourself.  This enriches the experience of reading others' code
because you'll have your own experience of trying to solve the problem.

Here's an up-to-date list of submissions on the Kotlin track:

http://exercism.io/tracks/kotlin/exercises



## Submit another iteration

You are also encouraged to consider additional "requirements" on a given
exercise.

For example, you could add a test or two that requires that the greeting
use the capitalized form on the person's name, regardless of the case they
used.

In that situation, you'd:
 
1. add a new test setting up that new expectation,
2. implement that in the code (the same process we just went through
   together, above).
3. review your code for readability and refactor as you see fit.

Exercism practitioners who "play" with each exercise — over trying to go as
fast as they can through the stream of exercises — report deep rewards.


## Contribute to Exercism

The entire of Exercism is Open Source and is the labor of love for more
than 100 maintainers and many more contributors.

A starting point to jumping in can be found here:

https://github.com/exercism/docs/blob/master/contributing-to-language-tracks/README.md

----

Regardless of what you decide to do next, we sincerely hope you learn
and enjoy being part of this community.  If at any time you need assistance
do not hesitate to ask for help:

http://exercism.io/languages/kotlin/help

Cheers!
