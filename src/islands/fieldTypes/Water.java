package islands.fieldTypes;


public class Water extends AbstractField {
    private String waterPicture = "🟦";

    public Water() {
        setPictureOfField(getWaterPicture());
    }

    public String getWaterPicture() {
        return waterPicture;
    }

    @Override
    void setPicture() {
        setPictureOfField(getWaterPicture());
    }
}
