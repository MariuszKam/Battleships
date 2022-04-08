abstract class BoardGame {
    protected final String[][] board = new String[11][11];

    public BoardGame() {
        board[0][0] = " ";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i == 0) {
                    board[i][j] = Integer.toString(j);

                }else if (j == 0) {
                    char c = (char) (64 + i);
                    board[i][j] = String.valueOf(c);
                } else {
                    board[i][j] = "~";
                }
            }
        }
        board[0][0] = " ";
    }

    protected void printGrid() {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
