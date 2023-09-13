import java.util.Objects;

public class Point {
    private final int x;
    private final int y;
    public Point ( int xPos , int yPos ){
        x=xPos ;
        y=yPos ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean isOnXAxis() {
        return (y == 0);
    }

}
