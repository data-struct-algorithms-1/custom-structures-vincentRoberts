package datastructures

import interfaces.Stack
import java.util.concurrent.CopyOnWriteArrayList

class FIFOStack<T> : Stack<T> {

    private val stack = CopyOnWriteArrayList<T>()

    override fun push(element: T) {
        stack.add(element)
    }

    override fun pushAll(items: Iterable<T>) = items.forEach{ push(it)}

    override fun pop(): T? = if (isEmpty()) null else stack.removeAt(0)

    override fun popAll(): List<T> {
        // synchronized(stack) {
        val tempStack = arrayListOf<T>()
        for (item in stack) {
            pop()?.let { tempStack.add(it) }
        }
        return tempStack
        //}
    }

    override fun peek(): T? = stack.firstOrNull()

    override fun peek(index: Int): T? = stack.getOrNull(index)

    override fun size() = stack.size

    override fun isEmpty() = stack.isEmpty()

    override fun toString(): String = stack.joinToString(separator = "\n")
}

fun <T> fifoStackOf(vararg elements: T): Stack<T> {
    val listStack = FIFOStack<T>()
    listStack.pushAll(elements.asList())
    return listStack
}