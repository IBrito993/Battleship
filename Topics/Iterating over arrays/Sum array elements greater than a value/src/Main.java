import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var length = scanner.nextInt();
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            var intInput = scanner.nextInt();
            intArray[i] = intInput;
        }
        var n = scanner.nextInt();
        int result = 0;
        for (int j = 0; j < length; j++) {
            if (intArray[j] > n) {
                result += intArray[j];
            }
        }
        System.out.println(result);
    }
}