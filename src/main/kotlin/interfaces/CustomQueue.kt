package interfaces

interface Queue<T> : CustomDataStructure<T> {

    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    fun peek(): T?
    fun peek(index: Int): T?

}