

public abstract class Vehicle extends Sprite {

	private boolean moveRight;
	
	public final float getInitialX() {
		return moveRight ? -getImage().getWidth()/2
						 : App.SCREEN_WIDTH + getImage().getWidth() / 2;
	}
	
	public Vehicle(String imageSrc, float x, float y, boolean moveRight, String[] tags) {
		super(imageSrc, x, y, tags);
		
		this.moveRight = moveRight;
	}


    public void render() {

        getImage().getFlippedCopy(!moveRight, false).drawCentered(getX(), getY());
    }

	public boolean getMoveRight() {
		return this.moveRight;
	}

	public final void changeDirection() {
	    this.moveRight = !getMoveRight();
    }

}
