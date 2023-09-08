package animals.herbivorous;

import animals.Animal;
import interfaces.EatPlant;
import plants.Plant;

public abstract class Herbivorous extends Animal implements EatPlant {

    private String pictureOfAnimal;
    private String nameOfAnimal;
    private double weightOfAnimal;
    private double kilogramsOfFoodForCompleteSaturation;
    private double kilogramsOfFoodsInTheStomach;


    @Override
    public void eatPlant(Plant plant) {
        if (getKilogramsOfFoodsInTheStomach() < kilogramsOfFoodForCompleteSaturation) {
            if (plant.isAlive()) {
                setKilogramsOfFoodsInTheStomach(getKilogramsOfFoodsInTheStomach() + plant.getWeightOfPlant());
                plant.setAlive(false);
            }
        }
    }
}
