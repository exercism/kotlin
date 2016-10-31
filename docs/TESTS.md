## Windows

1) In the Command Prompt window, get the first exercise...

```
C:\Users\johndoe> exercism fetch kotlin

New:
Kotlin (Etl)      C:\Users\johndoe\exercism\kotlin\etl

unchanged: 0, updated: 0, new: 1
```

2) In the "Welcome to IntelliJ IDEA" window, click the "Open" option.

3) Navigate to the "C:\Users\johndoe\exercism\kotlin\etl" folder.  Make sure you've selected the "etl" folder. Click "OK".

4) In the "Import Project from Gradle" dialog, check the "auto-import" and "create directories" checkboxes and select "Use customizable gradle wrapper".

```
Gradle project:    [C:\Users\johndoe\exercism\kotlin\etl\build.gradle   ](...)

[X] Use auto-import
[X] Create directories for empty content roots automatically

( ) Use default gradle wrapper (not configured for the current project)
(o) Use customizable gradle wrapper
( ) Use local gradle distribution

...
```

5) Click "OK".  IntelliJ will automatically create its project artifacts based on the Gradle project file.

* After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can safely dismiss this notice.

6) Open the `README.md` file and carefully read the background for the assignment.

7) Start by running the test suite: In the "Project" view, right-click on the test file (`etl\src\test\kotlin\EtlTest`), select "Run", then pick the "EtlTest" that has a JUnit icon to the left of it (red and green arrows), NOT the Gradle icon (circular green).

* When you first start an exercise, you should expect compilation errors because the test is setting expectations on a class that you need to write.  By trying to run the tests, you get a nice list of what needs to be fixed in the "Messages Make" view.

... and away you go!!!

## Mac OS X

### Get started with the first exercise

In the terminal window, get the first exercise:

    $ exercism fetch kotlin

    Not Submitted:       1 problem
    Kotlin (Etl) /Users/johndoe/exercism/kotlin/etl

    New:                 1 problem
    Kotlin (Etl) /Users/johndoe/exercism/kotlin/etl

    unchanged: 0, updated: 0, new: 1

### Running the Tests

#### Option 1: IntelliJ

1. In the "Welcome to IntelliJ IDEA" window, click the "Open" option.

2. Navigate to the `/Users/johndoe/exercism/kotlin/etl` folder.  Make sure you've selected the
   "etl" folder. Click "OK".

3. In the "Import Project from Gradle" dialog, check the "auto-import" and "create directories"
   checkboxes and select "Use customizable gradle wrapper".

    ![IntelliJ 14 CE -- Gradle import dialog](http://x.exercism.io/v3/tracks/kotlin/docs/img/mac-osx--idea-ce-gradle-import-dialog.png)

4. Click "OK".  IntelliJ will automatically create its project artifacts based on the Gradle project file.

 * After the project has loaded and you've dismissed the "Tip of the Day" dialog, you may see a
   notice (in the top-right-hand corner), saying, "Unindex remote maven repositories found." you can
   safely dismiss this notice.

5. Open the `README.md` file and carefully read the background for the assignment.

6. Start by running the test suite: In the "Project" view, right-click on the test file
   (`etl\src\test\kotlin\EtlTest`), select "Run", then pick the "EtlTest" that has a JUnit icon to the
   left of it (red and green arrows), NOT the Gradle icon (circular green).
   ![Run tests through IDEA JUnit Runner, NOT Gradle](http://x.exercism.io/v3/tracks/kotlin/docs/img/mac-osx--idea-ce-run-unit-tests.png)

 * If these menu options don't appear at first, wait for a few seconds and try again; IntelliJ is still
   configuring the project with a Kotlin nature.

 * When you first start an exercise, you should expect compilation errors because the test is
   setting expectations on a class that you need to write.  By trying to run the tests, you get a
   nice list of what needs to be fixed in the "Messages Make" view.

... and away you go!!!

#### Option 2: Command Line

The Exercism exercises for Kotlin can be built and tested from the command line using [Gradle](https://gradle.org).

After [installing Gradle](https://www.jayway.com/2013/05/12/getting-started-with-gradle), you can run the tests for any exercise by running `gradle test`, as long as you're in the same directory as the `build.gradle` file:

```
$ pwd
/Users/johndoe/Code/exercism/kotlin/hello-world

$ gradle test
...

:test

HelloWorldTest > helloSampleName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.kt:25

HelloWorldTest > helloNullName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.kt:20

HelloWorldTest > helloBlankName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.kt:13

HelloWorldTest > helloNoName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.kt:8

HelloWorldTest > helloAnotherSampleName FAILED
    org.junit.ComparisonFailure at HelloWorldTest.kt:30

5 tests completed, 5 failed
:test FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':test'.
> There were failing tests. See the report at: file:///Users/johndoe/Code/exercism/kotlin/hello-world/build/reports/tests/test/index.html

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.

BUILD FAILED

Total time: 1.141 secs
```

When test cases are failing, you can get more information about the failing tests by including the `test` task's `--info` option:

```
$ gradle test --info
...

:test

...

HelloWorldTest > helloSampleName FAILED
    org.junit.ComparisonFailure: expected:<Hell[o], Alice!> but was:<Hell[ooo], Alice!>
        at org.junit.Assert.assertEquals(Assert.java:115)
        at kotlin.test.junit.JUnitAsserter.assertEquals(JUnitSupport.kt:23)
        at kotlin.test.AssertionsKt__TestAssertionsKt.assertEquals(TestAssertions.kt:29)
        at kotlin.test.AssertionsKt.assertEquals(Unknown Source)
        at kotlin.test.AssertionsKt__TestAssertionsKt.assertEquals$default(TestAssertions.kt:28)
        at kotlin.test.AssertionsKt.assertEquals$default(Unknown Source)
        at HelloWorldTest.helloSampleName(HelloWorldTest.kt:25)

...

5 tests completed, 5 failed

...

BUILD FAILED

Total time: 1.162 secs

...
```
