import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                a[i][j] = scanner.nextInt();
            }
        }
        boolean symmetric = true;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (a[i][j] != a[j][i]) {
                    symmetric = false;
                }
            }
        }
        if (symmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}