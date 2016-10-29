public class Board {
    Unit[][] spaces;

    public Board() {
        spaces = new Unit[7][5];
    }

    public void addUnit(Unit unit, int x, int y) {
        spaces[x][y] = unit;
    }

    public void killUnit(int x, int y) {
        // resolve on-death trigger
        spaces[x][y] = null;
    }

    public Unit[][] getSpaces() {
        return spaces;
    }
}