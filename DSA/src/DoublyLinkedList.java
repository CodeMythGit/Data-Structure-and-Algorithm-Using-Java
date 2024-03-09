public class DoublyLinkedList {

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

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println();
    }

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index: " + index);
            return;
        }

        if (index == 0) {
            addAtHead(data);
        } else if (index == size) {
            addAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node previousNode = getPreviousNode(index - 1);
            newNode.next = previousNode.next;
            previousNode.next.prev = newNode;
            previousNode.next = newNode;
            newNode.prev = previousNode;
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
        if (size == 0 || head == null) {
            System.out.println("Not found : " + data);
        } else if (head.data == data) {
            return 0;
        } else {
            int index = 1;
            Node current = head.next;
            while (current != null) {
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
            System.out.println("Invalid index");
            return;
        } else if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node prevNode = getPreviousNode(index - 1);
            if (index == size - 1) {
                tail = prevNode;
                tail.next = null; // imp
            } else {
                prevNode.next = prevNode.next.next;
                prevNode.next.next.prev = prevNode;
            }
            size--;
        }
    }

    public void deleteAll() {
        head = tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1);
        list.insert(2);

        list.display();

        list.addAtHead(6);
        list.display();

        list.addAtTail(7);
        list.display();

        list.addAtIndex(8, 1);
        list.display();

        list.addAtIndex(10, 3);
        list.display();

        list.addAtIndex(11, 0);
        list.display();

        System.out.println("Search 8 -> index " + list.search(8));
        System.out.println("Search 11 -> index " + list.search(11));
        System.out.println("Search 7 -> index " + list.search(7));

        list.display();

        list.deleteAtIndex(0);
        list.display();

        list.deleteAtIndex(list.size - 1);
        list.display();


        list.deleteAtIndex(2);
        list.display();

        list.deleteAtIndex(10);

        list.deleteAll();
        list.display();
    }
}
