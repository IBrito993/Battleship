import java.util.Arrays;
import java.util.Scanner;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        var currentIndex = 0;
        while (steps > arr.length) {
            steps = steps - arr.length;
        }

        // Creating a temporary array of size d
        int temp[] = new int[arr.length - steps];

        // Now copying first N-D element in array temp
        for (int i = 0; i < arr.length - steps; i++)
            temp[i] = arr[i];

        // Moving the rest element to index zero to D
        for (int i = arr.length - steps; i < arr.length; i++) {
            arr[i - arr.length + steps] = arr[i];
        }

        // Copying the temp array element
        // in original array
        for (int i = 0; i < arr.length - steps; i++) {
            arr[i + steps] = temp[i];
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}