package interfaces

interface LinkedList<T> : CustomDataStructure<T> {

    fun getFirst(): T?
    fun getLast(): T?
    fun addFirst(data: T)
    fun addLast(data: T)
    fun removeFirst()
    fun removeLast()
    fun clear()

}