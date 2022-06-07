public class Main {
    public static void main(String[] args) {
        Player playerOne = new Player();

        System.out.println("Player 1, place your ships on the game field");             //Player 1 placing ships
        playerOne.printGrid(playerOne.board);
        for (Ships ships : Ships.values()) {
            playerOne.placingShip(ships, false);
            System.out.println();
            playerOne.printGrid(playerOne.board);
        }
        playerOne.placingShip(Ships.CRUISER, false);

        nextTurn();

        Player playerTwo = new Player();                                                //Player 2 placing ships

        System.out.println("Player 2, place your ships on the game field");
        playerTwo.printGrid(playerTwo.board);
        for (Ships ships : Ships.values()) {
            playerTwo.placingShip(ships, false);
            System.out.println();
            playerTwo.printGrid(playerTwo.board);
        }
        playerTwo.placingShip(Ships.CRUISER, false);
        nextTurn();

        do {
            playerOne.printGrid(playerTwo.fog);
            System.out.println("----------------------");
            playerOne.printGrid(playerOne.board);
            System.out.println("Player 1, it's your turn:");
            playerOne.shot(playerTwo.board, playerTwo.fog, playerTwo);
            if(playerTwo.isGameOver()) {
                break;
            }
            nextTurn();
            playerTwo.printGrid(playerOne.fog);
            System.out.println("----------------------");
            playerTwo.printGrid(playerTwo.board);
            System.out.println("Player 2, it's your turn:");
            playerTwo.shot(playerOne.board, playerOne.fog, playerOne);
            nextTurn();
        } while (!playerOne.isGameOver() || !playerTwo.isGameOver());

        System.out.println("You sank the last ship. You won. Congratulations!");


    }
    static void nextTurn() {
        System.out.println("Press Enter and pass the move to another player \n");
        try{
            System.in.read();               //Pressing Enter
        } catch(Exception e) { }
    }
}