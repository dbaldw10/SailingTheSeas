package game;

public class Boss extends Enemy{
    int powerLVL;

    public Boss(int startX, int startY, String location) {
        super(startX, startY, location);
        Boss pirateBoss = new Boss((Cheech.x +300), 172, "C:\\Users\\User\\code\\SailingTheSeas\\src\\main\\resources\\pirate_moon_man-removebg-preview.png");
        int powerLVL = this.powerLVL;
        this.isAlive = false;
    }

    public int getPowerLVL() {
        return powerLVL;
    }
}
