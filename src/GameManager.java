
public class GameManager {
    private InputHandler input;
    private ShipPlacementPhase placementPhase;
    private BattlePhase battlePhase;

    public GameManager() {
        this.input = new InputHandler();
        this.placementPhase = new ShipPlacementPhase(input);
        this.battlePhase = new BattlePhase(input);
    }

    public void run() {
        while (true) {
            Display.showMainMenu();
            int choice = input.readInt("Choose an option: ", 1, 2);

            if (choice == 1) {
                startNewGame();
            } else {
                System.out.println("\nThanks for playing Sea Battle!");
                break;
            }
        }
        input.close();
    }

    private void startNewGame() {
        Display.clearScreen();
        System.out.println(Common.BLUE_ANSI + "=== SEABATTLE GAME SETUP ===\n" + Common.RESET_ANSI);

        String name1 = input.readLine("Enter Player 1 name: ");
        Player player1 = new Player(name1);

        String name2 = input.readLine("Enter Player 2 name: ");
        Player player2 = new Player(name2);

        placementPhase.placeShipsForPlayer(player1);
        placementPhase.placeShipsForPlayer(player2);

        battlePhase.startBattle(player1, player2);
    }
}