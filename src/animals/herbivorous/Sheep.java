package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Sheep extends AbstractHerbivorous{
    private final String pictureOfAnimal = "🐑";
    private final String nameOfAnimal = "sheep";
    private final double weightOfAnimal = 70d;
    private final double kilogramsOfFoodForCompleteSaturation = 15d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 7.5d;
    private final int MAX_STEPS_PER_MOVE = 3;

    public Sheep() {
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
        if (animal instanceof Sheep){
            newbornAnimals.add(new Sheep());
        }
    }

    @Override
    public void run() {

    }
}
