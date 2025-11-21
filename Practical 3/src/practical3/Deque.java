/**
 * @ Author: Muhammad Saad Khan
 * @ Date: 2025 - 10 - 20
 * @ Title: Practical 3
 * @ Module: CS207
 *
 * @ Version: Java 25
 * **/

package practical3;

/**
 * This class is for completion in Practical 3iv
 * The DoubleNode class is supplied for you
 */
public class Deque <E> implements DequeADT<E>
{
    // references to the head and tail of
    // the linked list
    protected DoubleNode<E> front, rear;
    // number of elements in the queue
    protected int size;

    /** constructs an empty queue
     */
    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Complete the method bodies below. Take care
    // that exceptions of the correct types are thrown by
    // your methods as specified in the method comments.

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an element at the front of the deque
    public void insertFront(E data) {
        // First we will make a new node, for data, with the next position be front and previous being null
        DoubleNode<E> newDNode = new DoubleNode<E>(data, front, null);
        // Check if the queue is empty
        if (front == null) {
            // Make the newNode in front position and rear position, b/c only one elem
            front = newDNode;
            rear = newDNode;
        } else {
            // If it is not empty
            // The new node will be placed in the front node area spot
            // And the rest of the elements will be pushed up 1
            // To prevent us incrementing all the elements of the queue, we will use setPrevious
            // For the previous element before front, and make that the front
            front.setPrevious(newDNode); // New node set to previous
            front = newDNode; // Make that the front
        }
        size++; // Don't forget to increment the size

        // DEBUGGING CODE
        if (front != null) {
            System.out.println("Front: " + front.getElement());
        }
        if (rear != null) {
            System.out.println("Rear: "+rear.getElement());
        }
        if(front == null && rear == null) {
            System.out.println("Empty Deque");
        }
        System.out.println("Size is: " + size);
    }

    // Insert an element at the rear of the deque
    public void insertRear(E data) {
        // First we will create a new node
        // The new node will be have its next position be null and previous position be rear
        DoubleNode newDNode = new DoubleNode(data, null, rear);
        // Check if it is not empty
        if (rear == null) {
            // Only one element, make both new elem
            rear = newDNode;
            front = newDNode;
        } else {
            // If not empty
            rear.setNext(newDNode); // Make the next thing, after rear, the double node
            rear = newDNode; // Set that new node to be the rear
        }
        size++; // Don't forget to increment the size

        // DEBUGGING CODE
        if (front != null) {
            System.out.println("Front: " + front.getElement());
        }
        if (rear != null) {
            System.out.println("Rear: "+rear.getElement());
        }
        if(front == null && rear == null) {
            System.out.println("Empty Deque");
        }
        System.out.println("Size is: " + size);
    }

    // Remove an element from the front of the deque
    public E deleteFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        E data = front.getElement();
        if (front == rear) { // Only one element
            front = rear = null;
        } else {
            front = front.getNext();
            front.setPrevious(null);
        }
        size --;

        // DEBUGGING CODE
        if (front != null) {
            System.out.println("Front: " + front.getElement());
        }
        if (rear != null) {
            System.out.println("Rear: "+rear.getElement());
        }
        if(front == null && rear == null) {
            System.out.println("Empty Deque");
        }
        System.out.println("Size is: " + size);
        return data;
    }

    // Remove an element from the rear of the deque
    public E deleteRear() {
        // We're deleting now
        // First check if it is empty
        if (isEmpty()) {
            throw new EmptyQueueException("Deque is empty");
        } else {
            // We need to store the current rear element
            E Removeddata = rear.getElement();
            // If not empty, check there is at least one element
            if (size == 1) {
                front = rear = null; // Make r and f both null
            } else {
                // Move the rear down to the previous position
                rear = rear.getPrevious();
                // And make the next element address, OG the rear, a null
                rear.setNext(null);
            }
            size--; // Don't forget to decrement the size

            // DEBUGGING CODE
            if (front != null) {
                System.out.println("Front: " + front.getElement());
            }
            if (rear != null) {
                System.out.println("Rear: "+rear.getElement());
            }
            if(front == null && rear == null) {
                System.out.println("Empty Deque");
            }
            System.out.println("Size is: " + size);

            return Removeddata; // Return method type
        }
    }

    // Get the front element without removing it
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return front.getElement();
    }

    // Get the rear element without removing it
    public E getRear() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
        return rear.getElement();
    }

    // Display the elements in the deque
    public void display() {
        DoubleNode<E> current = front;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
