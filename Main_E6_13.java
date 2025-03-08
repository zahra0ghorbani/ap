import java.util.Scanner;

public class Main_E6_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\tEnter number:");
        int number = scanner.nextInt();
        scanner.close();
        System.out.print("\t\tnumber's binary :");
        while (number != 0) {
            if (number % 2 == 0) {
                System.out.print("0 ");
            }else{
                System.out.print("1 ");
            }
            number = number / 2;
        }
    }
}
