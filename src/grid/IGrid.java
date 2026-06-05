package grid;

public interface IGrid<T> extends GridDimension, Iterable<GridCell<T>>{
    
    /**
     * sets the value of a certain position in the grid
     * @param pos which position to change
     * @param value the value to change it to
     */
    public void set(CellPosition pos, T value);

    /**
     * 
     * @param pos the position to get from
     * @return the value at pos
     */
    public T get(CellPosition pos);

    /**
     * 
     * @param pos the position to check
     * @return true if the position is inside the grid, false if not
     */
    public boolean positionIsInBounds(CellPosition pos);

}
