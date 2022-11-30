import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input1 = scanner.nextInt();
        var input2 = scanner.nextInt();
        var input3 = scanner.nextInt();

        var result = ((input1/2)+(input2/2)+(input3/2));

        System.out.println(result);
    }
}