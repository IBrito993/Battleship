import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextInt();
        int[] counterArray = {0, 0, 0};
        for (int i = 0; i < input; i++) {
            var size = scanner.nextInt();
            if (size < 0) {
                counterArray[2]++;
            }
            if (size > 0) {
                counterArray[1]++;
            }
            if (size == 0) {
                counterArray[0]++;
            }
        }
        System.out.println(String.format("%s %s %s", counterArray[0], counterArray[1], counterArray[2]));
    }
}