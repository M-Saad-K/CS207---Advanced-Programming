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
 * This class is for completion in Practical 3iii
 * The Node class is supplied for you
*/
public class NodeQueue<E> implements QueueADT<E>
{
    // references to the head and tail of 
    // the linked list
    protected Node<E> head, tail;   
    // number of elements in the queue
    protected int size;     

    /** constructs an empty queue
    */
    public NodeQueue() {    
       head = null;
       tail = null;
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
    
    public void enqueue(E elem) {
    // create and link in a new node at tail
        // Create a new node containing the element at position Null
        Node newNode = new Node(elem, null);
        // Check if the queue is empty
        if (head == null && tail == null) { // When errors began occurring, it was b/c after emptying the queue, the tail still held the previous node
            // That is why you need to empty the node in dequeue
            // If so, make the front element and rear element the new Node
            head = newNode;
            tail = newNode;
        } else {
            // If the queue is not empty

            tail.setNext(newNode); // This will set the next element after the current tail to the new Node
            tail = newNode; // This is make the newNode the current tail

        }
        size++; // Don't forget to increment size


        // DEBUGGING CODE
        if (head != null) {
            System.out.println("Head: "+ head.getElement());
        }
        if(tail != null) {
            System.out.println("Tail: "+ tail.getElement());
        }
        if (head == null && tail == null) {
            System.out.println("Empty Queue");}
    }

    /**
     @throws EmptyQueueException
    */
    public E front() {
        if (isEmpty()) {
            throw new EmptyQueueException("Empty Queue");
        }
        return head.getElement();
    }

    /**
     @throws EmptyQueueException
    */
    public E dequeue() {
        // This will remove the first element of the queue
        // B/c it is a linked based implementation, it can't be wrapped
        // It if empty, return exception
        if (isEmpty()) {
            throw new EmptyQueueException("Empty Queue");
        } else {
            // if not empty
            // Stored the item to be removed in a separate variable
            E nodeRemoved = head.getElement(); // The current element inside of head address
            head = head.getNext(); // Head will be moved to the next element in the queue
            size--; // Don't forget to decrement size, b/c this is not Array based implementation
            //System.out.println(size); TEST PURPOSES
            //System.out.println(head.getElement()); TEST PURPOSES

            // This func is the most important, it ensures that both head and tail aren't holding any elements if empty
            if (head == null) {
                tail = null; // Removing any old nodes from the tail if it is supposed to be empty.
            }

            // DE-BUGGING CODE
            if (head != null && tail != null) {
                System.out.println("Head: "+ head.getElement());
                System.out.println("Tail: "+ tail.getElement());
            } else {
                System.out.println("Empty Queue");
            }

            return nodeRemoved; // This method has a type, return that type
        }


    }
}
