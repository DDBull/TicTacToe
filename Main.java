import java.util.*;

public class Main {
    private static char[][] board = new char[3][3];
    private static Scanner scan = new Scanner(System.in);

    private static void printBoard() {
        System.out.println("---------");
        
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    private static void getInput() {
        System.out.println("Enter cells: ");
        String s = scan.nextLine();

        int cur = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = s.charAt(cur++);
            }
        }
    }

    private static boolean checkIfWon(char ch) {
        if (board[0][0] == ch && board[0][1] == ch && board[0][2] == ch) return true;
        if (board[1][0] == ch && board[1][1] == ch && board[1][2] == ch) return true;
        if (board[2][0] == ch && board[2][1] == ch && board[2][2] == ch) return true;

        if (board[0][0] == ch && board[1][0] == ch && board[2][0] == ch) return true;
        if (board[0][1] == ch && board[1][1] == ch && board[2][1] == ch) return true;
        if (board[0][2] == ch && board[1][2] == ch && board[2][2] == ch) return true;

        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) return true;
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) return true;

        return false;
    }

    private static void analyzeBoard() {
        int x = 0;
        int o = 0;
        boolean xWin = checkIfWon('X');
        boolean oWin = checkIfWon('O');

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    x++;
                }
                if (board[i][j] == 'O') {
                    o++;
                }
            }
        }

        if (Math.abs(x - o) >= 2) {
            System.out.println("Impossible");
        } else 
        if (xWin && oWin) {
            System.out.println("Impossible");
        } else 
        if (xWin) {
            System.out.println("X wins");
        } else 
        if (oWin) {
            System.out.println("O wins");
        } else 
        if (x + o == 9) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }

    private static void playerNextMove() {
        int x;
        int y;

        try {
            System.out.println("Enter the coordinates: ");
            y = scan.nextInt();
            x = scan.nextInt();

            if (!(x >= 1 && x <= 3 && y >= 1 && y <= 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
                playerNextMove();
            } else {
                x = 3 - x;
                y = y - 1;

                if (board[x][y] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                    playerNextMove();
                } else {
                    board[x][y] = 'X';
                }
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            playerNextMove();
        }
    }

    public static void main(String[] args) {
        getInput();
        printBoard();
        playerNextMove();
        //analyzeBoard();
        printBoard();
    }
}
