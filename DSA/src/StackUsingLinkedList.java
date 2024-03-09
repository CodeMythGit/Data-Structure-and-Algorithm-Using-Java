public class StackUsingLinkedList {

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void createStack() {
        head = null;
        size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void pop() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top of stack is : " + head.data);
            head = head.next;
            size--;
        }
    }

    public void peek() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(head.data);
        }
    }

    public void isEmpty() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
    }

    public void deleteAll() {
        head = null;
        size = 0;
    }

    public void display() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList sll = new StackUsingLinkedList();
        sll.createStack();

        sll.push(10);
        sll.push(20);
        sll.push(30);
        sll.push(40);

        sll.display();

        sll.pop();
        sll.display();

        sll.peek();
        sll.display();

        sll.isEmpty();
        sll.deleteAll();

        sll.isEmpty();
    }
}
