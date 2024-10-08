# Tests

## Running the Tests

1. Get an exercise:

    ```bash
    $ exercism download -track=kotlin --exercise=hello-world
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
As you solve each test, remove the `@Ignore` from the next one to progress.

This is common practice in test-driven development (or TDD for short).
It is used to ensure that you are working on one problem at a time.

---
Good luck! Have fun!

If you get stuck at any point, feel free to reach out for help on the [forum](https://exercism.org/r/forum) or our `#get-help` channel on our [Discord server](https://exercism.org/r/discord).