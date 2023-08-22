package animals.herbivorous;

import animals.AbstractAnimal;
import interfaces.EatAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Duck extends AbstractHerbivorous implements EatAnimal {
    private final String pictureOfAnimal = "🦆";
    private final String nameOfAnimal = "duck";
    private final double weightOfAnimal = 1d;
    private final double kilogramsOfFoodForCompleteSaturation = 0.15d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 0.10d;

    public Duck() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
    }


    @Override
    public void eatAnimal(AbstractAnimal animal) {
        int chanceToKill;
        if (animal instanceof Caterpillar) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 10) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }
    }

    @Override
    public boolean eat(AbstractAnimal animal) {
        if (animal instanceof Caterpillar) {
            eatAnimal(animal);
        }
        return true;
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
