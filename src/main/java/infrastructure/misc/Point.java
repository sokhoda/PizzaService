package infrastructure.misc;

public class Point {
    private int x;
    private int y;
    private int z;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) return  false;
        if (obj == this) return true;
        Point other = (Point) obj;
        if (x == other.x && y == other.y) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result ;
        result = 31 * (31 * x + y) + z;
        return result;
    }
}
