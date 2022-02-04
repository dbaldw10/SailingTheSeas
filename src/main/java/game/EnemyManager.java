package game;

import java.util.ArrayList;

public class EnemyManager {

    public ArrayList<Enemy> enemies;

    public EnemyManager(int x, int y) {

        enemies = new ArrayList<>();

        enemies.add(new Enemy(x + 730, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\c pig moon man edited.png"));
        enemies.add(new Enemy(x + 700, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\danzo moon man edited.png"));
        enemies.add(new Enemy(x + 750, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\mike_o_moon_man-removebg-preview.png"));
        enemies.add(new Enemy(x + 800, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\pirate_moon_man-removebg-preview.png"));
        enemies.add(new Enemy(x + 770, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\karbeno-removebg-preview.png"));
        enemies.add(new Enemy(x + 720, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\robb moon man edited.png"));
        enemies.add(new Enemy(x + 680, y, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\mf_zroom-removebg-preview.png"));


    }

    public ArrayList<Enemy> getEnemies() {

        return enemies;
    }

    public boolean allEnemiesDead() {
        for (Enemy currentEnemy : enemies) {
            if (currentEnemy.isAlive) {
                return false;
            }
        }
        return true;
    }
    public void respawnAll(){
        for (Enemy currentEnemy : enemies)
        {
            currentEnemy.setAlive(true);
            currentEnemy.x = (int) (Cheech.x + Math.random()*300);
        }
    }
}

