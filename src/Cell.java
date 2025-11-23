public class Cell {
    private Position position;
    private boolean hasShip;
    private CellState currentState;
    private Ship shipRef;

    public Cell(){
        this.currentState = CellState.EMPTY;
        this.hasShip = false;
        this.position = new Position(0,0);
    }

    public Cell(Position position, boolean hasShip, CellState currentState, Ship shipRef) {
        this.position = position;
        this.hasShip = hasShip;
        this.currentState = currentState;
        this.shipRef = shipRef;
    }

    public CellState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(CellState currentState) {
        this.currentState = currentState;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isHasShip() {
        return hasShip;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public Ship getShipRef() {
        return shipRef;
    }

    public void setShipRef(Ship shipRef) {
        this.shipRef = shipRef;
    }
}
