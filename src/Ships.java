public enum Ships {
    AIRCRAFT("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine",3),
    CRUISER("Cruiser",3),
    DESTROYER("Destroyer",2);

    String name;
    int cells;

    Ships (String name, int cells) {
        this.name = name;
        this.cells = cells;
    }
}
