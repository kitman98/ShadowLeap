public class DetailsArray {
    String[] details;

    public DetailsArray() {

    }

    public DetailsArray(String[] details) {
        setDetails(details);
    }

    public boolean isTile() {
        if (this.getDetails().length == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMovingObject() {
        if (this.getDetails().length == 5) {
            return true;
        } else {
            return false;
        }
    }

    /* getters */
    public String[] getDetails() {
        return this.details;
    }

    /* setters */
    public void setDetails(String[] details) {
        this.details = details;
    }
}
