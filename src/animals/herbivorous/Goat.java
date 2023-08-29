package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Goat extends AbstractHerbivorous{
    private final String pictureOfAnimal = "🐐";
    private final String nameOfAnimal = "goat";
    private final double weightOfAnimal = 60d;
    private final double kilogramsOfFoodForCompleteSaturation = 10d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 5d;
    private final int MAX_STEPS_PER_MOVE = 3;

    public Goat() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(MAX_STEPS_PER_MOVE);
    }

    @Override
    public boolean eat(AbstractAnimal animal) {
        return false;
    }

    @Override
    public boolean eat(AbstractPlant plant) {
        eatPlant(plant);
        return true;
    }

    @Override
    public void reproduce(AbstractAnimal animal) {
        if (animal instanceof Goat){
            newbornAnimals.add(new Goat());
        }
    }

    @Override
    public void run() {

    }
}
