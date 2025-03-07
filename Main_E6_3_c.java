import java.util.Scanner;

public class Main_E6_3_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string :");
        String input = scanner.nextLine();
        scanner.close();
        String vowels = "aeiouAEIOU";
        char[] input_chars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input_chars[i]) != -1) {
                input_chars[i] = '_';
            }

        }
        String result = new String(input_chars);
        System.out.println(result);
    }
}


