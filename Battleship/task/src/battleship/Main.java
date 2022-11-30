package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static battleship.util.Constants.*;
import static battleship.util.Util.*;


public class Main {
    public static Map<Integer, String> BattleshipTypes = new HashMap<>();

    public static String[][] battlefield = buildBattlefield();
    public static String[][] fogOfWar = buildBattlefield();
    public static String[][] battlefield_2 = buildBattlefield();
    public static int hitsCounter = 17;
    public static int hitsCounter2 = 17;
    public static boolean isPlayerOne = true;

    public static void main(String[] args) {
        BattleshipTypes.put(5, "Aircraft Carrier");
        BattleshipTypes.put(4, "Battleship");
        BattleshipTypes.put(3, "Submarine/Cruiser");
        BattleshipTypes.put(2, "Destroyer");
        try {
            System.out.println(PLAYER_ONE_START);
            printBattlefield(battlefield);
            inputBattleship(AIRCRAFT_CARRIER_LENGTH);
            inputBattleship(BATTLESHIP_LENGTH);
            inputBattleship(SUBMARINE_CRUISER_LENGTH);
            inputBattleship(SUBMARINE_CRUISER_LENGTH);
            inputBattleship(DESTROYER_LENGTH);

            waitForEnter();
            isPlayerOne = !isPlayerOne;
            System.out.println(PLAYER_TWO_START);
            printBattlefield(battlefield_2);
            inputBattleship(AIRCRAFT_CARRIER_LENGTH);
            inputBattleship(BATTLESHIP_LENGTH);
            inputBattleship(SUBMARINE_CRUISER_LENGTH);
            inputBattleship(SUBMARINE_CRUISER_LENGTH);
            inputBattleship(DESTROYER_LENGTH);

            goToAnotherPlayer();

            handleShots();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleShots() {
        boolean isFinished = false;
        while (!isFinished) {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

                String input = reader.readLine();
                input = input.trim();

                int inputX = getValueFromYCoordinate(input.charAt(0));
                int inputY = Integer.valueOf(input.substring(1));

                if (inputX < 1 || inputX > 10 || inputY < 1 || inputY > 10) {
                    System.out.println(WRONG_COORDINATES);
                    continue;
                }

                String currentPositionValue = isPlayerOne ? battlefield_2[inputX][inputY] : battlefield[inputX][inputY];
                boolean isHit = false;
                if (currentPositionValue.equals(FIELD)) {
                    if (isPlayerOne) {
                        battlefield_2[inputX][inputY] = MISS;
                    } else {
                        battlefield[inputX][inputY] = MISS;
                    }
                } else if (currentPositionValue.equals(SHIP)) {
                    if (isPlayerOne) {
                        battlefield_2[inputX][inputY] = HIT;
                        hitsCounter--;
                    } else {
                        battlefield[inputX][inputY] = HIT;
                        hitsCounter2--;
                    }

                    isHit = true;
                }
                if (isHit) {
                    if ((isPlayerOne ? hitsCounter : hitsCounter2) == 0) {
                        System.out.println(ALL_SHIPS_SINKED);
                        isFinished = true;
                    } else {
                        if (checkIfLastCellOfShip(inputX, inputY, (isPlayerOne ? battlefield : battlefield_2))) {
                            System.out.println(SHIP_SINKED);
                        } else {
                            System.out.println(HIT_SHIP);
                        }
                    }
                } else {
                    System.out.println(MISSED);
                }

                goToAnotherPlayer();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void inputBattleship(int length) throws IOException {
        boolean isFinished = false;
        System.out.printf(INPUT_REQUEST, BattleshipTypes.get(length), length);
        while (!isFinished) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {

                String input = reader.readLine();
                input = input.trim();
                if (input == null || input.isEmpty()) {
                    System.out.print(EMPTY_INPUT);
                    continue;
                }
                String[] words = input.split("\\s+");
                if (words.length < 2) {
                    System.out.print(BAD_INPUT);
                    continue;
                }

                if (words[0].charAt(0) == words[1].charAt(0)) {
                    processVertical(words, length);
                } else if (words[0].charAt(1) == words[1].charAt(1)) {
                    processHorizontal(words, length);
                } else {
                    System.out.print(WRONG_LOCATION);
                    continue;
                }
                isFinished = true;
            } catch (RuntimeException e) {
                System.out.print(e.getMessage());
            }
        }
        printBattlefield(isPlayerOne ? battlefield : battlefield_2);
    }


    public static void processVertical(String[] words, int length) {
        int xColumn = words[0].charAt(0) - 64;

        int startingPoint = Integer.valueOf(words[0].substring(1));
        int endingPoint = Integer.valueOf(words[1].substring(1));

        if (endingPoint < startingPoint) {
            startingPoint = Integer.valueOf(words[1].substring(1));
            endingPoint = Integer.valueOf(words[0].substring(1));
        }
        int inputLength = (endingPoint - startingPoint) + 1;

        if (inputLength != length) {
            throw new RuntimeException(String.format(WRONG_LENGTH, BattleshipTypes.get(length)));
        }
        checkAdjacentPositions(xColumn, startingPoint, endingPoint, isPlayerOne ? battlefield : battlefield_2, false);
        for (int i = startingPoint; i <= endingPoint; i++) {
            if (isPlayerOne) {
                battlefield[xColumn][i] = SHIP;
            } else {
                battlefield_2[xColumn][i] = SHIP;
            }
        }
    }


    public static void processHorizontal(String[] words, int length) throws RuntimeException {

        int yColumn = Integer.valueOf(words[0].substring(1));

        int startingPoint = getValueFromYCoordinate(words[0].charAt(0));
        int endingPoint = getValueFromYCoordinate(words[1].charAt(0));
        if (endingPoint < startingPoint) {
            startingPoint = getValueFromYCoordinate(words[1].charAt(0));
            endingPoint = getValueFromYCoordinate(words[0].charAt(0));
        }
        int inputLength = endingPoint - startingPoint + 1;
        if (inputLength != length) {
            throw new RuntimeException(String.format(WRONG_LENGTH, BattleshipTypes.get(length)));
        }
        checkAdjacentPositions(yColumn, startingPoint, endingPoint, isPlayerOne ? battlefield : battlefield_2, true);
        for (int i = startingPoint; i <= endingPoint; i++) {
            if (isPlayerOne) {
                battlefield[i][yColumn] = SHIP;
            } else {
                battlefield_2[i][yColumn] = SHIP;
            }
        }
    }

    public static void waitForEnter() {
        System.out.print("\n" + GO_TO_OTHER_PLAYER);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("...");
    }

    public static void goToAnotherPlayer() {
        isPlayerOne = !isPlayerOne;
        waitForEnter();
        printBattlefield(fogOfWar);
        System.out.println("---------------------");
        printBattlefield(isPlayerOne ? battlefield : battlefield_2);
        System.out.println(isPlayerOne ? PLAYER_ONE_TURN : PLAYER_TWO_TURN);
    }

}
