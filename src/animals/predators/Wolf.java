package animals.predators;

import animals.AbstractAnimal;
import animals.herbivorous.*;
import plants.AbstractPlant;

import java.util.Random;

public class Wolf extends AbstractPredator {
    private final String pictureOfAnimal = "🐺";
    private final String nameOfAnimal = "wolf";
    private final double weightOfAnimal = 50d;
    private final double kilogramsOfFoodForCompleteSaturation = 8d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 4d;
    private final int MAX_STEPS_PER_MOVE = 3;

    public Wolf() {
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
        if (animal instanceof Horse) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 90) {
                    kilogramsOfFoodsInTheStomach += ((Rabbit) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Deer) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 85) {
                    kilogramsOfFoodsInTheStomach += ((Mouse) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Rabbit) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 40) {
                    kilogramsOfFoodsInTheStomach += ((Duck) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Mouse) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 20) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Goat) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 40) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Sheep) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 30) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Boar) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 85) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Buffalo) {
            if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
                chanceToKill = random.nextInt(0, 100 + 1);
                if (chanceToKill >= 90) {
                    kilogramsOfFoodsInTheStomach += ((Caterpillar) animal).getWeightOfAnimal();
                    animal.setAlive(false);
                }
            }
        } else if (animal instanceof Duck) {
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
        if (animal instanceof Horse || animal instanceof Deer || animal instanceof Rabbit || animal instanceof Mouse || animal instanceof Goat
                || animal instanceof Sheep || animal instanceof Boar || animal instanceof Buffalo || animal instanceof Duck) {
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
        if (animal instanceof Wolf){
            newbornAnimals.add(new Wolf());
        }
    }


    @Override
    public void run() {

    }
}
