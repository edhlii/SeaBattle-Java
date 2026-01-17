import java.util.Random;

public class Board {
    private int gridSize;
    private static final String WATER = "🌊";
    private static final String SHIP = "🚢";
    private static final String HIT = "💥";
    private static final String MISS = "🥀";
    private Random random;

    private String[][] cells;

    public Board(int gridSize) {
        this.gridSize = gridSize;
        random = new Random();
        cells = new String[gridSize][gridSize];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                cells[i][j] = WATER;
            }
        }
    }

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, String value) {
        cells[row][col] = value;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public boolean canPlaceShip(int row, int col, int size, char direction) {
        if (direction == 'H') {
            if (col + size > gridSize) return false;
            for (int i = 0; i < size; i++) {
                if (cells[row][col + i] != WATER) return false;
            }
        } else if (direction == 'V') {
            if (row + size > gridSize) return false;
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

    public void placeShipsRandomly() {
        // Reset board first to ensure clean slate
        initialize();

        int[] shipSizes = {5, 4, 3, 3, 2};

        for (int size : shipSizes) {
            boolean placed = false;
            while (!placed) {
                int row = random.nextInt(gridSize);
                int col = random.nextInt(gridSize);
                // Randomly pick 0 or 1, map to Horizontal or Vertical
                char direction = random.nextBoolean() ? 'H' : 'V';

                if (canPlaceShip(row, col, size, direction)) {
                    placeShip(row, col, size, direction);
                    placed = true;
                }
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
        for (int i = 0; i < gridSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < gridSize; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < gridSize; j++) {
                if (!showShips && cells[i][j] == SHIP) {
                    System.out.print(WATER);
                } else {
                    System.out.print(cells[i][j]);
                }
            }
            System.out.println();
        }
    }

    public int getBoardSize() {
        return gridSize;
    }

    public static String getHitChar() {
        return HIT;
    }

    public static String getMissChar() {
        return MISS;
    }
}
