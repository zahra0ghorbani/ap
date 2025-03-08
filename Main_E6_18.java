import java.util.Scanner;

public class Main_E6_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length :");
        int length = scanner.nextInt();
        scanner.close();
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i) - 1; k++) {
                System.out.print("*");
            }
            System.out.println("\n");

        }
        for (int i = length -1 ; i >= 1; i--) {
            for (int k = 1; k <= length - i ; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2*i) - 1 ; j++) {
                System.out.print("*");
            }
            System.out.println("\n");

        }
    }
}