
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;

public class Sorter {

    private Rectangle[] rectangles;
    private int i;
    private int j;

    public Sorter() {
        this.rectangles = new Rectangle[100];
        populateRectangles();
        this.i = 0;
        this.j = 0;
    }

    public void populateRectangles() {
        int positionX = 20;
        int positionY = 200;
        Random rand = new Random();

        for (int i = 0; i < this.rectangles.length; i++) {
            int height = rand.nextInt(100) + 10;
            //System.out.println(height);
            this.rectangles[i] = new Rectangle(positionX, positionY, height);
            positionX = positionX + 10;
        }
    }

    public void resetBoard() {
        Random rand = new Random();
        for (Rectangle rectangle : this.rectangles) {
            int height = rand.nextInt(100) + 10;
            rectangle.setHeight(height);
            rectangle.setIsSorted(false);
        }
    }

    public Rectangle[] getRectangles() {
        return this.rectangles;
    }

    public void draw(Graphics graphics) {
        for (int i = 0; i < this.rectangles.length; i++) {
            this.rectangles[i].draw(graphics);
        }
    }

    public void bubbleSort(Graphics graphics, DrawingBoard drawingBoard) {
        boolean isSorted = false;
        int arraySize = rectangles.length;
        int sortCount = 0;

        draw(graphics);
        while (isSorted == false) {
            for (int i = 0; i < arraySize - 1; i++) {
                draw(graphics);
                if (rectangles[i].getHeight() > rectangles[i + 1].getHeight()) {
                    int temp = rectangles[i + 1].getHeight();
                    rectangles[i + 1].setHeight(rectangles[i].getHeight());
                    rectangles[i].setHeight(temp);
                    sortCount = 0;
                } else {
                    sortCount++;
                }
                if (sortCount == arraySize) {
                    System.out.println("Sorted!");
                    isSorted = true;
                }
            }

        }
        System.out.println("Out of Loop");
    }
}
