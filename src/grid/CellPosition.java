package grid;

/** A CellPosition contains a row and a column. */
public record CellPosition(int row, int col) {

    /**
     * 
     * @param rows how many rows to shift by
     * @param cols how many collumns to shift by
     * @return a new CellPosition that has been shifted according to rows and cols
     */
    public CellPosition shifted(int rows, int cols){
        return new CellPosition(this.row+rows, this.col+cols);
    }
}
