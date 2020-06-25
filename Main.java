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

    public static void main(String[] args) {
        getInput();
        printBoard();
    }
}