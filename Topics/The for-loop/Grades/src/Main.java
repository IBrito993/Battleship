import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var input = scanner.nextInt();
        var counterD = 0;
        var counterC = 0;
        var counterB = 0;
        var counterA = 0;
        for (int i = 0; i <= input; i++) {
            String grade = scanner.nextLine();
            switch (grade) {
                case "A":
                    counterA++;
                    break;
                case "B":
                    counterB++;
                    break;
                case "C":
                    counterC++;
                    break;
                case "D":
                    counterD++;
                    break;
                default:
                    break;
            }

        }
        System.out.println(String.format("%s %s %s %s", counterD, counterC, counterB, counterA));
    }
}