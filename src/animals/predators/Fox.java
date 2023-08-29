package animals.predators;

import animals.AbstractAnimal;
import animals.herbivorous.*;
import plants.AbstractPlant;

import java.util.Random;

public class Fox extends AbstractPredator {
    private final String pictureOfAnimal = "🦊";
    private final String nameOfAnimal = "fox";
    private final double weightOfAnimal = 8d;
    private final double kilogramsOfFoodForCompleteSaturation = 2d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 1d;
    private final int MAX_STEPS_PER_MOVE = 2;

    public Fox() {
        setPictureOfAnimal(pictureOfAnimal);
        setNameOfAnimal(nameOfAnimal);
        setWeightOfAnimal(weightOfAnimal);
        setKilogramsOfFoodForCompleteSaturation(kilogramsOfFoodForCompleteSaturation);
        setKilogramsOfFoodsInTheStomach(kilogramsOfFoodsInTheStomach);
        setMaxStepsPerMove(MAX_STEPS_PER_MOVE);
    }


    @Override
    public void eatAnimal(AbstractAnimal animal) {
        int chanceToKill;
        if (animal instanceof Rabbit) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 30) {
                    kilogramsOfFoodsInTheStomach += ((Rabbit) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Mouse) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 10) {
                    kilogramsOfFoodsInTheStomach += ((Mouse) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Duck) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 40) {
                    kilogramsOfFoodsInTheStomach += ((Duck) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }else if (animal instanceof Caterpillar) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 60) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }
    }

    @Override
    public boolean eat(AbstractAnimal animal) {
        if (animal instanceof Rabbit || animal instanceof Mouse || animal instanceof Duck || animal instanceof Caterpillar) {
            eatAnimal(animal);
        }
        return true;
    }

    @Override
    public boolean eat(AbstractPlant plant) {
        return false;
    }

    @Override
    public void reproduce(AbstractAnimal animal) {
        if (animal instanceof Fox){
            newbornAnimals.add(new Fox());
        }
    }


    @Override
    public void run() {

    }
}
