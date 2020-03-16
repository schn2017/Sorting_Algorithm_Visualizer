
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InsertionSort implements ActionListener {

    private int i;
    private Timer time;
    private Rectangle[] rectangles;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;
    private boolean isStarted;
    private SwingWorker worker;

    public InsertionSort(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
        this.i = 0;
        this.time = new Timer(50, this);
        this.rectangles = sorter.getRectangles();
        this.drawingBoard = drawingBoard;
        this.buttons = buttons;
        this.isStarted = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time.start();
        
        if (this.isStarted == false){
            this.isStarted = true;
            for (Button button: buttons){
                button.setEnabled(false);
            }
        }

        int arrayLength = this.rectangles.length;
        int insertionIndex = 0;
        int tempHeight;

        this.rectangles[0].setIsSorted(true); // First element is already sorted

        if (this.i < arrayLength) {
            for (int j = this.i + 1; j < arrayLength; j++) {
                if (this.rectangles[i].getHeight() < this.rectangles[j].getHeight()) {
                    this.rectangles[j].setIsSorted(true);
                    this.i++;
                    break;
                } else {
                    for (int k = 0; k <= this.i; k++) {
                        if (this.rectangles[j].getHeight() <= this.rectangles[k].getHeight()) {
                            insertionIndex = k;
                            break;
                        }
                    }
                    
                    tempHeight = this.rectangles[j].getHeight();

                    for (int k = i; k >= insertionIndex; k--) {
                        this.rectangles[k + 1].setHeight(this.rectangles[k].getHeight());
                        this.rectangles[k + 1].setIsSorted(true);
                    }

                    this.rectangles[insertionIndex].setHeight(tempHeight);
                    this.i++;
                    break;
                }
            }
        }
        
        if (this.i == arrayLength - 1){
            this.i = 0;
            this.time.stop();
            this.isStarted = false;
            
            for (Button button: this.buttons){
                if (button.getLabel().equals("Randomize")){
                    button.setEnabled(true);
                }
            }
            
            
        }
        drawingBoard.repaint();
    }
}
