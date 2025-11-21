/**
 * @ Author: Muhammad Saad Khan
 * @ Date: 2025 - 10 - 20
 * @ Title: Practical 3
 * @ Module: CS207
 *
 * @ Version: Java 25
 * **/

package practical3;


import java.util.Arrays;

/**
 * This class is for completion in Practical 3ii
*/
public class ExtendableArrayQueue<E> implements QueueADT<E> {
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

   // GLOBAL variable for monitoring size of expended capacity
   int Exp_N = N*2;

   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i

   public int size() {
      // Total capacity is N - 1
      // The addition of N is to prevent -3 if the circular queue is wrapping around
      return (r - f + (N)) % N;
   }

   public void extendCapacity() {
      // This will extend our queue elements
      // We will have to use arraycopy
      // First we need to make a new array, double the n size
      E[] extendedQ = (E[]) new Object[N*2];
      // Second we need to store the old size of the OG queue so that any alterations to the OG size doesn't cause any issues when
      // - expanding
      int OG_size = size();
      // Check if front is less than rear, aka not wrapping
      if (f <= r) { // If proper case, a simple arraycopy
         System.arraycopy(Q, f, extendedQ, 0, OG_size);
         // The queue starting from position f
         // Is copied element by element from f -> r
         // Into positions in larger array starting from position index of 0
         // With the size indicating the amount of elements needed to be copied
   } else { // If the queue is wrapped
         int frontPart = N - f; // This will hold the number of all the elements from front to the maximum position of the array
         // AKA the size
         // For the backPart we will do the copying from 0 -> r
         System.arraycopy(Q, f, extendedQ, 0, frontPart); // from 0 -> the number of elements in frontPart
         // Inputting front element to the 0 index position
         // Now it is time for the backPart
         System.arraycopy(Q, 0, extendedQ, frontPart, r); // This will start from the 0 element in Q
         // Put the 0 element of Q into the position index after the frontPart is finished
         // Put all the elements between 0 -> r, using the size of r
      }

      // Remeber to update your variables
      Q = extendedQ; // The extended array is now the main array, for easier code running
      f = 0; // The front is now set back to index zero
      r = OG_size; // This will now hold the rear position, of the next free address
      N = N*2; // So the size is matched with the expanded array
   }
   public void enqueue(E element) {
      // First check if array is full, meaning if size is equal to available memory capacity
      if (size() == N-1) {
         extendCapacity(); // Call for the capacity of the queue to be expanded
      }
      // There shouldn't be an else here, that would basically makes the element triggering expansion disappear
      // Not enter the new array, since the variable would bypass the expansion.
         Q[r] = element; // Add the element to the rear's current address position
         r = (r+1) % N; // Increment the rear to the next available memory space
         // Front will stay the same


      // DEBUGGING CODE
      System.out.println(Arrays.toString(Q));
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
         Q[f] = null;
         f = (f+1) % N; // Increment the front position to the next queue element

         // This code was included to solve an error with queue
         if (f == r) {
            f = 0;
            r = 0;
         }

         //DEBUGGING CODE
         System.out.println(Arrays.toString(Q));


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

}

