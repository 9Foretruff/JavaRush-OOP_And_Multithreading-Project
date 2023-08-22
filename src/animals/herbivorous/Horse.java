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

    public Horse() {
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
