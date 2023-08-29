package animals.predators;

import animals.AbstractAnimal;
import animals.herbivorous.*;
import plants.AbstractPlant;

import java.util.Random;

public class Boa extends AbstractPredator {
    private final String pictureOfAnimal = "🐍";
    private final String nameOfAnimal = "boa";
    private final double weightOfAnimal = 15d;
    private final double kilogramsOfFoodForCompleteSaturation = 3d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 1.5d;
    private final int MAX_STEPS_PER_MOVE = 1;

    public Boa() {
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
        if (animal instanceof Fox) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 85) {
                    kilogramsOfFoodsInTheStomach += ((Fox) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Rabbit) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 80) {
                    kilogramsOfFoodsInTheStomach += ((Rabbit) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }else if (animal instanceof Mouse) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 60) {
                    kilogramsOfFoodsInTheStomach += ((Mouse) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }else if (animal instanceof Duck) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 90) {
                    kilogramsOfFoodsInTheStomach += ((Duck) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        }
    }

    @Override
    public boolean eat(AbstractAnimal animal) {
        if (animal instanceof Fox || animal instanceof Rabbit ||  animal instanceof Mouse || animal instanceof Duck) {
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
        if (animal instanceof Boa){
            newbornAnimals.add(new Boa());
        }
    }


    @Override
    public void run() {

    }
}
