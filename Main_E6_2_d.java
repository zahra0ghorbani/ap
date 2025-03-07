import java.util.Scanner;

public class Main_E6_2_d {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sequence of integers (separated by spaces):");
        String sequence = scanner.nextLine();
        String[] inputs = sequence.split(" ");
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        System.out.print("repeated numbers:");
        if (numbers[0] == numbers[1]){
            System.out.print(numbers[0] + " ");
        }
        for(int i = 1; i < (inputs.length-1); i++) {
            if (numbers[i] == numbers[i + 1]) {
                if ( numbers[i] != numbers[i - 1]) {
                    System.out.print(numbers[i] + " ");
                }

            }
        }
    }
}