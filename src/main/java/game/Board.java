package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener, Runnable {
    Cheech Cheech;
    Enemy CPig;
    Enemy Mike;
    Enemy Pirate;
    Enemy Danzo;
    Enemy Karben;
    Enemy Room;
    Enemy Robb;
    Image img;
    Timer time;
    Thread animator;
    int v = 172;
    boolean lost = false;
    EnemyManager em;
    boolean wonLVL1 = false;
    boolean wonLVL2 = false;
    Image img2;
    Image img3;
    Boss pirateBoss;

    static Font font = new Font("SanSerif", Font.BOLD, 24);

    public Board() {

        Cheech = new Cheech();
        em= new EnemyManager(Cheech.getX(),180);
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\background.jpg");
        img = i.getImage();
        ImageIcon i2 = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\nebulaspacebus.jpg");
        img2 = i2.getImage();
        ImageIcon i3 = new ImageIcon("C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\background3.png");
        img3 = i3.getImage();
        //ImageIcon t = new ImageIcon("")

        time = new Timer(5, this);
        time.start();


    }

    public void actionPerformed(ActionEvent e) {
        checkLVL1status();
        checkLVL2status();
        checkCollisions();
        ArrayList bullets = Cheech.getBullets();
        for (int w = 0; w < bullets.size(); w++) {
            Bullet m = (Bullet) bullets.get(w);
            if (m.getVisible() == true)
                m.move();
            else
                bullets.remove(w);
        }

        Cheech.move();


        for(int i = 0; i < em.enemies.size(); i++)
        {
            Enemy currentEnemy = em.enemies.get(i);

            if((Cheech.x > 2 + (i*15)))
            currentEnemy.move(Cheech.getDx() + 1);
        }

        repaint();

    }

    private void checkLVL2status() {
        if(Cheech.ammo < 10 && Cheech.getX() > 600) {
            wonLVL2 = true;
            if (wonLVL2) {

                img = img3;
                Cheech.ammo += 69;

            }
        }
    }

    private void checkLVL1status() {
        if(Cheech.ammo == 0) {
            wonLVL1 = true;

        if(wonLVL1) {
                img = img2;
                Cheech.ammo += 69;
                //pirateBoss.isAlive = true;
        }
        }
//        if(wonLVL2 = true){
//            img2 = img3;

    }

    boolean k = false;


    public void checkCollisions() {

        for (Enemy currentEnemy : em.enemies) {
            Rectangle rect = currentEnemy.getBounds();
            Rectangle cheechBounds = Cheech.getBounds();
            ArrayList bullets = Cheech.getBullets();
            for (int w = 0; w < bullets.size(); w++) {
                Bullet m = (Bullet) bullets.get(w);
                Rectangle m1 = m.getBounds();
                if (rect.intersects(m1) && currentEnemy.Alive()) {
                    currentEnemy.isAlive = false;
                    m.visible = false;
                }
                if (cheechBounds.intersects(rect)) {
                    lost = false;
                }
            }


        }
    }

    public void paint(Graphics g) {
        if (lost)
            System.exit(0);
        if (Cheech.dy == 1 && k == false) {
            k = true;
            animator = new Thread(this);
            animator.start();

        }

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if ((Cheech.getX() - 524) % 2400 == 0)
            Cheech.nx = 0;
        if ((Cheech.getX() - 1724) % 2400 == 0)
            Cheech.nx2 = 0;
        g2d.drawImage(img, 685 - Cheech.nx2, 0, null);
        if (Cheech.getX() > 524) {
            g2d.drawImage(img, 685 - Cheech.nx, 0, null);
        }
        g2d.drawImage(Cheech.getImage(), Cheech.left, v, null);


        if (Cheech.getDx() == -1) {
            g2d.drawImage(img, 685 - Cheech.getNx2(), 0, null);
            g2d.drawImage(Cheech.getImage(), Cheech.left, v, null);
        }
        if(!wonLVL1) {
            g2d.setFont(font);
            g2d.setColor(Color.BLUE);
            g2d.drawString("LEVEL ONE", 100, 20);
        }
        if(wonLVL1 && !wonLVL2) {
            g2d.setFont(font);
            g2d.setColor(Color.BLUE);
            g2d.drawString("LEVEL TWO", 100, 20);
        }
        if(wonLVL1 && wonLVL2 == true) {
            g2d.setFont(font);
            g2d.setColor(Color.BLUE);
            g2d.drawString("LEVEL THREE", 100, 20);
        }


        ArrayList bullets = Cheech.getBullets();
        for (int w = 0; w < bullets.size(); w++) {

            Bullet m = (Bullet) bullets.get(w);
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), null);

        }
        g2d.setFont(font);
        g2d.setColor(Color.BLUE);
        g2d.drawString("Ammo remaining:" + Cheech.ammo, +300, 20);
        System.out.println(Cheech.getX());
        //g2d.drawString("PowerLVL" + Boss, +300, 20);

        for(int i = 0; i < em.enemies.size(); i++){
            Enemy currentEnemy = em.enemies.get(i);
            if ((Cheech.x > 40 + (i*10) ))
                if (currentEnemy.Alive() == true)
                    g2d.drawImage(currentEnemy.getImage(),currentEnemy.getX(), currentEnemy.getY(), null);
            if(currentEnemy.getX() < 40){
                currentEnemy.isAlive = false;
            }
        }
        //if(pirateBoss.isAlive) {
      //      g2d.drawImage(pirateBoss.getImage(), pirateBoss.getX(), pirateBoss.getY(), null);
      //      g2d.setFont(font);
       //     g2d.setColor(Color.RED);
           // g2d.drawString("PowerLVL:" + pirateBoss.getPowerLVL(), pirateBoss.x, pirateBoss.y - 10);
   //     }
        if(em.allEnemiesDead()){
            em.respawnAll();
        }

    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        while(done == false)
        {
            cycle();
            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 10 - timeDiff;
            if (sleep < 0)
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (Exception e)
            {}
            beforeTime = System.currentTimeMillis();
        }
        done = false;
        h = false;
        k = false;
        }

        boolean h = false;
       boolean done = false;

        public void cycle(){
            if (h == false)
                v--;
            if (v == 133)
                h = true;
            if (h == true && v <= 172)
                v++;
            if (v == 172)
                done = true;
        }


    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            Cheech.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            Cheech.keyPressed(e);
        }
    }
    }

