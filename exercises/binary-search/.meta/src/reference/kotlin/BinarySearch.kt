object BinarySearch {

    fun <T: Comparable<T>> search(list: List<T>, item: T) : Int {
        require(list.isSorted()) {"The provided list must be sorted in ascending order"}

        if(list.isEmpty()) {
            throw NoSuchElementException("value $item is not in array $list")
        }

        return searchRec(list, item, 0)
    }

    private tailrec fun <T: Comparable<T>> searchRec(list: List<T>, item: T, accumulatedOffset: Int) : Int {
        if(1 == list.size) {
            return if(list.first() == item) accumulatedOffset else throw NoSuchElementException("value $item is not in array $list")
        }

        val midIndex = list.size / 2
        val midValue = list[midIndex]

        if(item < midValue) {
            return searchRec(list.subList(0, midIndex), item, accumulatedOffset)
        }

        return searchRec(list.subList(midIndex, list.size), item, midIndex + accumulatedOffset)
    }

    /**
     * The following extension methods are more general, in a project they would probably not be private
     */


    /**
     * Uses a sequence of Pair objects in order to avoid calculating all the pairs beforehand in cases
     * where the list is not sorted
     */
    private fun <T: Comparable<T>> List<T>.isSorted(): Boolean {
        if(this.isEmpty()) {
            return true
        }

        return this.pairsSequence().all { it.first <= it.second }
    }

    /**
     * Returns a sequence of Pair objects containing all each object of the list plus it's following object
     */
    private fun <T> List<T>.pairsSequence() : Sequence<Pair<T, T>> {
        if(this.size < 2) {
            return emptySequence()
        }

        val list = this
        return object : Sequence<Pair<T, T>> {
            override fun iterator(): Iterator<Pair<T, T>> {
                return object: AbstractIterator<Pair<T, T>>() {

                    var index = 0

                    override fun computeNext() {
                        if(index >= (list.size-1)) {
                            done()
                        }
                        else {
                            setNext(Pair(list[index], list[index+1]))
                            index += 1
                        }
                    }
                }
            }
        }
    }

}


