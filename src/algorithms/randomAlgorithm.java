package algorithms;

import grid.*;
import main.BlockType;
import java.util.Random;

public class RandomAlgorithm implements ICircleAlgorithm {

    @Override
    public IGrid<BlockType> getGrid(int diameter) {
        IGrid<BlockType> grid = new Grid(diameter, diameter);
        Random r = new Random();

        for (GridCell<BlockType> c : grid) {
            if (r.nextInt(2) == 1){
                grid.set(c.pos(), BlockType.BLOCK);
            }
        }

        return grid;
    }

    @Override
    public String toString() {
        return "random";
    }
    
}
