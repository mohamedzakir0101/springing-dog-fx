package sons.mamoun;

import java.util.ArrayList;
import java.util.List;

public class SquareWrapper {
  private SquareList _embedded;

    public SquareWrapper(SquareList _embedded) {
        this._embedded = _embedded;
    }

    public SquareWrapper() {
    }

    public SquareList get_embedded() {
        return _embedded;
    }
    public List<Square> get_square_list ()  {return  _embedded.getSquareList();}

    public void set_embedded(SquareList _embedded) {
        this._embedded = _embedded;
    }

    @Override
    public String toString() {
        return "Wrapper{" + "\n" +
                "_embedded=" + _embedded +"\n" +
                '}';
    }
}




class SquareList {
   private List<Square> squareList = new ArrayList<>();

    public SquareList(List<Square> squareList) {
        this.squareList = squareList;
    }

    public List<Square> getSquareList() {
        return squareList;
    }

    public void setSquareList(List<Square> squareList) {
        this.squareList = squareList;
    }

    @Override
    public String toString() {
        return "EntityModelList{" +
                "squareList=" + squareList +
                '}';
    }
}