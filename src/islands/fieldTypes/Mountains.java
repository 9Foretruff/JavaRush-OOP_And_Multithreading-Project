package islands.fieldTypes;


public class Mountains extends AbstractField {
    private String mountainsPicture = "⛰️";

    public Mountains() {
        setPictureOfField(getMountainsPicture());
    }

    public String getMountainsPicture() {
        return mountainsPicture;
    }

    @Override
    void setPicture() {
        setPictureOfField(getMountainsPicture());
    }
}
