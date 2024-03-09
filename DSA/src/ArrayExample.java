public class ArrayExample {

    public static void main(String[] args) {
        //create
        // type variable_name[] = new type[size];
        // index start 0

        int a[] = new int[5];
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[3] = 40;
        a[4] = 50;

        //int b[] = {20,30,40};

        // read
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }

        // update
        a[4] = 60;
        System.out.println("After update");
        // read
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }

        // delete
        a[2] = -1;
        System.out.println("After deleting");
        // read
        for (int index = 0; index < a.length; index++) {
            System.out.println(a[index]);
        }
    }
}
