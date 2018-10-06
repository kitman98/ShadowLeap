/**
 * Abstract class that represents a basic moving Sprite that obstructs the player.
 */
public abstract class Vehicle extends Sprite {

	private boolean moveRight;
	
	public final float getInitialX() {
		return moveRight ? -getImage().getWidth()/2
						 : App.SCREEN_WIDTH + getImage().getWidth() / 2;
	}

    /**
     * Basic constructor for any Vehicle
     * @param imageSrc  Image that will be rendered
     * @param x         X position of the vehicle
     * @param y         Y position of the vehicle
     * @param moveRight Direction of movement of the Vehicle
     * @param tags      Predefined tags that determine the behaviour of a Vehicle
     */
	public Vehicle(String imageSrc, float x, float y, boolean moveRight, String[] tags) {
		super(imageSrc, x, y, tags);
		
		this.moveRight = moveRight;
	}


    public void render() {

        getImage().getFlippedCopy(!moveRight, false).drawCentered(getX(), getY());
    }

    /**
     * Gets the direction of movement of the Vehicle
     * @return  whether vehicle moves to the right of the screen
     */
	public boolean getMoveRight() {
		return this.moveRight;
	}

    /**
     * Changes direction of movement of Vehicle
     */
	public final void changeDirection() {
	    this.moveRight = !getMoveRight();
    }

}
