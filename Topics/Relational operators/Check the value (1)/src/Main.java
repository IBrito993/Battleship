import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var a = scanner.nextInt();
        System.out.println(a < 10 && a > 0);
    }
}