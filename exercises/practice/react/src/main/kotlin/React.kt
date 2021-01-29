class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }
}
