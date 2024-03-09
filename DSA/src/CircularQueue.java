public class CircularQueue {
    int size = 4;
    int arr[] = new int[size];
    int front;
    int rear;

    CircularQueue() {
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        } else if (front == rear + 1) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = value;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Removed value is : " + arr[front]);
            arr[front] = -1;
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
        }
    }

    public void display() {
        int i;
        for (i = front; i != rear; i = (i + 1) % size) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println(arr[i]); // rear value
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();

        System.out.println("isEmpty : "+q.isEmpty());
        System.out.println("isFull : "+q.isFull());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.enqueue(40);
        q.display();
        q.enqueue(50);

        q.dequeue();
        q.display();

        q.enqueue(50);
        q.display();

        System.out.println("isEmpty : "+q.isEmpty());
        System.out.println("isFull : "+q.isFull());
    }
}
