package animals;


import plants.AbstractPlant;

import java.util.ArrayList;

public abstract class AbstractAnimal implements Runnable {
    public ArrayList<AbstractAnimal> newbornAnimals = new ArrayList<>();
    private String pictureOfAnimal;
    private String nameOfAnimal;
    private double weightOfAnimal;
    private double kilogramsOfFoodForCompleteSaturation;
    private double kilogramsOfFoodsInTheStomach;
    private boolean isAlive = true;
    private int maxStepsPerMove;
    private int y;
    private int x;

    public int getMaxStepsPerMove() {
        return maxStepsPerMove;
    }

    public void setMaxStepsPerMove(int maxStepsPerMove) {
        this.maxStepsPerMove = maxStepsPerMove;
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

    public String getPictureOfAnimal() {
        return pictureOfAnimal;
    }

    public void setPictureOfAnimal(String pictureOfAnimal) {
        this.pictureOfAnimal = pictureOfAnimal;
    }

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }

    public double getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(double weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    public double getKilogramsOfFoodForCompleteSaturation() {
        return kilogramsOfFoodForCompleteSaturation;
    }

    public void setKilogramsOfFoodForCompleteSaturation(double kilogramsOfFoodForCompleteSaturation) {
        this.kilogramsOfFoodForCompleteSaturation = kilogramsOfFoodForCompleteSaturation;
    }

    public double getKilogramsOfFoodsInTheStomach() {
        return kilogramsOfFoodsInTheStomach;
    }

    public void setKilogramsOfFoodsInTheStomach(double kilogramsOfFoodsInTheStomach) {
        this.kilogramsOfFoodsInTheStomach = kilogramsOfFoodsInTheStomach;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public abstract boolean eat(AbstractAnimal animal);

    public abstract boolean eat(AbstractPlant plant);

    public abstract void reproduce(AbstractAnimal animal);
}
