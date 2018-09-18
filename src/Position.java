public class Position {

    private int xPos;
    private int yPos;

    public Position(int xPos, int yPos) {
        this.setxPos(xPos);
        this.setyPos(yPos);
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}
