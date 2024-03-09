public class Array2DExample {

    public static void main(String[] args) {
        //syntax

        // type var_name[][] = new type[rows_size][col_size];

        // create
        int row_size = 3, col_size = 3;
        int a[][] = new int[row_size][col_size];

        int counter = 1;
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                a[i][j] = counter;
                counter++;
            }
        }

        // read
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(a[i][j] + " |");
            }
            System.out.println();
        }

        // update
        a[2][2] = 20;

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(a[i][j] + " |");
            }
            System.out.println();
        }

        a[2][2] = -1;
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(a[i][j] + " |");
            }
            System.out.println();
        }
    }
}
