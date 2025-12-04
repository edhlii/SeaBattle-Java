import java.util.List;

public class Ship {
    private String name;
    private int size;
    private int hits;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.hits = 0;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }
}
