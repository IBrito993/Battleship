import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        var x = scanner.nextInt();
        var y = scanner.nextInt();
        int[][] inputArray = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputArray[i][j] = scanner.nextInt();
            }
        }
        int seatNumber = scanner.nextInt();
        int emptyCounter = 0;
        int outPutRow = 0;
        a:
        for (int i = 0; i < x; i++) {
            b:
            for (int j = 0; j < y; j++) {
                if (inputArray[i][j] == 0) {
                    emptyCounter++;
                    if (emptyCounter == seatNumber) {
                        outPutRow = ++i;
                        break a;
                    }
                } else {
                    emptyCounter = 0;
                }
            }
            emptyCounter = 0;
        }

        System.out.println(outPutRow);
    }
}