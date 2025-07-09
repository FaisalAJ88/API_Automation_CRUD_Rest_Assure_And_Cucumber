public class Arraysum {
    public static int sumArray(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int result = sumArray(array);
        System.out.println("Sum of array: " + result);
    }
}
