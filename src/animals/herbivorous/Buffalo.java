package animals.herbivorous;

import animals.Animal;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.Random;

public class Buffalo extends Herbivorous {
    private final String pictureOfAnimal = "🐃";
    private final String nameOfAnimal = "buffalo";
    private final double weightOfAnimal = 700d;
    private final double kilogramsOfFoodForCompleteSaturation = 100d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 3;
    private double kilogramsOfFoodsInTheStomach = 50d;

    public Buffalo() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(maxStepsPerMove);
    }

    @Override
    public void dieFromStarvation() {
        if (kilogramsOfFoodsInTheStomach <= 0) {
            setAlive(false);
        }
    }

    protected void getHungry() {
        double hungry = getKilogramsOfFoodForCompleteSaturation() / 100 * 10;
        setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() - hungry);
    }

    @Override
    public boolean eat(Animal animal) {
        return false;
    }

    @Override
    public boolean eat(Plant plant) {
        eatPlant(plant);
        return true;
    }

    @Override
    public void reproduce(Animal animal) {
        if (animal instanceof Buffalo) {
            newbornAnimals.add(new Buffalo());
        }
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
