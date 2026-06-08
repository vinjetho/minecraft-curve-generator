package algorithms;

import java.util.ArrayList;

import grid.*;
import main.BlockType;

public class bresenham implements ICircleAlgorithm {

    @Override
    public IGrid<BlockType> getGrid(int diameter) {
        
        IGrid<BlockType> grid = new Grid(diameter, diameter);
        
        //starting values
        float xShift = ((diameter + 1) % 2) / 2f;
        float r = (diameter-1)/2f;
        float x = 0 + xShift;
        float y = r;
        float d = 3 - (2*r);
        addToGrid(x, y, grid, r, xShift);
        
        //algorithm
        while (x < y) {
            if (d < 0){
                d = d + (4 * x) + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
            addToGrid(x, y, grid, r, xShift);
        }

        return grid;

    }

    private void addToGrid(float xR, float yR, IGrid<BlockType> grid, float r, float xShift){
        
        int d = grid.cols()-1;
        int x = Math.round(-yR+r);
        int y = Math.round(xR-xShift+r);

        ArrayList<CellPosition> octants = new ArrayList<>();

        octants.add(new CellPosition(x,y));
        octants.add(new CellPosition(d-x, y));
        octants.add(new CellPosition(x, d-y));
        octants.add(new CellPosition(d-x, d-y));
        octants.add(new CellPosition(y,x));
        octants.add(new CellPosition(d-y,x));
        octants.add(new CellPosition(y,d-x));
        octants.add(new CellPosition(d-y,d-x));

        for (CellPosition p : octants) {
            if (grid.positionIsInBounds(p)) {
                grid.set(p, BlockType.BLOCK);
            }
        }

    }

    @Override
    public String toString() {
        return "bresenham";
    }

}
