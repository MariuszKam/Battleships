import java.util.Scanner;

abstract class BoardGame {
    protected final String[][] board = new String[11][11];
    protected final String[][] fog = new String[11][11];

    public BoardGame() {
        board[0][0] = fog[0][0] = " ";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i == 0) {
                    board[i][j] = fog[i][j] = Integer.toString(j);
                }else if (j == 0) {
                    char c = (char) (64 + i);
                    board[i][j] = fog[i][j] = String.valueOf(c);
                } else {
                    board[i][j] = fog[i][j] = "~";
                }
            }
        }
        board[0][0] = fog[0][0] = " ";
    }

    protected void printGrid(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    protected String cordsInput() {
        String cords;
        boolean correct = false;
        do {
            cords = new Scanner(System.in).nextLine();
            cords = cords.toUpperCase();
            if (!cords.matches("^([A-J][1-9][0]? [A-J][1-9][0]?|[A-J][1-9][0]?)$")) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            } else {
                correct = true;
            }
        } while (!correct);
        return cords;
    }

}
