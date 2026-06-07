package main;

import algorithms.ICircleAlgorithm;
import algorithms.emptyAlgorithm;
import grid.*;

public class Model {

    private int diameter;
    private IGrid<BlockType> grid;
    private ICircleAlgorithm algorithm;

    public Model() {
        this.diameter = 1;
        this.grid = new Grid<BlockType>(1,1);
        this.algorithm = new emptyAlgorithm();
    }
    
    //needs javadoc
    public void updateDiameter(int newValue){
        if (newValue >= 1){
            this.diameter = newValue;
        } else {
            throw new IllegalArgumentException("diameter has to be 1 or larger");
        } 
    }

    public void updateAlgorithm(ICircleAlgorithm newAlgorithm){
        if (newAlgorithm == null) {
            throw new IllegalArgumentException("algorithm can not be be null");
        } else {
            this.algorithm = newAlgorithm;
        }
    }

    private void updateGrid(){
        grid = this.algorithm.getGrid(diameter);
    }

    //needs javadoc
    public IGrid<BlockType> getGrid(){
        updateGrid();
        return grid;
    }

}
