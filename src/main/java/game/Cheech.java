package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Cheech {
    static int x;
    int dx;
    static int y;
    int nx2;
    int nx;
    int left;
    int dy;
    Image still;
    ImageIcon l = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\cheechLEFT.png");
    ImageIcon i = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\cheech pfp.png");
    ImageIcon j = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\cheechJUMP.png");

    int ammo = 69;

    static ArrayList bullets;

    public Cheech() {
        still = i.getImage();
        x = 10;
        nx2 = 685;
        nx = 0;
        left = 150;
        dy = 0;
        y = 172;
        bullets = new ArrayList();
    }
    public Rectangle getBounds()
    {
        return new Rectangle(10,y, 117, 128);

    }

    public static ArrayList getBullets()
    {
     return bullets;
    }
    public void fire()
    {
        if (ammo > 0)
        {
            ammo --;

       Bullet z = new Bullet((left + 60), y + 154/2 );
        bullets.add(z);
    }}
    public void move(){
        if (dx != -1){
            if (left + dx <= 150)
                left = left + dx;
        else {

                x = x + dx;
                nx2 = nx2 + dx;
                nx = nx + dx;
            }
    }
    else {
        if (left + dx > 0)
            left = left + dx;
        }
    }
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getNx2() {
        return nx2;
    }

    public int getNx() {
        return nx;
    }

    public int getLeft() {
        return left;
    }

    public int getDy() {
        return dy;
    }

    public Image getImage() {
        return still;
    }
    public void keyPressed (KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)
        {
            dx = -1;
            still = l.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            still = i.getImage();
        }
        if (key == KeyEvent.VK_UP) {
            dy = 1;
            still = j.getImage();
        }
        if (key == KeyEvent.VK_SPACE) {
           fire();

        }

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT);
        dx = 0;
        still = l.getImage();

        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
        if (key == KeyEvent.VK_UP)
            dy = 0;
        still = i.getImage();

    }
}
