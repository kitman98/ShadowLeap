import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public abstract class Sprite {

	private Position position;
	private String imageSrc;
	private Image image;

	public Sprite() {}


	/*
	public void update(Input input, int delta) {
		// How can this one method deal with different types of sprites?
	}

	*/
	
	public void render() {
		this.getImage().draw(this.getPosition().getxPos(), this.getPosition().getyPos());
	}
	
	public void contactSprite(Sprite other) {
		// Should be called when one sprite makes contact with another. 
	}


	/* getters */
	public String getImageSrc() {
		return this.imageSrc;
	}

	public Image getImage() {
		return this.image;
	}

	public Position getPosition() {
		return this.position;
	}


	/* setters */

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public void setImage(String imageSrc) throws SlickException {
		this.image = new Image(imageSrc);
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
