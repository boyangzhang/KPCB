
public class BoundedQueue {
    int[] queue;
    int head;
    int tail;
    int size;

    public BoundedQueue(int length ) {
        queue = new int[length];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public void enqueue(int n) {
        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }
        else {
            if(tail == queue.length) tail = 0;
            queue[tail] = n;
            tail++;
            size++;
        }
    }

    public int dequeue() {
        int retVal = 0;
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return 0;
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

    public static void main(String args[]) {
        System.out.println("Intiialize zero length queue, enqueue and dequeue");
        BoundedQueue bq = new BoundedQueue(0);
        bq.enqueue(5);
        bq.dequeue();

        System.out.println("Initialize a 5 length queue,  Enqueue 6 times and dequeue 6 times");
        BoundedQueue bq1 = new BoundedQueue(5);
        bq1.enqueue(1);
        bq1.enqueue(2);
        bq1.enqueue(3);
        bq1.enqueue(4);
        bq1.enqueue(5);
        bq1.enqueue(6);
        for(int i = 0; i < 6; i++) {
            System.out.println(bq1.dequeue());
        }

        BoundedQueue bq2 = new BoundedQueue(4);
        System.out.println("Enqueuing");
        bq2.enqueue(4);
        bq2.enqueue(5);
        System.out.println(bq2.dequeue());
        System.out.println("Enqueuing");
        bq2.enqueue(7);
        bq2.enqueue(6);
        bq2.enqueue(8);
        bq2.enqueue(9);
        System.out.println(bq2.dequeue());
        System.out.println(bq2.dequeue()); 
        System.out.println(bq2.dequeue());
        System.out.println(bq2.dequeue());
        System.out.println(bq2.dequeue());
        System.out.println("Enqueuing");
        bq2.enqueue(1);
        System.out.println(bq2.dequeue());
        System.out.println(bq2.dequeue());
        System.out.println("Enqueuing");
        bq2.enqueue(4);
        bq2.enqueue(5);
        bq2.enqueue(6);
        System.out.println(bq2.dequeue());
        System.out.println(bq2.dequeue());
        System.out.println("Enqueuing");
        bq2.enqueue(8);
        System.out.println(bq2.dequeue());
    }
}