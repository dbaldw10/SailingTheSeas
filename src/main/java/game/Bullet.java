package game;

import javax.swing.*;
import java.awt.*;

public class Bullet {

    int x,y;
    Image img;
    boolean visible;

    public Bullet(int startX, int startY)
    {
        x = startX;
        y = startY;
        ImageIcon newBullet = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\bullet.png");
        img = newBullet.getImage();
        visible = true;
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x,y, 35, 36);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return img;
    }

    public boolean getVisible() {
        return visible;
    }

    public void move()
    {
        x = x + 2;
        if (x > 700)
            visible = false;

    }


}
