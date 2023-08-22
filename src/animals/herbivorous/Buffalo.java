package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Buffalo extends AbstractHerbivorous {
    private final String pictureOfAnimal = "🐃";
    private final String nameOfAnimal = "buffalo";
    private final double weightOfAnimal = 700d;
    private final double kilogramsOfFoodForCompleteSaturation = 100d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 50d;

    public Buffalo() {
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
