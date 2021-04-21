import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameXO {

    private static final char DEFAULT = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final int SIZE = 3;
    private static int NUMBER_STEP = 0;

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DEFAULT;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isCellValid(int x, int y) {
        boolean isInMap = x > 0 && x <= SIZE && y > 0 && y <= SIZE;
        return isInMap && MAP[x - 1][y - 1] == DEFAULT;
    }

    private static void makeStep(int x, int y, char value) {
        NUMBER_STEP ++;
        MAP[x - 1][y - 1] = value;
    }

    private static void moveAI() {
        NUMBER_STEP ++;
        int count = 0;
        for (int j = 0; j < SIZE; j++) {
            int diagonal1 = 0, diagonal2 = 0;
            for (int i = 0; i < SIZE; i ++) {
                if (MAP[i][i] == DOT_X) {
                    diagonal1 ++;
                }
                if (MAP[i][SIZE - i - 1] == DOT_X) {
                    diagonal2 ++;
                }
            }
            if (diagonal1 >= 2 && count == 0) {
                for (int k = 0; k < SIZE; k++) {
                    if (MAP[k][k] == DEFAULT && count == 0) {
                        MAP[k][k] = DOT_O;
                        count ++;
                    }
                }
            } else if (diagonal2 >= 2 && count == 0) {
                for (int k = 0; k < SIZE; k++) {
                    if (MAP[k][SIZE - k - 1] == DEFAULT && count == 0) {
                        MAP[k][SIZE - k - 1] = DOT_O;
                        count ++;
                    }
                }
            } else if ((MAP[0][0] == DOT_X && MAP[SIZE - 1][SIZE - 1] == DOT_X) || (MAP[0][SIZE - 1] == DOT_X && MAP[SIZE - 1][0] == DOT_X) && count == 0) {
                if ( MAP[1][1] == DEFAULT) {
                    MAP[1][1] = DOT_O;
                    count++;
                }
            }
        }
        if (count == 0) {
            int hor1, vert1;
            for (int i = 0; i < SIZE; i++) {
                hor1 = 0;
                vert1 = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (MAP[i][j] == DOT_X) { hor1 ++;}
                    if (MAP[j][i] == DOT_X) {vert1 ++ ;}
                }
                if (hor1 >= 2 && count == 0) {
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[i][k] == DEFAULT) {
                            MAP[i][k] = DOT_O;
                            count ++;
                        }
                    }
                }
                if (vert1 >= 2 && count == 0) {
                    for (int k = 0; k < SIZE; k++) {
                        if (MAP[k][i] == DEFAULT) {
                            MAP[k][i] = DOT_O;
                            count ++;
                        }
                    }
                }
            }
        }

        if (count == 0) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                   if (MAP[i][j] == DEFAULT) {
                      MAP[i][j] = DOT_O;
                     return;
                     }
                 }
             }
        }
    }

    private static void aiAwait() {
        for (int i = 0; i < 10; i++) {
            System.out.print(" * ");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    private static boolean checkDiagonals(char dot) {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < SIZE; i ++) {
            diag1 &= (MAP[i][i] == dot);
            diag2 &= (MAP[SIZE - i - 1][i] == dot);
        }
        return (diag1 || diag2);
    }

    private static boolean checklines(char dot) {
        boolean hor, vert;
        for (int i = 0; i < SIZE; i ++) {
            hor = true;
            vert = true;
            for (int j = 0; j < SIZE; j++) {
                hor &= (MAP[i][j] == dot);
                vert &= (MAP[j][i] == dot);
            }
            if (hor || vert) return true;
        }
        return false;
    }

    private static int isWin(int NUMBER_STEP) {
        if (NUMBER_STEP >= 3) {
           if (checkDiagonals(DOT_X)) return 1;
           if (checklines(DOT_X)) return 1;
           if (checkDiagonals(DOT_O)) return 2;
           if (checklines(DOT_O)) return 2;
        }
        return 0;
    }

    private static void startGame() {
        NUMBER_STEP = 0;
        initMap();
        System.out.println("Вы в игре крестики и нолики.");
        System.out.println("Для победы необходимо собрать три крестика подряд.");
        System.out.println("Для того, чтобы сделать ход, введите\n2 целых числа от 1 до 3 - номер строки и номер " +
                "столбца...");
        printMap();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Делайте ваш ход:");
            String[] values = in.nextLine().split(" ");
            if (values.length != 2) {
                System.out.println("Вы ввели некорректные данные.\nВведите ровно два числа от 1 до 3!");
                continue;
            }
            try {
                int x = Integer.parseInt(values[0]);
                int y = Integer.parseInt(values[1]);
                if (isCellValid(x, y)) {
                    makeStep(x, y, DOT_X);
                    if (isWin(NUMBER_STEP) == 1) {
                        printMap();
                        System.out.println("Вы победили");
                        showEndGameDialog(in);
                        break;
                    }
                    if (NUMBER_STEP == 9) {
                        printMap();
                        System.out.println("Ничья!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                    System.out.println("Ход компьютера:");
                    aiAwait();
                    moveAI();
                    if (isWin(NUMBER_STEP) == 2) {
                        printMap();
                        System.out.println("Вы проиграли");
                        showEndGameDialog(in);
                        break;
                    }
                    if (NUMBER_STEP == 9) {
                        printMap();
                        System.out.println("Ничья!");
                        showEndGameDialog(in);
                        break;
                    }
                    printMap();
                } else {
                    System.out.println("Невозможно сделать такой ход! Введите другие значения");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные данные.\nДанные должны быть числами от 1 до 3");
            }
        }
    }

    private static void showEndGameDialog(Scanner in) {
        System.out.println("1. Начать новую игру");
        System.out.println("Для выхода введите любую другую клавишу");

        System.out.println("Введите команду...");
        String command = in.next();
        if (command.equals("1")) {
            startGame();
            return;
        }
        System.out.println("Игра завершена!");

    }

    public static void main(String[] args) {
        startGame();
    }


}
