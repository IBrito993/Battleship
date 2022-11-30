import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        String[][] starArray = new String[n][n];

        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i + j) == (n - 1) || i == mid || j == mid) {
                    starArray[i][j] = "*";
                } else {
                    starArray[i][j] = ".";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(starArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}