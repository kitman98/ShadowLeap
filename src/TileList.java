import java.util.ArrayList;
import java.util.Iterator;

public class TileList {

    private ArrayList<Tile> tileList = new ArrayList<>();
    private int size = tileList.size();
    private int numel = 0;

    public TileList() {

    }

    public void add(Tile tile) {

        if (this.getNumel() == this.getSize()) {
            this.getList().ensureCapacity(this.getNumel() + 1);
            this.getList().add(tile);
        }

        else {
            this.getList().add(tile);
        }

    }

    public TileList clone() {
        TileList clone = new TileList();

        Iterator<Tile> itr = this.getList().iterator();

        while (itr.hasNext()) {
            Tile tile = itr.next();

            clone.add(tile);
        }

        clone.setNumel(this.getNumel());
        clone.setSize();

        return clone;
    }


    /* getters */
    public ArrayList<Tile> getList() {
        return this.tileList;
    }

    public int getSize() {
        return this.getList().size();
    }

    public int getNumel() {
        return this.numel;
    }

    /* setters */
    private void setNumel(int numel) {
        this.numel = numel;
    }

    private void setSize() {
        this.size = this.getSize();
    }


}
