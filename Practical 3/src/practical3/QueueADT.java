/**
 * @ Author: Muhammad Saad Khan
 * @ Date: 2025 - 10 - 20
 * @ Title: Practical 3
 * @ Module: CS207
 *
 * @ Version: Java 25
 * **/

package practical3;

public interface QueueADT<E>
{
   /**
    * may throw FullQueueException
    */   public void enqueue(E element);
   
   /**
    * throws EmptyQueueException
    */
   public E dequeue();
   
   /**
    * throws EmptyQueueException
    */
   public E front();

   public int size();

   public boolean isEmpty();
}
