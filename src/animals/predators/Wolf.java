package animals.predators;

import animals.Animal;
import animals.herbivorous.*;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.HashMap;
import java.util.Random;

public class Wolf extends Predator {
    private final String pictureOfAnimal = "🐺";
    private final String nameOfAnimal = "wolf";
    private final double weightOfAnimal = 50d;
    private final double kilogramsOfFoodForCompleteSaturation = 8d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 3;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillHorse = 10;
    private final int chanceToKillDeer = 15;
    private final int chanceToKillRabbit = 60;
    private final int chanceToKillMouse = 80;
    private final int chanceToKillGoat = 60;
    private final int chanceToKillSheep = 70;
    private final int chanceToKillBoar = 15;
    private final int chanceToKillBuffalo = 10;
    private final int chanceToKillDuck = 40;
    private double kilogramsOfFoodsInTheStomach = 4d;

    {
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


    public Wolf() {
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
        if (kilogramsOfFoodsInTheStomach <= 0){
            setAlive(false);
        }
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
        if (animal instanceof Wolf) {
            newbornAnimals.add(new Wolf());
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
                throw new RuntimeException(e);
            }
        }
    }
}
