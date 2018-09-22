import org.newdawn.slick.Input;

public abstract class Vehicle extends Sprite {

	private boolean moveRight;
	
	public final float getInitialX() {
		return moveRight ? -World.TILE_SIZE / 2
						 : App.SCREEN_WIDTH + World.TILE_SIZE / 2;
	}
	
	public Vehicle(String imageSrc, float x, float y, boolean moveRight, String[] tags) {
		super(imageSrc, x, y, tags);
		
		this.moveRight = moveRight;
	}
	/*
	@Override
	public void update(Input input, int delta) {
		move(SPEED * delta * (moveRight ? 1 : -1), 0);
		
		// check if the vehicle has moved off the screen
		if (getX() > App.SCREEN_WIDTH + World.TILE_SIZE / 2 || getX() < -World.TILE_SIZE / 2
		 || getY() > App.SCREEN_HEIGHT + World.TILE_SIZE / 2 || getY() < -World.TILE_SIZE / 2) {
			setX(getInitialX());
		}
	}
    */

    public void render() {
        if (hasTag(Sprite.SUBMERGES) && this instanceof Turtle) {
            if (((Boolean)((Turtle) this).getState()).equals(true)) {
                return;
            }
        }

        getImage().getFlippedCopy(!moveRight, false).drawCentered(getX(), getY());
    }

	public boolean getMoveRight() {
		return this.moveRight;
	}

	public final void changeDirection() {
	    this.moveRight = !getMoveRight();
    }

}
