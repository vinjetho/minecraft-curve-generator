package algorithms;

import grid.IGrid;
import swag.BlockType;

public interface ICircleAlgorithm {

    public IGrid<BlockType> getGrid(int diameter);

}
