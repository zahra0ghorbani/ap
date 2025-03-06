import java.util.Scanner;

public class Main_E6_2_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of integers (separated by spaces):");
        String sequence = scanner.nextLine();
        String[] inputs = sequence.split(" ");
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        int cumulative_sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            cumulative_sum += numbers[i];
            System.out.print(cumulative_sum + "_");
        }
    }
}