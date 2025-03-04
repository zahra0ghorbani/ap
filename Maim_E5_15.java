import java.util.Scanner;

public class Maim_E5_15 {
    public static void main(String[] args) {
        System.out.println("\t\t+--------------------------------+");
        System.out.println("\t\t|          hi user ^_^           |");
        System.out.println("\t\t+--------------------------------+");
        System.out.print("\t\t| enter your salary (dollars):");
        Scanner scanner = new Scanner(System.in);
        float salary = scanner.nextInt();
        float tax =0;

        if (salary > 500_000){
            tax+=(salary-500_000) * 0.06f;
            salary = 500_000;
        }
        if (salary > 250_000){
            tax+=(salary - 250_000) * 0.05f;
            salary = 250_000;
        }
        if (salary > 100_000){
            tax+=(salary - 100_000) * 0.04f;
            salary = 100_000;
        }
        if (salary > 75_000){
            tax+=(salary - 75_000) * 0.03f;
            salary = 75_000;
        }
        if (salary > 50_000){
            tax+=(salary - 50_000) * 0.02f;
            salary = 50_000;
        }
        tax += salary * 0.01f;

        System.out.println("\t\t| dear user your tax is "+tax+" dollars! ^_^");



    }
}