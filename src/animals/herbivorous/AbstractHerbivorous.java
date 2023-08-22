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

    public double getKilogramsOfFoodForCompleteSaturation() {
        return kilogramsOfFoodForCompleteSaturation;
    }

    public void setKilogramsOfFoodForCompleteSaturation(double kilogramsOfFoodForCompleteSaturation) {
        this.kilogramsOfFoodForCompleteSaturation = kilogramsOfFoodForCompleteSaturation;
    }

    public double getKilogramsOfFoodsInTheStomach() {
        return kilogramsOfFoodsInTheStomach;
    }

    public void setKilogramsOfFoodsInTheStomach(double kilogramsOfFoodsInTheStomach) {
        this.kilogramsOfFoodsInTheStomach = kilogramsOfFoodsInTheStomach;
    }

    public double getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(double weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    public String getPictureOfAnimal() {
        return pictureOfAnimal;
    }

    public void setPictureOfAnimal(String pictureOfAnimal) {
        this.pictureOfAnimal = pictureOfAnimal;
    }

    public String getNameOfAnimal() {
        return nameOfAnimal;
    }

    public void setNameOfAnimal(String nameOfAnimal) {
        this.nameOfAnimal = nameOfAnimal;
    }
}
