package animals;


import islands.Island;
import plants.Plant;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Animal implements Runnable {
    public static CopyOnWriteArrayList<Animal> newbornAnimals = new CopyOnWriteArrayList<>();
    public static volatile Object lock = new Object();
    protected volatile static Island island;
    protected final int timeDelay = 3000;
    private volatile String pictureOfAnimal;
    private String nameOfAnimal;
    private double weightOfAnimal;
    private volatile double kilogramsOfFoodForCompleteSaturation;
    private volatile double kilogramsOfFoodsInTheStomach;
    private volatile boolean isAlive = true;
    private int maxStepsPerMove;
    private volatile int y;
    private volatile int x;
    public abstract void dieFromStarvation();
    public abstract boolean eat(Plant plant);
    public abstract void reproduce(Animal animal);
    public abstract boolean eat(Animal animal);
    public static Island getIsland() {
        return island;
    }
    public static void setIsland(Island island) {
        Animal.island = island;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return timeDelay == animal.timeDelay && Double.compare(animal.weightOfAnimal, weightOfAnimal) == 0 && Double.compare(animal.kilogramsOfFoodForCompleteSaturation, kilogramsOfFoodForCompleteSaturation) == 0 && Double.compare(animal.kilogramsOfFoodsInTheStomach, kilogramsOfFoodsInTheStomach) == 0 && isAlive == animal.isAlive && maxStepsPerMove == animal.maxStepsPerMove && y == animal.y && x == animal.x && Objects.equals(newbornAnimals, animal.newbornAnimals) && Objects.equals(pictureOfAnimal, animal.pictureOfAnimal) && Objects.equals(nameOfAnimal, animal.nameOfAnimal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pictureOfAnimal, nameOfAnimal);
    }
}
