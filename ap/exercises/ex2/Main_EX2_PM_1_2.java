package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the k : ");
        int k = scanner.nextInt();
        scanner.close();
        char [][] square = new char[k+2][k+2];
        for (int i = 0; i < k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                if (i == 0 || i == k+1 || j == 0 || j == k+1) {
                    square[i][j] = '*';
                }else{
                    square[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }
}
