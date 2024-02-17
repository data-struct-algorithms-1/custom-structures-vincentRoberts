import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import datastructures.CustomQueue
import datastructures.customQueueOf

class CustomQueueTest {

    @Test
    fun `enqueue should add elements to the queue`() {
        // Arrange
        val queue = customQueueOf<String>()
        val element = "Test"

        // Act
        queue.enqueue(element)

        // Assert
        assertEquals(1, queue.size())
    }

    @Test
    fun `enqueue set up by constructor should add elements to the queue`() {
        // Arrange
        val queue = CustomQueue<String>()
        val element = "Test"

        // Act
        queue.enqueue(element)

        // Assert
        assertEquals(1, queue.size())
    }

    @Test
    fun `given a queue instantiated with items, when enqueue is called, then it adds the element at the end`() {
        // Arrange
        val queue = customQueueOf(1, 2, 3, 4, 5)
        val element = 42

        // Act
        val result = queue.enqueue(element)

        // Assert
        assertTrue(result)
        assertEquals(1, queue.peek(0))
        assertEquals(2, queue.peek(1))
        assertEquals(3, queue.peek(2))
        assertEquals(4, queue.peek(3))
        assertEquals(5, queue.peek(4))
        assertEquals(element, queue.peek(5))
    }

    @Test
    fun `dequeue should remove and return the first element from the queue`() {
        // Arrange
        val queue = customQueueOf<String>()
        val element1 = "Element 1"
        val element2 = "Element 2"
        queue.enqueue(element1)
        queue.enqueue(element2)

        // Act
        val dequeuedElement = queue.dequeue()

        // Assert
        assertEquals(element1, dequeuedElement)
        assertEquals(1, queue.size())
    }

    @Test
    fun `dequeue on an empty queue should return null`() {
        // Act
        val queue = customQueueOf<String>()
        val dequeuedElement = queue.dequeue()

        // Assert
        assertNull(dequeuedElement)
    }

    @Test
    fun `peek should return the first element from the queue without removing it`() {
        // Arrange
        val queue = customQueueOf<String>()
        val element = "Test"
        queue.enqueue(element)

        // Act
        val peekedElement = queue.peek()

        // Assert
        assertEquals(element, peekedElement)
        assertEquals(1, queue.size())
    }

    @Test
    fun `peek on an empty queue should return null`() {
        // Act
        val queue = customQueueOf<String>()
        val peekedElement = queue.peek()

        // Assert
        assertNull(peekedElement)
    }

    @Test
    fun `isEmpty should return true if the queue is empty`() {
        // Act
        val queue = customQueueOf<String>()
        val empty = queue.isEmpty()

        // Assert
        assertTrue(empty)
    }

    @Test
    fun `size should return the number of elements in the queue`() {
        // Arrange
        val queue = customQueueOf<String>()
        queue.enqueue("Element 1")
        queue.enqueue("Element 2")
        queue.enqueue("Element 3")

        // Act
        val size = queue.size()

        // Assert
        assertEquals(3, size)
    }
}