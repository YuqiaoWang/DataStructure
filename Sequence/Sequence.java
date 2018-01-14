
public interface Sequence extends Vector, List {
    public Position rank2Pos(int r);
    public int pos2Rank(Position p) throws Exception;
}