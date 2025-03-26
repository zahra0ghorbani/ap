package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_PM_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the k : ");
        int k = scanner.nextInt();
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
        int freeCells = k * k ;

        int c;
        while (true) {
            System.out.print("Enter the c : ");
            c = scanner.nextInt();
            if (c <= freeCells && c >= 0) {
                break;
            }
            System.out.println("Invalid input! \n the number must be between 0 and " + freeCells);
        }
        Random random = new Random();
        int points = 0 ;
        while (points < c) {
            int x = random.nextInt(k) + 1;
            int y = random.nextInt(k) + 1;
            if (square[x][y] == ' ') {
                square[x][y] = '.';
                points++;
            }
        }
        for (int i = 0; i < k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
        scanner.close();
    }
}

