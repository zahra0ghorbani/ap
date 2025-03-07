import java.util.Scanner;

public class Main_E6_3_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string :");
        String input = scanner.nextLine();
        scanner.close();
        char[] inputChars = input.toCharArray();
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(inputChars[i]) != -1) {
                System.out.println("'" + inputChars[i] + "' at position " + i+1 );
            }
        }
    }
}
