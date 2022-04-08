public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.printGrid();
        for (Ships ships : Ships.values()) {
            player.placingShip(ships, false);
            player.printGrid();
        }

    }
}
