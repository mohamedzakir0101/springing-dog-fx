package sons.mamoun;


import java.util.ArrayList;
import java.util.List;

public class Square {

    private  String color;
    private  int index;

    private List<Move> moves = new ArrayList<>();



    static final public String WHITE = "white";
    static final public String BLACK = "black";
    static final public String EMPTY = "empty" ;

    public Square(String state, int index) {
        this.color = state;
        this.index = index;
    }

    public Square() {
        index = -1;
    }


    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void inverse_all()
    {
        index = 24 - index;
        if (moves.isEmpty()  ) return;
        moves.forEach(Move::inverse);

    }


    public  String getSummary() { return     color + " " + index; }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIndex() {
        return index;
    }


    @Override
    public String toString() {
        return "Square{" +
                "color='" + color + '\'' +"\n" +
                ", index=" + index +"\n" +
                ", moves=" + moves +"\n" +
                '}';
    }


}
