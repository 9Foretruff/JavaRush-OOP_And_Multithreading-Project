package islands.fieldTypes;


public class Ground extends Field {
    private String groundPicture = "🟩";

    public Ground() {
        setPictureOfField(getGroundPicture());
    }

    public String getGroundPicture() {
        return groundPicture;
    }

    @Override
    void setPicture() {
        setPictureOfField(groundPicture);
    }
}
