import java.util.Scanner;

public class Main_E6_5 {
    public static class DataSet {
        private float sum =0;
        private int count =0;
        private float min = Float.MAX_VALUE ;
        private float max = Float.MIN_VALUE ;
        public void add(float value) {
            sum += value;
            count++;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        public float getAverage() {
            if (count == 0) {
                return 0;
            }
            return sum / count;
        }
        public float getSmallest() {
            return min;

        }
        public float getLargest() {
            return max;
        }
        public float getRange() {
            return max - min;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataSet dataSet = new DataSet();
        System.out.println("Enter a set of floating-point numbers: ");
        while (scanner.hasNextFloat()) {
            float value = scanner.nextFloat();
            dataSet.add(value);
        }
        System.out.println("Average:" + dataSet.getAverage());
        System.out.println("Smallest:" + dataSet.getSmallest());
        System.out.println("Largest:" + dataSet.getLargest());
        System.out.println("Range:" + dataSet.getRange());



    }
}
