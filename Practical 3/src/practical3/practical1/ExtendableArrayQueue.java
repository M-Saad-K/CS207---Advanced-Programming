package practical3.practical1;

import practical3.EmptyQueueException;


/**
 * This class is for completion in Practical 3ii
*/
public class ExtendableArrayQueue<E>  {
   protected E[] Q; // Q will refer to the array
   protected int f; // front - array index of element at front of queue
   protected int r; // rear - array index of where next element added will be placed 
   protected int N;  // array capacity

   /**
    * Constructor for objects of class ExtendableArrayQueue.
    * In practical 3ii no change need be made to this constructor.
    * With this constructor a queue can initially hold up to
    * 3 (i.e.N-1) items when using the approach described in lectures.
    */
   public ExtendableArrayQueue() {
      N = 4;
      Q = (E[]) new Object[N];
      f = 0;
      r = 0;
   }

   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i

   public int size() {
      // Total capacity is N - 1
      // The addition of N is to prevent -3 if the circular queue is wrapping around
      return (r - f + (N)) % N;
   }

   public void enqueue(E element) {
      // First check if array is full, meaning if size is equal to available memory capacity
      if (size() == N-1) {
         throw new practical3.FullQueueException("This Queue is full, can't enqueue element"); // Tell that it is full
      } else { // Else if it is full
         Q[r] = element; // Add the element to the rear's current address position
         r = (r+1) % N; // Increment the rear to the next available memory space
         // Front will stay the same
      }
   }

   /**
    * @throws EmptyQueueException
    */
   public E dequeue() {
      // First check if array isn't empty, meaning if front and rear are both equal to 0
      if (isEmpty()) {
         throw new practical3.EmptyQueueException("This Queue is empty, can't dequeue element"); // Tell that it is empty
      } else { // If not empty
         // We will be removing and returning element from the front
         E UnwantedElement = Q[f]; // Make it type E
         f = (f+1) % N; // Increment the front position to the next queue element
         return UnwantedElement; // The removed element is still in a memory address, however that memory address is no longer in the array
         /// We won't decrement size b/c size is not an existing variable in an Array-based implementation
      }

   }

   /**
    * @throws EmptyQueueException
    */
   public E front() {
      if (r == f)
         throw new EmptyQueueException("The queue is empty");
      else
         return Q[f];
   }

   public boolean isEmpty() {
      return f == r;
   }

   public void extendCapacity() {

   }
}

