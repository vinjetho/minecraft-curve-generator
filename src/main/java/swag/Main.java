package swag;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello, World!");

        Model model = new Model();
        View view = new View(model);
        new Controller(model, view);
        
        //weird patchy solution
        model.updateDiameter(view.getSpinnerValue());
        view.repaint();

        JFrame frame = new JFrame();
        frame.setResizable(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("circle generator");
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);

    }
}
