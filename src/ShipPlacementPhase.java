public class ShipPlacementPhase {
    private InputHandler input;
    private static final Ship[] SHIP_TEMPLATES = {
            new Ship("Carrier", 5),
            new Ship("Battleship", 4),
            new Ship("Cruiser", 3),
            new Ship("Submarine", 3),
            new Ship("Destroyer", 2)
    };

    public ShipPlacementPhase(InputHandler input) {
        this.input = input;
    }

    public void placeShipsForPlayer(Player player) {
        Display.clearScreen();
        System.out.println("=== " + player.getName() + "'s Ship Placement ===\n");
        System.out.println("Other player, please look away!\n");

        for (Ship template : SHIP_TEMPLATES) {
            Ship ship = new Ship(template.getName(), template.getSize());
            placeShip(player, ship);
            player.addShip(ship);
        }

        player.getOwnBoard().display(player.getName() + "'s Final Board", true);
        input.waitForEnter("\nAll ships placed! Press Enter to continue...");
    }

    private void placeShip(Player player, Ship ship) {
        boolean placed = false;
        while (!placed) {
            Display.clearScreen();
            player.getOwnBoard().display(player.getName() + "'s Board", true);
            System.out.println("\nPlacing: " + ship.getName() + " (" + ship.getSize() + ")");

            int row = input.readInt("Enter row (0-9): ", 0, 9);
            int col = input.readInt("Enter column (0-9): ", 0, 9);
            char direction = input.readChar("Horizontal or Vertical? (H/V): ");

            if (player.getOwnBoard().canPlaceShip(row, col, ship.getSize(), direction)) {
                player.getOwnBoard().placeShip(row, col, ship.getSize(), direction);
                placed = true;
            } else {
                System.out.println("\nInvalid placement! Try again.");
                input.waitForEnter("\nPress Enter to continue...");
            }
        }
    }
}