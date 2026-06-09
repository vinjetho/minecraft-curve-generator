package swag;
import algorithms.EmptyAlgorithm;
import algorithms.ICircleAlgorithm;
import grid.*;

public class Model {

    private int diameter;
    private IGrid<BlockType> grid;
    private ICircleAlgorithm algorithm;
    private boolean queuedUpdate;

    public Model() {
        this.diameter = 1;
        this.grid = new Grid<BlockType>(1,1);
        this.algorithm = new EmptyAlgorithm();
        this.queuedUpdate = true;
    }
    
    /**
     * 
     * @param newValue
     * @throws IllegalArgumentException if the new 
     */
    public void updateDiameter(int newValue){
        if (newValue < 1){
            throw new IllegalArgumentException("diameter has to be 1 or larger");
        } 
        else{
            this.diameter = newValue;
        } 
        queuedUpdate = true;
    }

    public void updateAlgorithm(ICircleAlgorithm newAlgorithm){
        if (newAlgorithm == null) {
            throw new IllegalArgumentException("algorithm can not be be null");
        } 
        else{
            this.algorithm = newAlgorithm;
        }
        queuedUpdate = true;
    }

    private void updateGrid(){
        grid = this.algorithm.getGrid(diameter);
        queuedUpdate = false;
    }

    //needs javadoc
    public IGrid<BlockType> getGrid(){
        if (queuedUpdate){
            updateGrid();
        }
        return grid;
    }

}
