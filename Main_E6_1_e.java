import java.util.Scanner;

public class Main_E6_1_e {
    public static void main(String[] args) {

        System.out.print("\t\tinput the number :" );
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum=0 ;
        while(number != 0){
            if((number%10)%2 == 1){
                sum += number%10  ;
            }
            number = number/10 ;
        }
        System.out.println("\t\tthe sum of the odd digits of "+ number +" is : "+sum);
    }
}