package plants;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Plant implements Runnable {
    protected final int timeDelay = 3000;
    public static CopyOnWriteArrayList<Plant> newbornPlants = new CopyOnWriteArrayList<>();
    private String nameOfPlant;
    private String pictureOfPlant;
    private double weightOfPlant;
    private boolean isAlive = true;

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
