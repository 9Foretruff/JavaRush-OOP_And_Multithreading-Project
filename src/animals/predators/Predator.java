package animals.predators;

import animals.Animal;
import interfaces.EatAnimal;

public abstract class Predator extends Animal implements EatAnimal {
    private String pictureOfAnimal;
    private String nameOfAnimal;
    private double weightOfAnimal;
    private double kilogramsOfFoodForCompleteSaturation;
    private double kilogramsOfFoodsInTheStomach;


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

    public double getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(double weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
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
}
