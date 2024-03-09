public class StackUsingArray {

    int array[];
    int topOfStack;

    public void createStack(int size) {
        array = new int[size];
        topOfStack = -1;
    }

    public void push(int value) {
        if (topOfStack == array.length - 1) {
            System.out.println("Stack is full or overflow");
        } else {
            topOfStack = topOfStack + 1;
            array[topOfStack] = value;
            System.out.println("Inserted value : " + value);
        }
    }

    public void pop() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty or underflow");
        } else {
            System.out.println("Removed value : " + array[topOfStack]);
            array[topOfStack] = -1;
            topOfStack = topOfStack - 1;
        }
    }

    public void peek() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty or underflow inside peek method");
        } else {
            System.out.println("Top element is : " + array[topOfStack]);
        }
    }

    public void isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is NOT empty");
        }
    }

    public void isFull() {
        if (topOfStack == array.length - 1) {
            System.out.println("Stack is full or overflow");
        } else {
            System.out.println("Stack is NOT full");
        }
    }

    public void delete() {
        array = null;
        topOfStack = -1;
    }

    public void display() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = topOfStack; i >= 0; i--) {
                System.out.println(array[i]);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.createStack(4);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.isFull();

        stack.push(40);
        stack.isFull();

        stack.display();

        stack.pop();
        stack.display();

        stack.pop();
        stack.display();

        stack.peek();
        stack.display();

        stack.isEmpty();
        stack.delete();
        stack.isEmpty();
    }
}
