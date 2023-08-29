package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Deer extends AbstractHerbivorous {
    private final String pictureOfAnimal = "🦌";
    private final String nameOfAnimal = "deer";
    private final double weightOfAnimal = 300d;
    private final double kilogramsOfFoodForCompleteSaturation = 50d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 25d;
    private final int MAX_STEPS_PER_MOVE = 4;

    public Deer() {
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
        if (animal instanceof Deer){
            newbornAnimals.add(new Deer());
        }
    }

    @Override
    public void run() {

    }
}
