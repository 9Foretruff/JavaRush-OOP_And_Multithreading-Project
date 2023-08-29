package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Rabbit extends AbstractHerbivorous{
    private final String pictureOfAnimal = "🐇";
    private final String nameOfAnimal = "rabbit";
    private final double weightOfAnimal = 2d;
    private final double kilogramsOfFoodForCompleteSaturation = 0.45d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 0.25d;
    private final int MAX_STEPS_PER_MOVE = 2;

    public Rabbit() {
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
        if (animal instanceof Rabbit){
            newbornAnimals.add(new Rabbit());
        }
    }

    @Override
    public void run() {

    }
}
