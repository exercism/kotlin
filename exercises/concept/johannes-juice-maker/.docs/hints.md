# Hints

## 1. Create the `JuiceMaker` class
- The constructor needs to take an `Int` and a `Jug` parameter
- The class also needs to have a `capacity` and `jug` property

## 2. Extend the jug when capacity is more than 1,000 milliliters
- `init` blocks can be used to perform any necessary initialization when creating an object

## 3. Install the starter
- Secondary constructors still need to call the primary constructor

## 4. Add a `start` function
- The class needs to "remember" the speed

## 5. Add a `stop` function
- When called, the class needs to "remember" it has been stopped (at least until it has been started again)

## 6. Add a `lightColor` function
- This function will need to check what speed the juice maker was started with
- Function will also need to know if the juice maker was stopped

## 7. Build with a common capacity
- The `buildWithCommonCapacity` function should be defined _outside_ the `JuiceMaker` class
