import java.util.Scanner;
public class E5_2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\t\t\t\t\thello dear user!   ^_^   ");
        System.out.print("\t\t\t\t\tplease enter a floating point number:");
        Scanner scanner = new Scanner(System.in);
        float user_Input = scanner.nextFloat();
        scanner.close();
        System.out.print("\t\t\t\t\tyour entered number is ");
        if(user_Input!=0){
            if(user_Input<1 && user_Input>(-1)){
                System.out.print("\t\t\t\t\tsmall ");
            }else if (user_Input>1_000_000){
                System.out.print("\t\t\t\t\tlarge ");

            }
        }
        if (user_Input==0){
            System.out.print("\t\t\t\t\tzero");
        } else if(user_Input <0){
            System.out.print("negative ^_^");

        }else if(user_Input >0){
            System.out.print("positive ^_^");
        }
        System.out.println("\n\t\t\t\t\t+--------------------------+");
        System.out.println("\t\t\t\t\t|       bye ~_*            |");
        System.out.println("\t\t\t\t\t+--------------------------+");
        Thread.sleep(3000);
    }
}
