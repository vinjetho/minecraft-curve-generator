package grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<T> implements IGrid<T>{

    private final List<List<T>> data;
	private final int cols;
	private final int rows;

	public Grid(int rows, int cols, T defaultValue) {
	    this.rows = rows;
	    this.cols = cols;
	    this.data = new ArrayList<List<T>>(rows);
	    
	    for (int i = 0; i < rows; i++) {
	      List<T> row = new ArrayList<>(cols);
	      for (int j = 0; j < cols; j++) {
	        row.add(defaultValue);
	      }
	      this.data.add(row);
	    }
	  }

	public Grid(int rows, int cols) {
	    this(rows, cols, null);
    }
    
    /**
	 * This method checks if a given Location is within the bounds of this grid.
	 * If it is not, an IndexOutOfBoundsException is thrown.
	 *
	 * @param pos the location to check
     * @throws IndexOutOfBoundsException if the position is out of bounds for the grid
	 */
	public void checkLocation(CellPosition pos) {
		if (!positionIsInBounds(pos)) {
			throw new IndexOutOfBoundsException("Row and column indices must be within bounds");
		}
	}

    @Override
	public boolean positionIsInBounds(CellPosition pos) {
		if (pos == null) {
			return false;
		}
		if (pos.row() < 0 || pos.row() >= rows) {
			return false;
		}

		return pos.col() >= 0 && pos.col() < cols;
	}

    @Override
    public T get(CellPosition pos) {
        checkLocation(pos);        
        return this.data.get(pos.row()).get(pos.col());
    }

    @Override
    public void set(CellPosition pos, T elem) {
        checkLocation(pos);            
        this.data.get(pos.row()).set(pos.col(), elem);
    }
    
    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int cols() {
        return cols;
    }

    @Override
    public Iterator<GridCell<T>> iterator() {
        return new RowWiseGridIterator<T>(this);
    }

    @Override
    //really bad toString() i know
    public String toString(){
        String str = "";
        for (GridCell<T> c : this) {
            str += "[";
            if (c.value() == null) {
                str += "null";
            } else {
                str += c.value().toString();
            }
            str += "]";
        }
        return str;
    }
}


class RowWiseGridIterator<T> implements Iterator<GridCell<T>> {

    private CellPosition next;
    private IGrid<T> grid;

    public RowWiseGridIterator(IGrid<T> grid) {
        this.next = new CellPosition(0,0);
        this.grid = grid;
    }

    @Override
    public boolean hasNext() {
        return grid.positionIsInBounds(next);
    }

    @Override
    public GridCell<T> next() {
        GridCell<T> cell = new GridCell<T>(next, grid.get(next));

        next = new CellPosition(next.row(), next.col()+1);
        if (!this.hasNext())
        next = new CellPosition(next.row()+1, 0);

        return cell;
    }
} 
