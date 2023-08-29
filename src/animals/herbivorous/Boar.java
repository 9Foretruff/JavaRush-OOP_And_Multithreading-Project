package animals.herbivorous;

import animals.AbstractAnimal;
import interfaces.EatAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Boar extends AbstractHerbivorous implements EatAnimal {
    private final String pictureOfAnimal = "🐗";
    private final String nameOfAnimal = "boar";
    private final double weightOfAnimal = 400d;
    private final double kilogramsOfFoodForCompleteSaturation = 50d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 25d;
    private final int MAX_STEPS_PER_MOVE = 2;

    public Boar() {
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
        eatPlant(plant);
        return true;
    }

    @Override
    public void reproduce(AbstractAnimal animal) {
        if (animal instanceof Boar){
            newbornAnimals.add(new Boar());
        }
    }


    @Override
    public void run() {

    }
}
