
import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {

    private Sorter sorter;

    public DrawingBoard(Sorter sorter) {
        this.sorter = sorter;
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        sorter.draw(graphics);
    }
    
    
    
}
