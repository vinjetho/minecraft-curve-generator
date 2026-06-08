package main;

import algorithms.ICircleAlgorithm;
import algorithms.emptyAlgorithm;
import grid.*;

public class Model {

    private int diameter;
    private IGrid<BlockType> grid;
    private ICircleAlgorithm algorithm;
    private boolean queueUpdate;

    public Model() {
        this.diameter = 1;
        this.grid = new Grid<BlockType>(1,1);
        this.algorithm = new emptyAlgorithm();
        this.queueUpdate = true;
    }
    
    //needs javadoc
    public void updateDiameter(int newValue){
        if (newValue < 1){
            throw new IllegalArgumentException("diameter has to be 1 or larger");
        } 
        else if (newValue != this.diameter) {
            this.diameter = newValue;
            queueUpdate = true;
        } 
    }

    public void updateAlgorithm(ICircleAlgorithm newAlgorithm){
        if (newAlgorithm == null) {
            throw new IllegalArgumentException("algorithm can not be be null");
        } 
        else if (!newAlgorithm.equals(this.algorithm)){
            this.algorithm = newAlgorithm;
            queueUpdate = true;
        }
    }

    private void updateGrid(){
        grid = this.algorithm.getGrid(diameter);
    }

    //needs javadoc
    public IGrid<BlockType> getGrid(){
        if (queueUpdate){
            updateGrid();
            queueUpdate = false;
        }
        return grid;
    }

}
