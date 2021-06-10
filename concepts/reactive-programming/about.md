The reactive paradigm. Theres a bunch of words around the concept. Many big words that mean a lot of things. So let me break this down into the idea of state and the "reactive" program.

First we should get a basic understanding, you and I should be on the same page.
Think of traffic Lights at intersections.

We have a green light and a red light:

![Alt Text](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/8076mb86n30obkae5ok7.png)

The circles that are green are in a "green light" state which allows them to cross the divide of the two sides. The redlight circles and in a "redlight" state.
Since the circles do not want to wait at the light all day,
and there would be likely more circles to cause a back up,
they have to take turns.

When a reasonable amount of time passes: the two sides change.
Green lights changes to red
and
the red light needs to _react_ to the green light changing to red to allow all the circles to freely move across the divide.

![Alt Text](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/l0enhcinfdci1a2oevzx.png)

Then, again, after a reasonable amount of time the red turn green and the green to red.

What does that look like in code?

Since they are incorporated in the example, the following has these facts:
1. This is a Kotlin enumeration class.
2. In this context they serve as a tool to illustrate the idea of state in a reactive process.

```kotlin
import kotlin.properties.Delegates //delegate import

    //Class declarations enum class  Type<*>(Any<*>):Any<*>   
   enum class StopGo {
        //Establish the enumerated value
        REDLIGHT {
           //establish abstract overdrive
            override fun go() {
               //show the light type
               println("red light")
            }
        },
        GREENLIGHT {
            override fun go() {
                println("green light")
            }
        };
        //Empty container to be used
        abstract fun go()
    }//End of enum

```
Note: I am using an abstract function here and if you aren't
familiar, think of it as a function only GREENLIGHT and
REDLIGHT have. So, in keeping the ideas of abstraction,
separation of concerns you cannot initiate an enum and access
it without assigning it to an enumerated value.

```kotlin

    //main function 
    fun main() {
        //light is what is going to react to stop light
        var light = StopGo.GREENLIGHT
        var stopLight: StopGo by 
        Delegates.observable(StopGo.GREENLIGHT){
            property,oldValue,newValue ->
light = if(light == StopGo.GREENLIGHT) StopGo.REDLIGHT else 
StopGo.GREENLIGHT
        }
  /*

stopLight is a delegate

for now I want you to think of a delegate as a function within  
a variable much like how in javascript you can do:

var a = () => { //do work } 

so..

a() <- "does work"

you can think of Lambdas as that as well,
given they can also operate as code blocks. We basically say 
"If A Changes, so does B."
But if B changes, a does not, and that is an important 
distinction. A linear progression of reaction would look more 
like this if plotted:
A  ->  B  ->  A -> <--- declarative 
B  ΔA  A  ΔB  B Δ  <--- reactive
*/


light.go()  /* light = REDLIGHT   */

stopLight = StopGo.REDLIGHT /*GREENLIGHT-(Δ switch)->REDLIGHT*/             

light.go()  /* light = GREENLIGHT */

stopLight = StopGo.REDLIGHT /*REDLIGHT-(Δ switch)->GREENLIGHT*/

light.go()  /* light = REDLIGHT   */

    }
```

So, *light* was _reacting_ to *stopLight* changing.

That is just one basic idea and conceptualization surround the reactive paradigm.