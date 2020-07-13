package sons.mamoun;


import java.util.Objects;

public class Move {

    private Integer to;

    private Integer death;


    public Move(Integer dist, Integer death) {
        this.to = dist;
        this.death = death;
    }

    public Move() {
    }

    public void inverse()
    {
    to = 24- to;
    if(death != null) death =24-death    ;
    }



    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(to, move.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to);
    }

    @Override
    public String toString() {
        return "Move{" +
                "\t" + "dist=" + to +"\n" +
                "\t" +  ", death=" + death +"\n" +
                '}';
    }
}
