data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    val table = Array(items.size + 1) { IntArray(maximumWeight + 1) { 0 }}
    items.forEachIndexed { index, item -> 
        for (c in 1..maximumWeight) {
            if (item.weight > c) {
                table[index+1][c] = table[index][c]
            } else {
                table[index+1][c] = Math.max(
                    table[index][c],
                    item.value + table[index][c-item.weight]
                )
            }
        }
    }
    return table[items.size][maximumWeight]
}