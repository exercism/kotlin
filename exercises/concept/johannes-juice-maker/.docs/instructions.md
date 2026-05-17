Your friend Johannes loves doing DIY (do it yourself) hardware.
They just built a juice-maker, Johannes is very excited about it.
Johannes's goal is to be able to make fresh juice every morning.

Johannes Juice maker can be configured with different capacities.
Johannes isn't the best at programming, but they want to make a program to control the machine.
They have thereby asked you to help them.

## 1. Create the `JuiceMaker` class
Create the `JuiceMaker` class.
The class two properties that will also be provided to it:
- the `capacity` in milliliters (as an `Int`)
- a `jug` (as an `Jug` object) representing the jug that will be filled with the juice from the maker

## 2. Extend the jug when capacity is more than 1,000 milliliters
When the capacity is greater than 1,000 milliliters, the jug needs to be extended to ensure it can hold juice.
Update the `JuiceMaker` class to extend the jug (by calling its `extend` function) when it is created with a capacity greater than 1,000 milliliters.

## 3. Install the starter
Some models have a very complicated start up procedure that would take many years to perform.
Fortunately, special starters have been created to speed this up.

Add support for models with complicated start up procedures by adding another constructor that also takes a `Starter` object.
The constructor should also call its `install` function to install itself in the juice maker.

## 4. Add a `start` function
Add a `start` function that takes a speed.
The juice maker will keep running at the speed.

## 5. Add a `stop` function
Add a `stop` function to stop the juice maker.

## 6. Add a `lightColor` function
The machine has a light to indicate what speed it is running at.
The light color depends on what speed it is running at:

| Speed                   | Color  |
|-------------------------|--------|
| Off                     | red    |
| less than or equal to 3 | green  |
| above 3                 | yellow |

Add a `lightColor` function that returns the color.

# 7. Build with a common capacity
After building many juice makers, Johanne notices that a common capacity is 1,500 milliliters.
To streamline this configuration, implement the helper function `buildWithCommonCapacity`.
The function should be defined outside of the `JuiceMaker` class.
