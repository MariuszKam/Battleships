public class CordConverter {
    String cords;
    int xBeginning;
    int yBeginning;
    int xEnd;
    int yEnd;


    public CordConverter (String cords) { //Constructor
        this.cords = cords;
        this.xBeginning = numberConverter(separateCords(cords)[0]);
        this.yBeginning = Math.min(getNumber(separateCords(cords)[0]), getNumber(separateCords(cords)[1]));
        this.xEnd = numberConverter(separateCords(cords)[1]);
        this.yEnd = Math.max(getNumber(separateCords(cords)[0]), getNumber(separateCords(cords)[1]));
    }

    protected boolean isCorrectLocation() {
        return xBeginning == xEnd || yBeginning == yEnd;
    }

    protected boolean isCorrectLength(Ships ship) {
        return xEnd - xBeginning + 1 == ship.cells || yEnd - yBeginning + 1 == ship.cells;
    }

    protected boolean isHorizontal() {
        return xBeginning == xEnd;
    }

    protected boolean isFar(Ships ship, String[][] board) {
        for (int i = -1; i < ship.cells + 1; i++) {
            for (int j = -1; j < 2; j++) {
                if (isHorizontal()) {
                    try {
                        if ("O".equals(board[xBeginning + j][yBeginning + i])) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) { }
                } else {
                    try {
                        if("O".equals(board[xBeginning + i][yBeginning + j])) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) { }
                }
            }
        }
        return true;
    }

    private String[] separateCords(String cords) {
        return cords.split("\\s");
    }

    private int numberConverter(String cords) {
        char letter = cords.charAt(0);
        if (letter == 'A') {
            return 1;
        } else if (letter == 'B') {
            return 2;
        } else if (letter == 'C') {
            return 3;
        } else if (letter == 'D') {
            return 4;
        } else if (letter == 'E') {
            return 5;
        } else if (letter == 'F') {
            return 6;
        } else if (letter == 'G') {
            return 7;
        } else if (letter == 'H') {
            return 8;
        } else if (letter == 'I') {
            return 9;
        } else if (letter == 'J') {
            return 10;
        } else {
            return 0;
        }

    }

    private int getNumber(String cords) {
        cords = cords.replaceAll("\\D", "");
        return Integer.parseInt(cords);
    }
}
