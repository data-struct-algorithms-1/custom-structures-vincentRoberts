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
        if (!isEmpty()) {
            if (size == 1) {
                head = null
            } else {
                head = head?.next
            }
            size--
        }
    }

    override fun removeLast() {
        if (isEmpty()) return

        if (size == 1) {
            head = null
        } else {
            var current = head
            var previous: Node<T>? = null
            while (current?.next != null) {
                previous = current
                current = current.next
            }
            previous?.next = null
        }
        size--
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

    override fun toString(): String {
        var string = ""
        var current = head
        while (current != null) {
            string += "${current.data} -> "
            current = current.next
        }
        return string
    }

}