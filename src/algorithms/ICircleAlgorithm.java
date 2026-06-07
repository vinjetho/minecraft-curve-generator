package algorithms;

import grid.IGrid;
import main.BlockType;

public interface ICircleAlgorithm {

    public IGrid<BlockType> getGrid(int diameter);

}
