import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var x = scanner.nextInt();
        var y = scanner.nextInt();
        int[][] inputArray = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputArray[i][j] = scanner.nextInt();
            }
        }
        int[][] outputArray = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                outputArray[j][x - 1 - i] = inputArray[i][j];
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(outputArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}