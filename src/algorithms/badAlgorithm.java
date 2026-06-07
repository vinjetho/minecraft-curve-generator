package algorithms;

import grid.*;
import main.BlockType;

public class badAlgorithm implements ICircleAlgorithm {

    @Override
    public IGrid<BlockType> getGrid(int diameter) {
        IGrid<BlockType> grid = new Grid(diameter, diameter);

        double r = diameter/2;
        for (GridCell<BlockType> c : grid){
            double x = c.pos().col() - r;
            double y = r - c.pos().row();
            
            if (Math.pow(x,2) + Math.pow(y,2) == Math.pow(r,2)) {
                grid.set(c.pos(), BlockType.BLOCK);
            }
        }

        return grid;
    }
    
    @Override
    public String toString() {
        return "bad";
    }
}
