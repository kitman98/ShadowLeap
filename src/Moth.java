public class Moth extends Vehicle {

    private static final String ASSET_PATH = "";

    private float xPosLamp;
    private float yPosLamp;

    public Moth(float x, float y, float xPosLamp,float  yPosLamp) {
        super(ASSET_PATH, x, y, true, new String[]{Sprite.HAZARD});
        setxPosLamp(xPosLamp);
        setyPosLamp(yPosLamp);

    }

    private void setxPosLamp(float xPosLamp) {
        this.xPosLamp = xPosLamp;
    }

    private void setyPosLamp(float yPosLamp) {
        this.yPosLamp = yPosLamp;
    }
}
