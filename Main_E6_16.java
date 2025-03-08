public class Main_E6_16 {
    public static void main(String[] args) {
        for (int y = 1; y <= 10; y++) {
            System.out.println("+-----------------------------------------------------------+");
            for (int x = 1; x <= 10; x++) {
                System.out.printf( "| %3d " , x*y );
            }
            System.out.print("|\n");
            if(y == 10){
                System.out.println("+-----------------------------------------------------------+");
            }
        }
    }
}
