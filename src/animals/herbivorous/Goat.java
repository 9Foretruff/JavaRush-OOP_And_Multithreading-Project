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

    public Goat() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
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
    public void run() {

    }
}
