import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var length = scanner.nextInt();
        int arr[] = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        var n = scanner.nextInt();
        int counter = 0;

        for (int j = 0; j < length; j++) {
            if (arr[j] == n) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}