
import java.awt.Button;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class BubbleSort implements ActionListener {

    private int i;
    private int j;
    private int maxHeight;
    private int count;
    private Timer time;
    private Sorter sorter;
    private Rectangle[] rectangles;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;
    private boolean isStarted;

    public BubbleSort(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
        this.i = 0;
        this.j = 0;
        this.sorter = sorter;
        this.time = new Timer(1, this);
        this.rectangles = sorter.getRectangles();
        this.drawingBoard = drawingBoard;
        this.buttons = buttons;
    }

    public void stopTimer() {
        this.time.stop();
        this.i = 0;
        this.j = 0;
        this.maxHeight = 0;
        this.count = 0;
        this.isStarted = false;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time.start();

        if (this.isStarted == false) {
            this.isStarted = true;
            for (Button button : buttons) {
                button.setEnabled(false);
            }
        }

        int arrayLength = this.rectangles.length - 1;
        if (this.i < arrayLength) {

            if (this.rectangles[this.j].getHeight() > rectangles[this.j + 1].getHeight()) {
                int tempHeight = this.rectangles[this.j].getHeight();
                this.rectangles[this.j].setHeight(this.rectangles[this.j + 1].getHeight());
                this.rectangles[this.j + 1].setHeight(tempHeight);
            }
            this.j++;

            if (this.j == this.rectangles.length - 1 - this.i) {
                this.rectangles[j].setIsSorted(true);
                this.j = 0;
                this.i++;
                this.count++;
            }
            if (count == arrayLength) {
                this.rectangles[0].setIsSorted(true);
            }
            this.drawingBoard.repaint();
        }

        if (this.i == arrayLength) {
            for (Button button : this.buttons) {
                if (button.getLabel().equals("Randomize")) {
                    button.setEnabled(true);
                }
            }
            stopTimer();
        }

    }
}
