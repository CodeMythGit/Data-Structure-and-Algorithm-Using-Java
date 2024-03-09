public class CircularSinglyLinkedList {

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    private int size() {
        return size;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.print(head.data + " -> ");
            Node current = head.next;
            while (current != head) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
        }
        System.out.println();
    }

    //addATHead
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
        } else if (index == 0) {
            addAtHead(data);
        } else if (index == size - 1) {
            addAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node prevNode = getPreviousNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    private Node getPreviousNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int search(int data) {
        if (head == null) {
            return -1;
        } else {
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
        }
        return -1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
        } else if (index == 0) {
            head = head.next;
            tail.next = head;
        } else if (index == size - 1) {
            Node prevNode = getPreviousNode(index - 1);
            prevNode.next = head;
            tail = prevNode;
        } else {
            Node prevNode = getPreviousNode(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    public void deleteAll() {
        head = tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.add(1);
        circularSinglyLinkedList.add(2);
        circularSinglyLinkedList.add(3);
        circularSinglyLinkedList.add(4);
        circularSinglyLinkedList.add(5);

        System.out.println(circularSinglyLinkedList.size());

        circularSinglyLinkedList.display();

        circularSinglyLinkedList.addAtHead(10);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.addAtTail(11);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.addAtIndex(12, 2);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.addAtIndex(13, 0);
        circularSinglyLinkedList.display();

        System.out.println(circularSinglyLinkedList.size());

        System.out.println(circularSinglyLinkedList.search(12));

        System.out.println(circularSinglyLinkedList.search(13));
        System.out.println(circularSinglyLinkedList.search(11));
        System.out.println(circularSinglyLinkedList.search(-10));

        circularSinglyLinkedList.display();

        circularSinglyLinkedList.deleteAtIndex(0);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.deleteAtIndex(7);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.deleteAtIndex(9);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.deleteAtIndex(3);
        circularSinglyLinkedList.display();

        circularSinglyLinkedList.deleteAll();
        circularSinglyLinkedList.display();

    }


}
