package animals.predators;

import animals.AbstractAnimal;
import animals.herbivorous.Caterpillar;
import animals.herbivorous.Mouse;
import plants.AbstractPlant;

import java.util.Random;

public class Bear extends AbstractPredator {
    private final String pictureOfAnimal = "🐻";
    private final String nameOfAnimal = "bear";
    private final double weightOfAnimal = 500d;
    private final double kilogramsOfFoodForCompleteSaturation = 80d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 40d;

    public Bear() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
    }


    @Override
    public void eatAnimal(AbstractAnimal animal) {
        int chanceToKill;
        if (animal instanceof Mouse) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 50) {
                    kilogramsOfFoodsInTheStomach += ((Mouse) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Caterpillar) {
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
        if (animal instanceof Mouse || animal instanceof Caterpillar) {
            eatAnimal(animal);
        }
        return true;
    }

    @Override
    public boolean eat(AbstractPlant plant) {
        return false;
    }


    @Override
    public void run() {

    }
}
