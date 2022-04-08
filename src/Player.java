import java.util.Scanner;

class Player extends BoardGame {
    @Override
    protected void printGrid() {
        super.printGrid();
    }

    protected void placingShip(Ships ship, boolean isShipSet) {
            do {
                System.out.println("Enter the coordinates of the " + ship.name + " (" + ship.cells +  " cells): ");
                String cords = new Scanner(System.in).nextLine();
                CordConverter cordConverter = new CordConverter(cords);
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
}
