package animals.herbivorous;

import animals.Animal;
import exceptions.InterruptedWhileRunningException;
import interfaces.EatAnimal;
import plants.Plant;

import java.util.HashMap;
import java.util.Random;

public class Boar extends Herbivorous implements EatAnimal {
    private final String pictureOfAnimal = "🐗";
    private final String nameOfAnimal = "boar";
    private final double weightOfAnimal = 400d;
    private final double kilogramsOfFoodForCompleteSaturation = 50d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 2;
    private final HashMap<Animal, Integer> animalsThatCanBeEaten = new HashMap<>();
    private final int chanceToKillMouse = 50;
    private final int chanceToKillCaterpillar = 90;
    private volatile double kilogramsOfFoodsInTheStomach = 25d;

    {
        animalsThatCanBeEaten.put(new Mouse(), chanceToKillMouse);
        animalsThatCanBeEaten.put(new Caterpillar(), chanceToKillCaterpillar);
    }


    public Boar() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(maxStepsPerMove);
    }

    protected void getHungry() {
        double hungry = getKilogramsOfFoodForCompleteSaturation() / 100 * 10;
        setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() - hungry);
    }


    @Override
    public void eatAnimal(Animal animal) {
        int chanceNotToKill;
        if (animalsThatCanBeEaten.containsKey(animal)) {
            if (getKilogramsOfFoodsInTheStomach() < kilogramsOfFoodForCompleteSaturation) {
                chanceNotToKill = random.nextInt(0, 100 + 1);
                if (animalsThatCanBeEaten.get(animal) >= chanceNotToKill) {
                    setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() + animal.getWeightOfAnimal());
                    animal.setAlive(false);
                }
            }
        }
    }

    @Override
    public void dieFromStarvation() {
        if (getKilogramsOfFoodsInTheStomach() <= 0) {
            island.fields[getY()][getX()].animalsOnField.remove(this);
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
        eatPlant(plant);
        return true;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Boar && !animal.equals(this)) {
            newbornAnimals.add(new Boar());
        }
    }


    @Override
    public void run() {
        while (true) {
            setY(random.nextInt(island.getHeight()));
            setX(random.nextInt(island.getWidth()));
            if (!(island.fields[getY()][getY()].getPictureOfField().equals("🟦") || island.fields[getY()][getY()].getPictureOfField().equals("⛰️"))) {
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
