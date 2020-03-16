
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Sorting Algorithm Visualizer");
        frame.setPreferredSize(new Dimension(1200, 300));
        //frame.setResizable(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        Sorter sorter = new Sorter();
        DrawingBoard drawingBoard = new DrawingBoard(sorter);
        BorderLayout layout = new BorderLayout();
        container.add(drawingBoard, BorderLayout.CENTER);
        container.add(buttonPanel(sorter, drawingBoard), BorderLayout.LINE_END);
    }

    private JPanel buttonPanel(Sorter sorter, DrawingBoard drawingBoard) {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        // Create buttons
        Button bubbleSortButton = new Button("Bubble Sort");
        Button insertionSortButton = new Button("Insertion Sort");
        Button mergeSortButton = new Button("Merge Sort");
        Button quickSortButton = new Button("Quick Sort");
        Button randomButton = new Button("Randomize");
        Button selectionSortButton = new Button("Selection Sort");

        // Create Button List and add buttons to list
        ArrayList<Button> buttonList = new ArrayList<>();
        buttonList.add(bubbleSortButton);
        buttonList.add(insertionSortButton);
        buttonList.add(mergeSortButton);
        buttonList.add(quickSortButton);
        buttonList.add(randomButton);
        buttonList.add(selectionSortButton);

        // Create action listeners
        BubbleSort bubbleAction = new BubbleSort(sorter, drawingBoard, buttonList);
        InsertionSort insertionAction = new InsertionSort(sorter, drawingBoard, buttonList);
        MergeSort mergeAction = new MergeSort(sorter, drawingBoard, buttonList);
        QuickSort quickAction = new QuickSort(sorter, drawingBoard, buttonList);
        RandomizeButton randomAction = new RandomizeButton(sorter, drawingBoard, buttonList);
        SelectionSort selectionAction = new SelectionSort(sorter, drawingBoard, buttonList);

        // Add action listeners
        bubbleSortButton.addActionListener(bubbleAction);
        insertionSortButton.addActionListener(insertionAction);
        mergeSortButton.addActionListener(mergeAction);
        quickSortButton.addActionListener(quickAction);
        randomButton.addActionListener(randomAction);
        selectionSortButton.addActionListener(selectionAction);

        // Add buttons to panel
        panel.add(bubbleSortButton);
        panel.add(insertionSortButton);
        panel.add(mergeSortButton);
        panel.add(quickSortButton);
        panel.add(selectionSortButton);
        panel.add(randomButton);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }

}
