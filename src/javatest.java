public class javatest {
    public static void main(String[] args) {
        int rows = 4; // Number of rows
        int num = 1;  // Start number

        for (int i = 1; i <= rows; i++) {
            int start = num; // Store the start value for the row
            num += i;  // Move num forward by 'i' steps for the next row

            // Print in increasing order for the first row, and decreasing order for others
            if (i % 2 != 0) {
                // Print in forward order
                for (int j = start; j < num; j++) {
                    System.out.print(j + " ");
                }
            } else {
                // Print in reverse order
                for (int j = num - 1; j >= start; j--) {
                    System.out.print(j + " ");
                }
            }
            System.out.println(); // Move to the next line
        }
    }
}