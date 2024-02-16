package interfaces

interface Stack<T> : CustomDataStructure<T> {

    fun push(element: T)
    fun pushAll(items: Iterable<T>)
    fun pop(): T?
    fun popAll(): List<T>
    fun peek(): T?
    fun peek(index: Int): T?

}