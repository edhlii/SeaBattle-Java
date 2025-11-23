class BattlePhase {
    private InputHandler input;

    public BattlePhase(InputHandler input) {
        this.input = input;
    }

    public void startBattle(Player player1, Player player2) {
        Player currentPlayer = player1;
        Player opponent = player2;

        while (!player1.hasLost() && !player2.hasLost()) {
            takeTurn(currentPlayer, opponent);

            if (opponent.hasLost()) {
                Display.showWinner(currentPlayer.getName());
                input.waitForEnter("\nPress Enter to return to main menu...");
                break;
            }

            // Switch players
            Player temp = currentPlayer;
            currentPlayer = opponent;
            opponent = temp;
        }
    }

    private void takeTurn(Player attacker, Player defender) {
        Display.clearScreen();
        System.out.println("=== " + attacker.getName() + "'s Turn ===\n");
        System.out.println("Other player, please look away!\n");

        attacker.displaySideBySide(defender);

        int row, col;
        while (true) {
            System.out.println("\nEnter target coordinates:");
            row = input.readInt("Row (0-9): ", 0, 9);
            col = input.readInt("Column (0-9): ", 0, 9);

            if (attacker.getTrackingBoard().isAlreadyFired(row, col)) {
                System.out.println("\nYou already fired at this location! Try again.");
                input.waitForEnter("\nPress Enter to continue...");
            } else {
                break;
            }
        }

        processShot(attacker, defender, row, col);
        input.waitForEnter("\nPress Enter to continue...");
    }

    private void processShot(Player attacker, Player defender, int row, int col) {
        if (defender.getOwnBoard().hasShipAt(row, col)) {
            System.out.println("\n💥 HIT! 💥");
            defender.getOwnBoard().setCell(row, col, Board.getHitChar());
            attacker.getTrackingBoard().setCell(row, col, Board.getHitChar());
            defender.decrementShipCells();
        } else {
            System.out.println("\n💦 MISS! 💦");
            attacker.getTrackingBoard().setCell(row, col, Board.getMissChar());
        }
    }
}