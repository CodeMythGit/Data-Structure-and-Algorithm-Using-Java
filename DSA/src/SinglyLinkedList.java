public class SinglyLinkedList {

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;

    private int size = 0;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        if (size == 0 || head == null) {
            System.out.println("Empty list");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
        }
        System.out.println("\n");
    }

    //addAtHead

    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (size == 0 || head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    //addAtLast/ Tail
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (size == 0 || head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of range");
        } else if (index == 0) {
            addAtHead(data);
        } else if (index == size) {
            addAtTail(data);
        } else {
            Node newNode = new Node(data);
            Node prevNode = getPrevNode(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            size++;
        }
    }

    private Node getPrevNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int search(int data) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == data) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void removeNode(int index) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        } else {
            if (index < 0 || index > size) {
                System.out.println("Index out of range");
                return;
            } else if (index == 0) {
                head = head.next;
                size--;
                return;
            } else if (index == size) {
                tail = getPrevNode(index - 1);
                tail.next = null;
                size--;
                return;
            } else {
                Node prevNode = getPrevNode(index - 1);
                prevNode.next = prevNode.next.next;
                size--;
                return;
            }
        }
    }

    public void deleteAllNode() {
        head = null;
        tail = null;
        size = 0;
    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addNode(10);
        sll.addNode(20);
        sll.addNode(30);
        sll.addNode(40);
        System.out.println("Size : " + sll.size);

        sll.display();

        sll.addAtTail(50);
        sll.display();
        System.out.println("Size : " + sll.size);

        sll.addAtHead(70);
        sll.display();
        System.out.println("Size : " + sll.size);

        sll.addAtIndex(80, 1);

        sll.display();
        System.out.println("Size : " + sll.size);
        sll.addAtIndex(80, -1);

        System.out.println("Find 100 : " + sll.search(100));
        System.out.println("Find 20 : " + sll.search(20));
        System.out.println("Find 70 : " + sll.search(70));
        System.out.println("Find 50 : " + sll.search(50));

        sll.removeNode(-1);
        sll.removeNode(0);
        sll.display();

        sll.removeNode(sll.size - 1);
        sll.display();

        sll.removeNode(2);
        sll.display();

        sll.deleteAllNode();
        sll.display();
    }
}
