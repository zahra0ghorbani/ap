import java.util.Scanner;

public class Main_E6_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string:");
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }
}
