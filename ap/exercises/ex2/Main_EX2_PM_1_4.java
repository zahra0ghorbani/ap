package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_4 {
    public static void main(String[] args) {
        System.out.println("enter chars (q to quit):");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input  = sc.nextLine();
            if(!input.isEmpty()){
                char ch = input.charAt(0);
                switch(ch) {
                    case 'w': {System.out.println("UP");break;}
                    case 'a': {System.out.println("LEFT");break;}
                    case 's': {System.out.println("DOWN");break;}
                    case 'd': {System.out.println("RIGHT");break;}
                    case 'q': {System.out.println("EXIT");return;}
                    default: {System.out.println("WARNING");}
                }
            }
        }
    }
}

