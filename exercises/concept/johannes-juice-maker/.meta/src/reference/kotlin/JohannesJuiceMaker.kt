class JuiceMaker constructor(val capacity : Int, val jug : Jug) {
    private var speed : Int = 0

    init  {
        if (capacity > 1000) {
            jug.extend()
        }
    }

    constructor(capacity: Int, jug : Jug, starter: Starter) : this(capacity, jug) {
        starter.install()
    }

    fun lightColor() : String {
        if (speed == 0) {
            return "red"
        } else if (speed <= 3) {
            return "green"
        }
        return "yellow"
    }

    fun start(newSpeed : Int) {
        speed = newSpeed
    }

    fun stop() {
        speed = 0
    }
}

fun buildWithCommonCapacity() : JuiceMaker {
    return JuiceMaker(1500, Jug())
}
