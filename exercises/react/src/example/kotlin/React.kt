class Reactor<T>() {
    abstract inner class Cell {
        abstract val value: T
        internal val dependents = mutableListOf<ComputeCell>()
        internal fun eachDependent(f: (ComputeCell) -> Any) {
            for (dep in dependents) {
                f(dep)
            }
        }
    }

    interface Subscription {
        fun cancel()
    }

    inner class InputCell(initialValue: T) : Cell() {
        override var value: T = initialValue
            set(newValue) {
                field = newValue
                eachDependent { it.propagate() }
                eachDependent { it.fireCallbacks() }
            }
    }

    inner class ComputeCell private constructor(val newValue: () -> T) : Cell() {
        override var value: T = newValue()
            private set

        private var lastCallbackValue = value
        private var callbacksIssued = 0
        private val activeCallbacks = mutableMapOf<Int, (T) -> Any>()

        constructor(c: Cell, f: (T) -> T) : this({ f(c.value) }) {
            c.dependents.add(this)
        }
        constructor(c1: Cell, c2: Cell, f: (T, T) -> T) : this({ f(c1.value, c2.value) }) {
            c1.dependents.add(this)
            c2.dependents.add(this)
        }

        fun addCallback(f: (T) -> Any): Subscription {
            val id = callbacksIssued
            callbacksIssued++
            activeCallbacks[id] = f
            return object : Subscription {
                override fun cancel() {
                    activeCallbacks.remove(id)
                }
            }
        }

        internal fun propagate() {
            val nv = newValue()
            if (nv == value) {
                return
            }
            value = nv
            eachDependent { it.propagate() }
        }

        internal fun fireCallbacks() {
            if (value == lastCallbackValue) {
                return
            }
            lastCallbackValue = value
            for (cb in activeCallbacks.values) {
                cb(value)
            }
            eachDependent { it.fireCallbacks() }
        }
    }
}