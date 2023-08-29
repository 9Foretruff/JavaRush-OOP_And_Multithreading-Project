package islands.fieldTypes;

import animals.AbstractAnimal;

import java.util.ArrayList;

public abstract class AbstractField {
    public ArrayList<AbstractAnimal> animalsOnField = new ArrayList<>();
    private String pictureOfField;

    public String getPictureOfField() {
        return pictureOfField;
    }

    public void setPictureOfField(String pictureOfField) {
        this.pictureOfField = pictureOfField;
    }

    abstract void setPicture();

}
