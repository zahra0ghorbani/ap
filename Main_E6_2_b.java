import java.util.Scanner;

public class Main_E6_2_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of integers (separated by spaces):");
        String sequence = scanner.nextLine();
        String[] inputs =sequence.split(" ");
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        int even_count = 0;
        int odd_count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                even_count++;
            }else{
                odd_count++;
            }

        }
        System.out.println("Number of even numbers: " + even_count);
        System.out.println("Number of odd numbers: " + odd_count);
    }

}
