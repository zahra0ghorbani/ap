package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the k : ");
        int k = scanner.nextInt();
        scanner.close();
        char[][] square = new char[k+2][k+2];
        for (int i = 0; i < k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                if (i == 0 || i == k+1 || j == 0 || j == k+1) {
                    square[i][j] = '*';
                }else{
                    square[i][j] = ' ';
                }
            }
        }
        int xPos = 1;
        int yPos = 1;
        square[xPos][yPos] = 'X';
        Random random = new Random();

        while (true) {
            int direction = random.nextInt(4);
            //0=UP    1=RIGHT    2=DOWN   3=LEFT
            System.out.println(direction);
            int newXPos = xPos;
            int newYPos = yPos;
            switch (direction) {
                case 0:newXPos-- ;break;
                case 1:newYPos++;break;
                case 2:newXPos++;break;
                case 3:newYPos--;break;
            }
            if(newXPos <= 0 || newXPos >= k+1 || newYPos <= 0 || newYPos >= k+1){
                System.out.println("hitting the game wall \ngame over!");
                return;
            }else{
                square[xPos][yPos] = ' ';
                xPos = newXPos;
                yPos = newYPos;
                square[xPos][yPos] = 'X';
            }
            for (int i = 0; i < k+2; i++) {
                for (int j = 0; j < k+2; j++) {
                    System.out.print(square[i][j]);
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
