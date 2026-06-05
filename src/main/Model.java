package main;

import grid.*;
import misc.*;

public class Model {

    private int diameter;
    private IGrid<BlockType> grid;

    public Model() {
        this.diameter = 1;
        this.grid = new Grid<BlockType>(1,1);
    }
    
    //needs javadoc
    public void updateDiameter(int newValue){
        if (newValue >= 1){
            this.diameter = newValue;
        } else {
            throw new IllegalArgumentException("diameter has to be 1 or larger");
        } 
    }

    private void updateGrid(){
        grid = new Grid<BlockType>(diameter, diameter);
        // fill out the grid here
        
        //prøv å implementer breshenhams algorithm
        
        //jekk om sirkelen intersecte pixelen
        for (GridCell<BlockType> c : grid) {
            double r = (diameter-1) / 2;

            double ulX = c.pos().col() - r;
            double ulY = c.pos().row() - r;
            
            double urX = c.pos().col() - r;
            double urY = c.pos().row() - r;
            
            double brX = c.pos().col() - r;
            double brY = c.pos().row() - r;
            
            double blX = c.pos().col() - r;
            double blY = c.pos().row() - r;
        }

    }

    //needs javadoc
    public IGrid<BlockType> getGrid(){
        if (grid.cols() == diameter & diameter == grid.rows()) {
            return grid;
        } else {
            updateGrid();
            return grid;
        }
        
    }

}
