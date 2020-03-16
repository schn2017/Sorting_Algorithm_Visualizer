
import java.awt.Button;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class QuickSort implements ActionListener {

    private Timer time;
    private Rectangle[] rectangles;
    private DrawingBoard drawingBoard;
    private ArrayList<Button> buttons;
    private boolean isStarted;

    public QuickSort(Sorter sorter, DrawingBoard drawingBoard, ArrayList<Button> buttons) {
        this.rectangles = sorter.getRectangles();
        this.drawingBoard = drawingBoard;
        this.time = new Timer(2000, this);
        this.buttons = buttons;
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

    public void sort(Rectangle[] rectangles, int low, int high) {
        if (high > low) {

            int index = partition(rectangles, low, high);
            rectangles[index].setIsSorted(true);
            long delay = 0;
            for (int i = 0; i < 100000; i++) {
                while (delay < 10000000) {
                    delay++;
                }
            }
            for (int i = low; i < high; i++) {
                if (i + 1 < rectangles.length) {
                    if (rectangles[i].getHeight() <= rectangles[i + 1].getHeight()) {
                        rectangles[i].setIsSorted(true);
                    }
                } else {
                    rectangles[rectangles.length - 1].setIsSorted(true);
                }
            }
            delay = 0;
            while (delay < 100000000) {
                delay++;
            }
            this.drawingBoard.paintImmediately(0, 0, 1200, 300);
            sort(rectangles, low, index - 1);
            sort(rectangles, index + 1, high);
            this.drawingBoard.paintImmediately(0, 0, 1200, 300);
        }
    }

    public int partition(Rectangle[] rectangles, int low, int high) {

        int pivotHeight = rectangles[high].getHeight();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (rectangles[j].getHeight() <= pivotHeight) {
                i++;
                int temp = rectangles[i].getHeight();
                rectangles[i].setHeight(rectangles[j].getHeight());
                //rectangles[i].setIsSorted(true);
                rectangles[j].setHeight(temp);
            }
        }

        int temp = rectangles[i + 1].getHeight();
        rectangles[i + 1].setHeight(pivotHeight);
        rectangles[i + 1].setIsSorted(true);
        rectangles[high].setHeight(temp);
        rectangles[high].setIsSorted(true);
        return i + 1;
    }

    public SwingWorker createWorker(Rectangle[] rectangles, int low, int high) {
        return new SwingWorker<Boolean, Integer>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                sort(rectangles, low, high);
                return true;
            }
        };
    }

}
