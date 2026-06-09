package swag;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import algorithms.*;
import grid.*;

public class View extends JPanel{

    private Model model;

    
    private JButton cornerButton;
    private JButton drawButton;
    private JSpinner spinner1;
    private JComboBox algorithmBox;

    public View(Model model){
        this.model = model;
        this.setPreferredSize(new Dimension(1000,700));

        
        cornerButton = new JButton("i am in the corner");
        add(cornerButton);
        
        drawButton = new JButton("Draw");
        add(drawButton);

        spinner1 = new JSpinner();
        spinner1.setPreferredSize(new Dimension(100, 30));
        add(spinner1);
        spinner1.setValue(10);

        algorithmBox = new JComboBox<ICircleAlgorithm>();
        algorithmBox.setPreferredSize(new Dimension(200,30));
        algorithmBox.addItem(new IntersectionAlgorithm()); 
        algorithmBox.addItem(new Bresenham()); 
        algorithmBox.addItem(new BadAlgorithm()); 
        algorithmBox.addItem(new RandomAlgorithm()); 
        algorithmBox.addItem(new EmptyAlgorithm()); 
        add(algorithmBox);

    }

    public JButton getDrawButton(){
        return drawButton;
    }

    public int getSpinnerValue(){
        //dont really know if this is ok to typecast
        return (int) spinner1.getValue();
    }

    public ICircleAlgorithm getAlgorithm(){
        //dont really know if this is ok to typecast
        return (ICircleAlgorithm) algorithmBox.getSelectedItem();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //setup defaults
        g2.setFont(new Font("Times New Roman", 1, 20));
        g2.setColor(new Color(128,128,128));
        
        drawUI(g2);
        drawDisplay(g2);
        
    }
    
    private void drawUI(Graphics2D g2){
        
        //buttons
        cornerButton.setBounds(getWidth()-151,1,150,25);
        drawButton.setBounds(10,10,100,30);
        
        //Diamater spinner
        g2.setColor(new Color(0,0,0));
        g2.drawString("Diameter:", 10, 100);
        spinner1.setBounds(new Rectangle(new Point(10,105), spinner1.getPreferredSize()));
        
        //algorithm dropdown
        g2.drawString("Algorithm:", 10, 195);
        algorithmBox.setBounds(new Rectangle(new Point(10, 200), algorithmBox.getPreferredSize()));

    }
    
    private void drawDisplay(Graphics2D g2){
        //Display area background
        int size = Math.min(getWidth()-130, getHeight()-20);
        int cornerX = getWidth()-size-10;
        int cornerY = 10;
        int spinnerValue = (int) spinner1.getValue();

        g2.setColor(new Color(128,128,128));
        g2.fillRect(cornerX, cornerY, size, size);
        
        
        //actual grid
        g2.setColor(new Color(255,255,255));
        
        IGrid<BlockType> grid = model.getGrid();

        int outerMargin = 5; 
        int cellSize = (size-(outerMargin*2))/Math.max(1,grid.rows());
        int roundingError = (size-(outerMargin*2))-(cellSize*grid.rows());
        int totalMargin = outerMargin + roundingError / 2;
        
        for (GridCell<BlockType> c : grid){
            //TODO: add colorscheme functionality
            Rectangle cellBounds = new Rectangle(cornerX + (c.pos().col()*cellSize) + totalMargin, cornerY + (c.pos().row()*cellSize) + totalMargin, cellSize, cellSize);
            if (c.value() != null){
                g2.setColor(new Color(0,0,255));
                g2.fill(cellBounds);
            }
            g2.setColor(new Color(255,255,255, 128));
            g2.draw(cellBounds);
        }

        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(255,0,0, 128));
        g2.drawOval(cornerX + totalMargin + cellSize/2, cornerY + totalMargin + cellSize/2, size - totalMargin*2 - cellSize, size - totalMargin*2 - cellSize);
        g2.drawLine(cornerX+totalMargin, cornerY+size/2, cornerX+size-totalMargin, cornerY+size/2);
        g2.drawLine(cornerX+size/2, cornerY+totalMargin, cornerX+size/2, cornerY+size-totalMargin);
        
    }
}
