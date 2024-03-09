public class LinearQueueUsingArray {

    int arr[];
    int front;
    int rear;

    public void createQueue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
    }


    public boolean isFull() {
        if (front == 0 && rear == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Overflowing queue");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = value;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Removing queue value : " + arr[front]);
            arr[front] = -1;
            front++;
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + " -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinearQueueUsingArray queue = new LinearQueueUsingArray();
        queue.createQueue(4);


        queue.enqueue(10);
        queue.enqueue(20);

        queue.display();

        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        queue.enqueue(50);

        queue.dequeue();
        queue.display();

    }

}
