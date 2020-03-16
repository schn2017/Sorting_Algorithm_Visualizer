
import java.awt.Button;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SelectionSort implements ActionListener {

    private int i;
    private int maxHeight;
    private int count;
    private Timer time;
    private Rectangle[] rectangles;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;
    private boolean isStarted;

    public SelectionSort(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
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

        if (this.isStarted == false) {
            this.isStarted = true;
            for (Button button : buttons) {
                button.setEnabled(false);
            }
        }

        int arrayLength = this.rectangles.length;
        int indexMinimumFound = this.i;

        if (this.i < arrayLength) {
            int minHeight = this.rectangles[i].getHeight();
            int tempHeight = this.rectangles[i].getHeight();

            for (int j = this.i; j < arrayLength; j++) {
                if (minHeight > this.rectangles[j].getHeight()) {
                    minHeight = this.rectangles[j].getHeight();
                    indexMinimumFound = j;
                }
            }
            this.rectangles[i].setHeight(minHeight);
            this.rectangles[i].setIsSorted(true);
            this.rectangles[indexMinimumFound].setHeight(tempHeight);
            this.drawingBoard.repaint();
        }
        this.i++;

        if (this.i == arrayLength) {
            this.i = 0;
            this.time.stop();

            this.isStarted = false;

            for (Button button : this.buttons) {
                if (button.getLabel().equals("Randomize")) {
                    button.setEnabled(true);
                }
            }

        }

    }
}
