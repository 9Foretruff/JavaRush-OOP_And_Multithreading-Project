package plants;

import islands.Island;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Plant implements Runnable {
    public static CopyOnWriteArrayList<Plant> newbornPlants = new CopyOnWriteArrayList<>();
    protected volatile static Island island;
    protected final int timeDelay = 3000;
    protected Random random = new Random();
    private String nameOfPlant;
    private String pictureOfPlant;
    private double weightOfPlant;
    private boolean isAlive = true;
    private volatile int y;
    private volatile int x;

    public static Island getIsland() {
        return island;
    }

    public static void setIsland(Island island) {
        Plant.island = island;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    abstract void flowering();

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public double getWeightOfPlant() {
        return weightOfPlant;
    }

    protected void setWeightOfPlant(double weightOfPlant) {
        this.weightOfPlant = weightOfPlant;
    }

    public String getNameOfPlant() {
        return nameOfPlant;
    }

    protected void setNameOfPlant(String nameOfPlant) {
        this.nameOfPlant = nameOfPlant;
    }

    public String getPictureOfPlant() {
        return pictureOfPlant;
    }

    protected void setPictureOfPlant(String pictureOfPlant) {
        this.pictureOfPlant = pictureOfPlant;
    }
}
