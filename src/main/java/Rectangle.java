
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle {

    private int height;
    private int positionX;
    private int oldHeight;
    private int positionY;
    private boolean isSorted;

    public Rectangle(int positionX, int positionY, int height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = height;
        this.oldHeight = height;
        this.isSorted = false;
    }

    public int getHeight() {
        return this.height;
    }
    
    public int getOldHeight(){
        return this.oldHeight;
    }
    
    public void setOldHeight(int oldHeight){
        this.oldHeight = oldHeight;
    }

    public void setHeight(int height) {
        this.oldHeight = this.height;
        this.height = height;
    }

    public void setIsSorted(Boolean status) {
        this.isSorted = status;
    }
    
    public boolean getIsSorted(){
        return this.isSorted;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        //System.out.println(this.isSorted);

        //graphics.clearRect(this.positionX, this.positionY - this.oldHeight, 10, this.oldHeight);
        //graphics.clearRect(this.positionX + 1, this.positionY - this.oldHeight + 1, 9, this.oldHeight - 1);
        
        graphics.drawRect(this.positionX, this.positionY - this.height, 10, this.height);
        if (this.isSorted == false) {
            graphics.setColor(Color.red);
            graphics.fillRect(this.positionX + 1, this.positionY - this.height + 1, 9, this.height - 1);
        } else {
            graphics.setColor(Color.green);
            graphics.fillRect(this.positionX + 1, this.positionY - this.height + 1, 9, this.height - 1);
        }

    }
}
