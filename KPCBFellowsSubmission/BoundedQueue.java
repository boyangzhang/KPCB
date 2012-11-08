/*
 * BoundedQueue.java
 * 
 * Bounded queue implementation for KPCB fellowship application
 *
 * By Boyang Zhang
 * 11/07/12
 */


public class BoundedQueue {
    int[] queue;
    int head;
    int tail;
    int size;

    /*
     * BoundedQueue - constructor for BoundedQueue class
     *
     * @param int length - length of queue
     */

    public BoundedQueue(int length ) {
        queue = new int[length];
        head = 0;
        tail = 0;
        size = 0;
    }

    /*
     * isEmpty - checks to see if Queue is empty
     *
     * @return true if empty, false if not
     */

    public boolean isEmpty() {
        return size == 0;
    }

    /*
     * isFull - checks to see if Queue is full
     *
     * @return true if full, false if not
     */

    public boolean isFull() {
        return size == queue.length;
    }

    /*
     * enqueue - Enqueue a value into the BoundedQueue.  
     * Prints "Queue is full" and returns if attempting to 
     * enqueue into a full queue.
     *
     * @param int n - value to enqueue
     */

    public void enqueue(int n) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        else {
            if(tail == queue.length) tail = 0;
            //For debugging in the main method
            System.out.println("Enqueue: " + n);
            queue[tail] = n;
            tail++;
            size++;
        }
    }

    /*
     * dequeue - Dequeues the current head value from BoundedQueue.  
     * Prints "Queue is empty" and throws an Exception
     * if attempting to dequeue from an empty queue.
     *
     * @return enqueued int value in FIFO order
     */

    public int dequeue() throws Exception{
        int retVal = 0;
        if(isEmpty()) {
            throw new Exception("Queue is empty");
        }
        else {
            if(head == queue.length) head = 0;
            retVal = queue[head];
            queue[head] = 0;
            head++;
            size--;
	   }
       return retVal;   
    }

    /*
     * main - basic tests
     */
    public static void main(String args[]) {
        /*Test 1*/
        System.out.println("Try enqueue into zero length queue");
        BoundedQueue bq = new BoundedQueue(0);
        bq.enqueue(5);
        try{
            bq.dequeue();
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }
        System.out.println();

        /*Test 2*/
        System.out.println("Try enqueue 6 values into 5 length queue");
        BoundedQueue bq1 = new BoundedQueue(5);
        for(int i = 0; i < 6; i++) {
            bq1.enqueue(i);
        }
        for(int i = 0; i < 6; i++) {
            try {
                System.out.println(bq1.dequeue());
            }
            catch(Exception e) {
                System.out.println("Dequeue Exception thrown on empty queue!");
            }

        }
        System.out.println();

        /*Test 3*/
        System.out.println("Try arbitrary enqueues and dequeues");
        BoundedQueue bq2 = new BoundedQueue(4);
        bq2.enqueue(4);
        bq2.enqueue(5);
        try {
            System.out.println(bq2.dequeue());
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }
        bq2.enqueue(7);
        bq2.enqueue(6);
        bq2.enqueue(8);
        bq2.enqueue(9);
        try {
            //So if any of these throws the exception, it won't call the rest
            //dequeue methods, but this test expects only the last value
            //to throw the value as I did not want to surround each call to
            //dequeue with a try catch.
            System.out.println(bq2.dequeue());
            System.out.println(bq2.dequeue()); 
            System.out.println(bq2.dequeue());
            System.out.println(bq2.dequeue());
            System.out.println(bq2.dequeue());
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }
        bq2.enqueue(1);
        try {
            System.out.println(bq2.dequeue());
            System.out.println(bq2.dequeue());
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }        
        bq2.enqueue(4);
        bq2.enqueue(5);
        bq2.enqueue(6);
        try {
            System.out.println(bq2.dequeue());
            System.out.println(bq2.dequeue());
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }        
        bq2.enqueue(8);
        try {
            System.out.println(bq2.dequeue());
        }
        catch(Exception e) {
            System.out.println("Dequeue Exception thrown on empty queue!");
        }        
    }
}