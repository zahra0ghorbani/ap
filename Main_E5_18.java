import java.util.Scanner;

public class Main_E5_18 {
    public static void main(String[] args) {
        System.out.println("\t\t\thi user Enter the words you want to sort ^_^");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\tword 1:");
        String str1 = scanner.nextLine();
        System.out.print("\t\t\tword 2:");
        String str2 = scanner.nextLine();
        System.out.print("\t\t\tword 3:");
        String str3 = scanner.nextLine();
        if(str2.compareTo(str3)>0){
            String temp = str2;
            str2 = str3;
            str3 = temp;
        }
        if(str1.compareTo(str2)>0){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if(str2.compareTo(str3)>0){
            String temp = str2;
            str2 = str3;
            str3 = temp;
        }
        System.out.println("\t\t\tnew order is:");
        System.out.println("\t\t\t" + str1);
        System.out.println("\t\t\t" + str2);
        System.out.println("\t\t\t" + str3);



    }
}