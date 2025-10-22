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

    }

    // Insert an element at the rear of the deque
    public void insertRear(E data) {

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
        return data;
    }

    // Remove an element from the rear of the deque
    public E deleteRear() {
   
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
