package ap.exercises.ex2;
import java.util.Scanner;

public class Main_EX2_PM_2_1 {
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
        while (true) {
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
