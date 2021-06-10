import kotlinx.coroutines.runBlocking
import kotlin.properties.Delegates
import kotlin.random.Random

enum class Drift {//Coordinate enumeration
    TWO_DIMENSION_GRID {
        override fun coordinateBuilder(x: Int, y: Int) : Coordinate {//coordinate is built
            return Coordinate(x,y)
        }
    },
    THREE_DIMENSION_GRID {
        override fun coordinateBuilder(x: Int, y: Int) : Coordinate {//Plans to implement three dimensional grid.
            return TODO()
        }
    };

    abstract fun coordinateBuilder(x:Int, y:Int): Coordinate //the abstract override.
    }

    class Coordinate(x:Int = 0, y:Int = 0){//coordinate class
        val x = x
        val y = y

        fun printCoordinate(){
            println("x: ${x}, y: ${y} ")
        }
    }

 fun main() = runBlocking {
     var coordinate = Drift.TWO_DIMENSION_GRID //set up enumeration
     val dataSequence = List(10) { Random.nextInt(-500, 500) } //generate random list of ints
     var dataGrid = arrayListOf<Coordinate>()//instantiate an empty grid
     var  coordinateValid = false //initialize switch to false

     var driftSwitch by Delegates.observable(0) { property, oldValue, newValue ->
         if(!coordinateValid){
             coordinateValid = true //we take in the first value, on two-dim grids is a valid coordinate
         }else{
             dataGrid.add(coordinate.coordinateBuilder(oldValue, newValue))//use old value as x, new as y
             coordinateValid = false //set switch back to tak in new coordinate
         }
     }

     dataSequence.forEach {//build the data grid
         driftSwitch = it
     }

     dataGrid.forEach{//print the data grid coordinates
         it.printCoordinate()
     }

 }

