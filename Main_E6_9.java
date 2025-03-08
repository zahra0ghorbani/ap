import java.util.Scanner;

public class Main_E6_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string:");
        String input = scanner.nextLine();
        scanner.close();
        char[] chars = input.toCharArray();
        for (int i = chars.length-1; i >= 0 ; i--) {
            System.out.print(chars[i]);
        }
    }
}