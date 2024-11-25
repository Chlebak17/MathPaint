import javax.swing.*;
import java.awt.*;

public class Square{
    int width,height;
    Graphics g;
    Color c;
    public Square(int width, int height, Graphics g) {
        this.height = height;
        this.width = width;
        this.g = g;
        this.c = Color.BLACK;
    }

    public void create(int x,int y){
        g.setColor(c);
        g.fillRect(x,y,width,height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
