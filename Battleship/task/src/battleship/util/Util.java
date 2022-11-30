package battleship.util;

import static battleship.util.Constants.FIELD;

public class Util {


    public static void printBattlefield(String[][] battlefield) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(battlefield[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    public static int getValueFromYCoordinate(char c) {
        return c - 64;
    }

    public static void checkAdjacentPositions(int col, int startingPoint, int endingPoint, String[][] battlefield, boolean isVertical) throws RuntimeException {
        if (isVertical) {
            if (battlefield[startingPoint - 1][col].equals("O")) {
                throw new RuntimeException(Constants.TOO_CLOSE);
            }
            if (endingPoint < 10 && battlefield[endingPoint + 1][col].equals("O")) {
                throw new RuntimeException(Constants.TOO_CLOSE);
            }
        } else {
            if (battlefield[col][startingPoint - 1].equals("O")) {
                throw new RuntimeException(Constants.TOO_CLOSE);
            }
            if (endingPoint < 10 && battlefield[col][endingPoint + 1].equals("O")) {
                throw new RuntimeException(Constants.TOO_CLOSE);
            }
        }

    }

    public static boolean checkIfLastCellOfShip(int inputX, int inputY, String[][] battlefield) throws RuntimeException {
        if (inputX > 1) {
            if (battlefield[inputX - 1][inputY].equals("O")) {
                return false;
            }
        }
        if (inputX < 10) {
            if (battlefield[inputX + 1][inputY].equals("O")) {
                return false;
            }
        }
        if (inputY > 1) {
            if (battlefield[inputX][inputY - 1].equals("O")) {
                return false;
            }
        }
        if (inputY < 10) {
            if (battlefield[inputX][inputY + 1].equals("O")) {
                return false;
            }
        }

        return true;

    }

    public static String[][] buildBattlefield() {
        String[][] battlefield = new String[11][11];
        char character = 65;
        battlefield[0][0] = "";
        for (int i = 1; i < 11; i++) {
            battlefield[i][0] = String.valueOf(character);
            character++;
        }
        for (int j = 1; j < 11; j++) {
            battlefield[0][j] = String.valueOf(j);
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                battlefield[i][j] = FIELD;
            }
        }
        return battlefield;
    }
}
