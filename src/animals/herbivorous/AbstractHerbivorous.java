package animals.herbivorous;

import animals.AbstractAnimal;
import interfaces.EatPlant;
import plants.AbstractPlant;

public abstract class AbstractHerbivorous extends AbstractAnimal implements EatPlant {

    private String pictureOfAnimal;
    private String nameOfAnimal;
    private double weightOfAnimal;
    private double kilogramsOfFoodForCompleteSaturation;
    private double kilogramsOfFoodsInTheStomach;

    @Override
    public void eatPlant(AbstractPlant plant) {
        if (kilogramsOfFoodsInTheStomach < kilogramsOfFoodForCompleteSaturation) {
            if (plant.isAlive()) {
                kilogramsOfFoodsInTheStomach += plant.getWeightOfPlant();
                plant.setAlive(false);
            }
        }
    }
}
