import java.util.Scanner;

public class Main_E6_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length:");
        int length = scanner.nextInt();
        scanner.close();
        for (int j = 0; j < length; j++) {
            for (int i1 = 0; i1 < length; i1++) {
                System.out.print("*");

            }
            System.out.print("  ");
            for (int i2 = 0; i2 < length; i2++) {
                if ( i2 == length - 1 || i2 == 0 || j == length - 1 || j==0 ) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
