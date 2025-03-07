import java.util.Scanner;

public class Main_E6_3_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a string :");
        String input = scanner.nextLine();
        scanner.close();
        String vowels = "aeiouAEIOU";
        int vowelCounter = 0;
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < input.length(); i++){
            if (vowels.indexOf(inputChars[i]) != -1){
                vowelCounter++;

            }

        }
        System.out.println(vowelCounter);
    }
}
