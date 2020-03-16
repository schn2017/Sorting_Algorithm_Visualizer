
import java.awt.Button;
import java.awt.event.*;
import java.util.ArrayList;

public class RandomizeButton implements ActionListener {

    private Sorter sorter;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;

    public RandomizeButton(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
        this.sorter = sorter;
        this.drawingBoard = drawingBoard;
        this.buttons = buttons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Button button: this.buttons){
            button.setEnabled(true);
        }
        this.sorter.resetBoard();
        this.drawingBoard.repaint();
    }
}
