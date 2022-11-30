import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.next();
        var subStrStart = scanner.nextInt();
        var subStrEnd = scanner.nextInt();

        System.out.println(inputString.substring(subStrStart, subStrEnd + 1));

    }
}