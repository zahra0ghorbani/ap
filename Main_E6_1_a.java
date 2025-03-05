public class Main_E6_1_a {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=2 ; i<=100 ; i++){
            if( i%2 == 0 ){
                sum+=i;
            }
        }
        System.out.println("The sum of all even numbers between 2 and 100 is: " + sum );

    }
}