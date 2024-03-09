public class CircularDoublyLinkedList {

    class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    //insert
    public void insert(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    //display
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            System.out.print(head.data + " -> ");
            Node curr = head.next;
            while (curr != head) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
        }
        System.out.println();
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            newNode.next = head;
            head.prev = newNode;
            tail.next = newNode;
            newNode.prev = tail;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head;
            head.prev = tail;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        } else if (index == 0) {
            addAtHead(data);
        } else if (index == size) {
            addAtTail(data);
        } else {
            Node prevNode = getPreviousNode(index - 1);
            Node newNode = new Node(data);

            newNode.next = prevNode.next;
            prevNode.next.prev = newNode;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            size++;
        }
    }

    public int search(int data) {
        if (isEmpty()) {
            System.out.println("Not found as list is empty");
            return -1;
        }

        if (head.data == data) {
            return 0;
        } else {
            Node current = head.next;
            int index = 1;
            while (current != head) {
                if (current.data == data) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index position");
            return;
        } else if (index == 0) {
            head = head.next;
            tail.next = head;
            head.prev = tail;
            size--;
        } else {
            Node prevNode = getPreviousNode(index - 1);

            if (index == (size - 1)) {
                tail = prevNode;
                tail.next = head;
                head.prev = tail;
                size--;
            } else {
                prevNode.next = prevNode.next.next;
                prevNode.next.next.prev = prevNode;
                size--;
            }
        }
    }

    private Node getPreviousNode(int index) {

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.insert(10);
        cdll.insert(20);
        cdll.insert(30);
        cdll.insert(40);

        cdll.display();

        cdll.addAtHead(50);

        cdll.display();
        cdll.addAtHead(60);
        cdll.display();

        cdll.addAtTail(70);
        cdll.display();

        cdll.addAtTail(80);
        cdll.display();

        cdll.addAtIndex(100, 1);
        cdll.display();

        cdll.addAtIndex(101, 0);
        cdll.display();

        cdll.addAtIndex(102, cdll.size);
        cdll.display();

//        System.out.println("Find 10 : index -> " + cdll.search(10));
//        System.out.println("Find 200 : index -> " + cdll.search(200));
//        System.out.println("Find 101 : index -> " + cdll.search(101));

        cdll.deleteAtIndex(1);
        cdll.display();

        cdll.deleteAtIndex(10);
        cdll.display();

        cdll.deleteAtIndex(9);
        cdll.display();

        cdll.deleteAtIndex(0);
        cdll.display();


    }
}
