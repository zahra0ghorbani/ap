import java.util.Scanner;

public class Main_E6_3_a {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\tEnter a string:");
        String input = scanner.nextLine();
        System.out.print("\t\t");
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                System.out.print(ch + " ");
            }
        }
    }
}
