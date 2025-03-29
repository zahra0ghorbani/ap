package ap.exercises.ex2;
import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the k : ");
        int k = scanner.nextInt();

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
        int c;
        while (true) {
            System.out.print("Enter the c : ");
            c = scanner.nextInt();
            int freeCells = k * k;
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








        int xPos = 1;
        int yPos = 1;
        square[xPos][yPos] = 'X';
        System.out.println(" w --> UP \n a --> LEFT \n s --> DOWN \n d --> RIGHT");
        for (int i = 0; i < k+2; i++) {
            for (int j = 0; j < k+2; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
        int score =0;
        int dotCount = c;
        long start = System.currentTimeMillis();
        while (true) {
            System.out.print("enter move:");
            char direction= scanner.next().charAt(0) ;
            //0=UP    1=RIGHT    2=DOWN   3=LEFT
            int newXPos = xPos;
            int newYPos = yPos;
            switch (direction) {
                case 'w':newXPos-- ;break;
                case 'd':newYPos++;break;
                case 's':newXPos++;break;
                case 'a':newYPos--;break;
            }
            if(newXPos <= 0 || newXPos >= k+1 || newYPos <= 0 || newYPos >= k+1){
                System.out.println("hitting the game wall \ngame over!");
                break;
            }else{
                if (square[newXPos][newYPos] == '.') {
                    score++;
                    dotCount--;
                }
                square[xPos][yPos] = ' ';
                xPos = newXPos;
                yPos = newYPos;
                square[xPos][yPos] = 'X';
                if(dotCount == 0){
                    System.out.println("All dots collected!");
                    break;
                }
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
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("\nfinal Score: " + score);
        System.out.println("Time played: " + timeElapsed + " milliseconds");

    }
}
