package datastructures

import interfaces.Stack

class LIFOStack<T> : Stack<T> {

    private val stack = arrayListOf<T>()

    override fun push(element: T) {
        stack.add(element)
    }

    override fun pushAll(items : Iterable<T>) {
        for (item in items) {
            push(item)
        }
    }

    override fun pop(): T? {
        if (isEmpty()) {
            return null
        }
        return stack.removeAt(size() - 1)
    }

    override fun popAll() : List<T> {
        val tempStack = arrayListOf<T>()
        for (item in stack) {
            pop()?.let { tempStack.add(it) }
        }
        return tempStack
    }

    override fun peek(): T? = stack.lastOrNull()

    override fun peek(index: Int): T? = stack.getOrNull(index)

    override fun size() = stack.size

    override fun isEmpty() = size() == 0

    override fun toString() = buildString {
        stack.forEach {  appendLine("$it") }
    }
}

fun <T> lifoStackOf(vararg elements: T): Stack<T> {
    val listStack = LIFOStack<T>()
    listStack.pushAll(elements.asList())
    return listStack
}