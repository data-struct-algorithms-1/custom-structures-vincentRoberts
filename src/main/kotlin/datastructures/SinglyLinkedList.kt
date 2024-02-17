package datastructures

import interfaces.LinkedList

class SinglyLinkedList<T> : LinkedList<T>{

    private var head: Node<T>? = null
    private var size: Int = 0

    inner class Node<T>(val data: T, var next: Node<T>? = null)
    override fun getFirst() = head?.data

    override fun getLast(): T? {
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        return current?.data
    }

    override fun removeFirst() {
        TODO("Not yet implemented")
    }

    override fun removeLast() {
        TODO("Not yet implemented")
    }

    override fun clear() {
        head = null
        size = 0
    }


    override fun addLast(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
        size++
    }

    override fun addFirst(data: T) {
        val newNode = Node(data)
        if (isEmpty()) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        size++
    }

    override fun isEmpty() = (size == 0)


    override fun size() = size

}