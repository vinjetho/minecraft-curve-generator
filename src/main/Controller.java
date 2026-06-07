package main;

import java.awt.event.ActionEvent;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.getDrawButton().addActionListener(e -> drawButtonPress(e));
    }
    
    private void drawButtonPress(ActionEvent event){
        model.updateDiameter(view.getSpinnerValue());
        model.updateAlgorithm(view.getAlgorithm());
        view.repaint();
    }

}
