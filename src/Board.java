public class Board {
    private static final int GRID_SIZE = 10;
    private static final char WATER = '~';
    private static final char SHIP = 'S';
    private static final char HIT = 'X';
    private static final char MISS = 'O';

    private char[][] cells;

    public Board() {
        cells = new char[GRID_SIZE][GRID_SIZE];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cells[i][j] = WATER;
            }
        }
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, char value) {
        cells[row][col] = value;
    }

    public boolean canPlaceShip(int row, int col, int size, char direction) {
        if (direction == 'H') {
            if (col + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (cells[row][col + i] != WATER) return false;
            }
        } else if (direction == 'V') {
            if (row + size > GRID_SIZE) return false;
            for (int i = 0; i < size; i++) {
                if (cells[row + i][col] != WATER) return false;
            }
        } else {
            return false;
        }
        return true;
    }

    public void placeShip(int row, int col, int size, char direction) {
        if (direction == 'H') {
            for (int i = 0; i < size; i++) {
                cells[row][col + i] = SHIP;
            }
        } else {
            for (int i = 0; i < size; i++) {
                cells[row + i][col] = SHIP;
            }
        }
    }

    public boolean hasShipAt(int row, int col) {
        return cells[row][col] == SHIP;
    }

    public boolean isAlreadyFired(int row, int col) {
        return cells[row][col] == HIT || cells[row][col] == MISS;
    }

    public void display(String title, boolean showShips) {
        System.out.println("=== " + title + " ===\n");
        System.out.print("  ");
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!showShips && cells[i][j] == SHIP) {
                    System.out.print(WATER + " ");
                } else {
                    System.out.print(cells[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int getBoardSize() {
        return GRID_SIZE;
    }

    public static char getHitChar() {
        return HIT;
    }

    public static char getMissChar() {
        return MISS;
    }
}
