# Tests

## Running the Tests

1. Get an exercise:

    ```bash
    $ exercism download -track=kotlin --exercise=hello-world -
    ```

2. Change directory into the exercise:

    ```bash
    $ cd <path_to_exercise_directory>
    ```

3. Run the tests:

    ```bash
    $ ./gradlew test
    ```

On most exercises, only the first test is run by default.
The other tests are annotated with `@Ignore` to skip them.

This is common practice in test-driven development (or TDD for short).
It is used to ensure that you are working on one problem at a time.

---
Good luck! Have fun!

If you get stuck at any point, don't forget to reach out for [help](https://exercism.org/docs/using/contact).
