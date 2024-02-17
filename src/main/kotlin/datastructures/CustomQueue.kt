package datastructures

import androidx.compose.runtime.mutableStateListOf
import interfaces.Queue

class CustomQueue<T> : Queue<T> {

    private val queue = mutableStateListOf<T>()

        override fun enqueue(element: T) = queue.add(element)


    override fun dequeue() = queue.removeFirstOrNull()
    override fun peek() = queue.getOrNull(0)
    override fun peek(index: Int) = queue.getOrNull(index)
    override fun isEmpty() = queue.size == 0
    override fun size() = queue.size

}

fun <T> customQueueOf(vararg elements: T): Queue<T> {
    val listQueue = CustomQueue<T>()
    elements.forEach {
        listQueue.enqueue( it)
    }
    return listQueue
}