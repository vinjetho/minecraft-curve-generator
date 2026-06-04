package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;


import javax.swing.JPanel;

public class View extends JPanel{

    private Model model;

    public View(Model model){
        this.model = model;

        this.setPreferredSize(new Dimension(1000,700));
    }

    @Override
      protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(new Color(128,100,200));
        g2.fillOval(0, 0, getWidth(), getHeight());
    }

}
