import java.util.Scanner;

public class Main_E6_3_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string:");
        String input = scanner.nextLine();
        scanner.close();
        for (int i = 1; i < input.length(); i+= 2) {
            System.out.print(input.charAt(i) + ",");
        }
    }
}

