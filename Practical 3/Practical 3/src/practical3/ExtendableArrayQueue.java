package practical3;


import static java.lang.System.arraycopy;

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

   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i

   public int size() {
      // Total capacity is N - 1
      // The addition of N is to prevent -3 if the circular queue is wrapping around
      return (r - f + (N)) % N;
   }

   public void ExtendCapacity() {
      // This will extend our queue elements
      // We will have to use arraycopy
      // First we need to make a new array, double the n size
      E[] extendedQ = (E[]) new Object[N*2];
      // Check if front is less than rear, aka not wrapping
      if (f <= r) {
         // copy array objects
         arraycopy(Q, f, extendedQ, 0, size()); // We will use f, not zero for the src location since we don't know if front is 0, 1, 2
         // but we want the front element of Q to be in the 0 position of extendedQ

      } else {
         // Intialise j for the use in E.Q position
         int j = 0;
         // If array is wrapped
         // First enter the front to last elements into extendedQ from 0 point
         for (int i = f; i < N-1; i++) {
            // This will iterate through front to last element

            // This will enter the current element in Q into the element position from 0 in E.Q
            extendedQ[j] = Q[i];
            // This will iterate from 0 point of E.Q to the last element position in the Q array
            j++;
         }

         // After that enter the 0 position element to the rear element into the extendedQ, after the previously entered point
         for (int i = 0; i < r; i++) {
            // Increment from 0 to the rear position
            // J would be in the changed position
            extendedQ[j] = Q[i];

            // Increment j
            j++;
         }
      }
      // Update all the different points
      // Update Q
      Q = extendedQ;
      // Update front
      f = 0;
      // Update rear
      r = size()-1;
      // Update N
      N = N*2;

      System.out.println(N);
      //System.out.println(Q);
   }

   public void enqueue(E element) {
      // First check if array is full, meaning if size is equal to available memory capacity
      if (size() == N-1) {
         ExtendCapacity();
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
         //return
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
         //System.out.println(f);;
         return Q[f];
   }

   public boolean isEmpty() {
      return f == r;
   }



}

