import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private Board ownBoard;
    private Board trackingBoard;
    private List<Ship> ships;
    private int totalShipCells;

    public Player(String name, int gridSize) {
        this.name = name;
        this.ownBoard = new Board(gridSize);
        this.trackingBoard = new Board(gridSize);
        this.ships = new ArrayList<>();
        this.totalShipCells = 0;
    }

    public String getName() {
        return name;
    }

    public Board getOwnBoard() {
        return ownBoard;
    }

    public Board getTrackingBoard() {
        return trackingBoard;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
        totalShipCells += ship.getSize();
    }

    public void decrementShipCells() {
        totalShipCells--;
    }

    public int getRemainingShipCells() {
        return totalShipCells;
    }

    public boolean hasLost() {
        return totalShipCells <= 0;
    }

    public void displaySideBySide(Player opponent) {
        System.out.println("YOUR GRID | OPPONENT'S GRID");
//        System.out.println("  0   1  2  3   4  5  6  7   8  9          0   1  2  3   4  5  6  7   8  9");

        for (int i = 0; i < ownBoard.getBoardSize(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < ownBoard.getBoardSize(); j++) {
                System.out.print(ownBoard.getCell(i, j) + " ");
            }
            System.out.print("      " + i + " ");
            for (int j = 0; j < trackingBoard.getBoardSize(); j++) {
                System.out.print(trackingBoard.getCell(i, j) + " ");
            }
            System.out.println();
        }

        System.out.println("\nYour ships: " + totalShipCells + " | Opponent ships: " + opponent.getRemainingShipCells());
    }
}