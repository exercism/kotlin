class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    var root: Node<T>? = null

    fun insert(value: T) {
        if (root == null) {
            root = Node(value)
        } else {
            insert(value, root!!)
        }
    }

    private fun insert(value: T, parent: Node<T>) {
        if (value > parent.data) {
            if (parent.right == null) {
                parent.right = Node(value)
            } else {
                insert(value, parent.right!!)
            }
        } else {
            // Equal elements are inserted on the left side, too!
            if (parent.left == null) {
                parent.left = Node(value)
            } else {
                insert(value, parent.left!!)
            }
        }
    }

    fun asSortedList(): List<T> {
        return asSortedList(root).map { it.data }
    }

    private fun asSortedList(start: Node<T>?): List<Node<T>> =
            if (start == null) {
                emptyList()
            } else {
                asSortedList(start.left) + listOf(start) + asSortedList(start.right)
            }

    fun asLevelOrderList(): List<T> =
            if (root == null) {
                emptyList()
            } else {
                asLevelOrderList(listOf(), listOf(root!!)).first.map { it.data }
            }


    private fun asLevelOrderList(done: List<Node<T>>, todo: List<Node<T>>): Pair<List<Node<T>>, List<Node<T>>> {
        if (todo.isEmpty()) {
            return Pair(done, emptyList())
        }
        return asLevelOrderList(
                done + todo,
                todo.flatMap { listOfNotNull(it.left, it.right) })
    }
}
