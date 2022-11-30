import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var number = scanner.nextInt();
        System.out.print(number%10>0?number%10:"");
        System.out.print((number%100)/10);
        System.out.print((number%1000)/100);

    }
}