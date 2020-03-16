
import java.awt.Button;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class MergeSort implements ActionListener {

    private Timer time;
    private Rectangle[] rectangles;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;
    private int rightNum;
    private int leftNum;
    private boolean isStarted;

    public MergeSort(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
        this.time = new Timer(2800, this);
        this.rectangles = sorter.getRectangles();
        this.drawingBoard = drawingBoard;
        this.buttons = buttons;
        this.leftNum = 0;
        this.rightNum = this.rectangles.length - 1;
        this.isStarted = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.time.start();
        if (isStarted == false) {
            for (Button button : buttons) {
                button.setEnabled(false);
            }
            SwingWorker work = createWorker(this.rectangles, 0, this.rectangles.length - 1);
            work.execute();
            this.isStarted = true;
        } else {
            for (Button button : buttons) {
                if (button.getLabel().equals("Randomize")) {
                    button.setEnabled(true);
                }
            }
            this.time.stop();
            this.isStarted = false;
        }


    }

    public void sort(Rectangle[] rectangles, int left, int right) {

        if (right > left) {
            int middle = (left + right) / 2;

            sort(rectangles, left, middle);
            sort(rectangles, middle + 1, right);

            merge(rectangles, left, middle, right);
        }
    }

    public SwingWorker createWorker(Rectangle[] rectangles, int left, int right) {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                sort(rectangles, left, right);
                return true;
            }
        };
    }

    public void merge(Rectangle[] rectangles, int left, int middle, int right) {

        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        int[] leftHeights = new int[sizeLeft];
        int[] rightHeights = new int[sizeRight];

        // Fill temp array with heights of rectangles of left array
        for (int i = 0; i < sizeLeft; i++) {
            leftHeights[i] = rectangles[left + i].getHeight();
        }
        // Fill temp array with heights of recentangles of right array
        for (int j = 0; j < sizeRight; j++) {
            rightHeights[j] = rectangles[middle + 1 + j].getHeight();
        }

        int i = 0;
        int j = 0;
        int k = left;

        // Sort the temp arrays and setHeight for rectangles in sorted order
        while (i < sizeLeft && j < sizeRight) {

            if (leftHeights[i] <= rightHeights[j]) {
                rectangles[k].setHeight(leftHeights[i]);
                i++;
            } else {
                rectangles[k].setHeight(rightHeights[j]);
                j++;
            }
            rectangles[k].setIsSorted(true);
            k++;
        }

        while (i < sizeLeft) {
            rectangles[k].setHeight(leftHeights[i]);
            rectangles[k].setIsSorted(true);
            i++;
            k++;
        }

        while (j < sizeRight) {
            rectangles[k].setHeight(rightHeights[j]);
            rectangles[k].setIsSorted(true);
            j++;
            k++;
        }
        long delay = 0;
        while (delay < 100000000) {
            delay++;
        }
        this.drawingBoard.paintImmediately(0, 0, 1200, 300);
    }
}
