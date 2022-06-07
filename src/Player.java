class Player extends BoardGame {
    int remainingShips = 5;

    @Override
    protected void printGrid(String[][] board) {
        super.printGrid(board);
    }

    @Override
    protected String cordsInput() {
        return super.cordsInput();
    }

    protected void placingShip(Ships ship, boolean isShipSet) {
        System.out.println("Enter the coordinates of the " + ship.name + " (" + ship.cells +  " cells): \n");
        do {
            CordConverter cordConverter = new CordConverter(cordsInput());
            if (cordConverter.isCorrectLocation()) {
                if (cordConverter.isCorrectLength(ship)) {
                    if (cordConverter.isFar(ship, board)) {
                        if (cordConverter.isHorizontal()) {
                            for(int i = cordConverter.yBeginning; i <= cordConverter.yEnd; i++) {
                                board[cordConverter.xBeginning][i] = "O";
                                isShipSet = true;
                            }
                        } else if (!cordConverter.isHorizontal()) {
                            for(int i = cordConverter.xBeginning; i <= cordConverter.xEnd; i++) {
                                board[i][cordConverter.yBeginning] = "O";
                                isShipSet = true;
                            }

                        }
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again: ");
                    }
                } else {
                    System.out.println("Error! Wrong length of the " + ship.name + "! Try again:");
                }
            } else {
                System.out.println("Error! Wrong ship location! Try again: ");
            }
        }while (!isShipSet);

    }

    protected void shot(String[][] board, String[][] fog, Player player) {
        CordConverter cordConverter = new CordConverter(cordsInput());
        if ("O".equals(board[cordConverter.xBeginning][cordConverter.yBeginning])) {
            board[cordConverter.xBeginning][cordConverter.yBeginning] = "X";
            fog[cordConverter.xBeginning][cordConverter.yBeginning] = "X";
            //printGrid(fog); // Temporary for check
            if (isSunk(cordConverter.xBeginning, cordConverter.yBeginning, board)) {
                player.remainingShips -= 1;
                System.out.println("You sank a ship! \n");
            } else {
                System.out.println("You hit a ship! \n");
            }
        } else if ("~".equals(board[cordConverter.xBeginning][cordConverter.yBeginning]) || "M".equals(board[cordConverter.xBeginning][cordConverter.yBeginning])) {
            board[cordConverter.xBeginning][cordConverter.yBeginning] = "M";
            fog[cordConverter.xBeginning][cordConverter.yBeginning] = "M";
            //printGrid(fog);
            System.out.println("You missed! \n");
        } else if ("X".equals(board[cordConverter.xBeginning][cordConverter.yBeginning])) {
            //printGrid(fog);
            if (isSunk(cordConverter.xBeginning, cordConverter.yBeginning, board)) {                       //Just for repetitive moves, without sank ships counter
                System.out.println("You sank a ship! \n");
            } else {
                System.out.println("You hit a ship! \n");
            }
        }

    }

    protected boolean isHorizontal(int x, int y, String[][] board) {
        try {
           return  "~".equals(board[x - 1][y]) && "~".equals(board[x + 1][y]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return  "~".equals(board[x - 1][y]) || "~".equals(board[x + 1][y]);
        }
    }

    protected boolean isSunk (int x, int y, String[][] board) {
        try {
            if (isHorizontal(x, y, board)) {
                int i = 0;
                while(!"~".equals(board[x][y + i])) {
                   if ("O".equals(board[x][y + i])){
                       return false;
                   }
                   i++;
               }
                i = 0;
                while (!"~".equals(board[x][y - i])){
                    if ("O".equals(board[x][y - i])) {
                        return false;
                    }
                    i++;
                }
            } else {
                int i = 0;
                while(!"~".equals(board[x + i][y])) {
                    if ("O".equals(board[x + i][y])){
                        return false;
                    }
                    i++;
                }
                i = 0;
                while (!"~".equals(board[x - i][y])){
                    if ("O".equals(board[x - i][y])) {
                        return false;
                    }
                    i++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) { }
        return true;
    }

    protected boolean isGameOver () {
        return remainingShips == 0;
    }
}
