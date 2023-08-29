package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Horse extends AbstractHerbivorous{
    private final String pictureOfAnimal = "🐎";
    private final String nameOfAnimal = "horse";
    private final double weightOfAnimal = 400d;
    private final double kilogramsOfFoodForCompleteSaturation = 60d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 30d;
    private final int MAX_STEPS_PER_MOVE = 4;

    public Horse() {
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
        if (animal instanceof Horse){
            newbornAnimals.add(new Horse());
        }
    }

    @Override
    public void run() {

    }
}
