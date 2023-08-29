package animals.herbivorous;

import animals.AbstractAnimal;
import plants.AbstractPlant;

import java.util.Random;

public class Caterpillar extends AbstractHerbivorous {
    private final String pictureOfAnimal = "🐛";
    private final String nameOfAnimal = "caterpillar";
    private final double weightOfAnimal = 0.01d;
    private final double kilogramsOfFoodForCompleteSaturation = 0d;
    private final Random random = new Random();
    private double kilogramsOfFoodsInTheStomach = 0d;
    private final int MAX_STEPS_PER_MOVE = 0;

    public Caterpillar() {
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
        if (animal instanceof Caterpillar){
            newbornAnimals.add(new Caterpillar());
        }
    }

    @Override
    public void run() {

    }
}
