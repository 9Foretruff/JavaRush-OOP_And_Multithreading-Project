package animals.predators;

import animals.Animal;
import animals.herbivorous.*;
import exceptions.InterruptedWhileRunningException;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.HashMap;
import java.util.Random;

public class Bear extends Predator {
    private final String pictureOfAnimal = "🐻";
    private final String nameOfAnimal = "bear";
    private final double weightOfAnimal = 500d;
    private final double kilogramsOfFoodForCompleteSaturation = 80d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 2;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillBoa = 80;
    private final int chanceToKillHorse = 40;
    private final int chanceToKillDeer = 80;
    private final int chanceToKillRabbit = 80;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillGoat = 70;
    private final int chanceToKillSheep = 70;
    private final int chanceToKillBoar = 50;
    private final int chanceToKillBuffalo = 20;
    private final int chanceToKillDuck = 10;
    private double kilogramsOfFoodsInTheStomach = 40d;

    {
        animalsThatCanBeEaten.put(new Boa(), chanceToKillBoa);
        animalsThatCanBeEaten.put(new Horse(), chanceToKillHorse);
        animalsThatCanBeEaten.put(new Deer(), chanceToKillDeer);
        animalsThatCanBeEaten.put(new Rabbit(), chanceToKillRabbit);
        animalsThatCanBeEaten.put(new Mouse(), chanceToKillMouse);
        animalsThatCanBeEaten.put(new Goat(), chanceToKillGoat);
        animalsThatCanBeEaten.put(new Sheep(), chanceToKillSheep);
        animalsThatCanBeEaten.put(new Boar(), chanceToKillBoar);
        animalsThatCanBeEaten.put(new Buffalo(), chanceToKillBuffalo);
        animalsThatCanBeEaten.put(new Duck(), chanceToKillDuck);
    }

    public Bear() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(maxStepsPerMove);
    }


    @Override
    public void eatAnimal(Animal animal) {
        int chanceNotToKill;
        if (animalsThatCanBeEaten.containsKey(animal)) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceNotToKill = random.nextInt(0, 100 + 1);
                if (animalsThatCanBeEaten.get(animal) >= chanceNotToKill) {
                    kilogramsOfFoodsInTheStomach += animal.getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }
    }


    @Override
    public void dieFromStarvation() {

    }

    @Override
    public boolean eat(Animal animal) {
        if (animalsThatCanBeEaten.containsKey(animal)) {
            eatAnimal(animal);
        }
        return true;
    }

    @Override
    public boolean eat(Plant plant) {
        return false;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Bear) {
            newbornAnimals.add(new Bear());
        }
    }

    protected void getHungry() {
        double hungry = getKilogramsOfFoodForCompleteSaturation() / 100 * 10;
        setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() - hungry);
    }

    @Override
    public void run() {
        while (true) {
            setY(random.nextInt(island.getHeight()));
            setX(random.nextInt(island.getWidth()));
            if (!(island.fields[getY()][getY()].getPictureOfField().equals("🟦")||island.fields[getY()][getY()].getPictureOfField().equals("⛰️"))){
                break;
            }
        }
        island.fields[getY()][getX()].animalsOnField.add(this);
        while (isAlive()) {
            island.moveAnimal(this);

            for (Animal animal : island.fields[getY()][getX()].animalsOnField) {
                this.reproduce(animal);
            }

            for (Plant plant : island.fields[getY()][getX()].plantsOnField) {
                this.eat(plant);
            }

            for (Animal animal : island.fields[getY()][getX()].animalsOnField) {
                this.eat(animal);
            }

            getHungry();
            dieFromStarvation();

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new InterruptedWhileRunningException("Thread was interrupted while running");
            }
        }
    }

}
