package animals.herbivorous;

import animals.Animal;
import islands.fieldTypes.Ground;
import plants.Plant;

import java.util.Random;

public class Caterpillar extends Herbivorous {
    private final String pictureOfAnimal = "🐛";
    private final String nameOfAnimal = "caterpillar";
    private final double weightOfAnimal = 0.01d;
    private final double kilogramsOfFoodForCompleteSaturation = 0d;
    private final Random random = new Random();
    private final int maxStepsPerMove = 0;
    private double kilogramsOfFoodsInTheStomach = 0d;

    public Caterpillar() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(maxStepsPerMove);
    }

    @Override
    public void dieFromStarvation() {
        if (kilogramsOfFoodsInTheStomach <= 0){
            setAlive(false);
        }
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
        if (animal instanceof Caterpillar) {
            newbornAnimals.add(new Caterpillar());
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

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
