import java.util.Scanner;
public class Main_E6_2_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of integers (separated by spaces):");
        String sequence = scanner.nextLine();
        String[] inputs =sequence.split(" ");
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if ( numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("The minimum number is: " + min);
        System.out.println("The maximum number is: " + max);
    }
}