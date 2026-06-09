package algorithms;

import grid.Grid;
import grid.IGrid;
import swag.BlockType;

public class EmptyAlgorithm implements ICircleAlgorithm {

    @Override
    public IGrid<BlockType> getGrid(int diameter) {
        return new Grid<BlockType>(diameter, diameter);
    }
    
    @Override
    public String toString() {
        return "empty";
    }
}
