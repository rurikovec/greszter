package draw_triangle;

import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // triangle like this:
        //
        // *
        // **
        // ***
        // ****
        //
        // The triangle should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);

        System.out.println("Add a number:");
        int userNumber = scanner.nextInt();

        for (int i = 1; i <= userNumber; ++i) {
            for (int j = 1; j <= i; ++j) {
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}



