import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input % 2 > 0) {
            input += 1;
        } else {
            input += 2;
        }
        System.out.println(input);
    }
}