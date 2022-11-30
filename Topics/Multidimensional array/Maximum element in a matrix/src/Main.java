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
        int maxNumber = Integer.MIN_VALUE;
        int outputX = 0;
        int outputY = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (inputArray[i][j] > maxNumber) {
                    outputX = i;
                    outputY = j;
                    maxNumber = inputArray[i][j];
                }
            }
        }

        System.out.println(outputX + " " + outputY);
    }
}