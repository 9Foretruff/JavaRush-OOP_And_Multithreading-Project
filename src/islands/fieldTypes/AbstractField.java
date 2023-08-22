package islands.fieldTypes;

import animals.AbstractAnimal;

import java.util.HashMap;

public abstract class AbstractField {
    private HashMap<AbstractAnimal, Integer> animalsInFiled = new HashMap<>(); //TODO REMAKE
    private String pictureOfField;


    public void setPictureOfField(String pictureOfField) {
        this.pictureOfField = pictureOfField;
    }

    public String getPictureOfField() {
        return pictureOfField;
    }

    abstract void setPicture();

}
