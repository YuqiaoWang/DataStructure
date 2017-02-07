public class AdjMWGraph{
    static final int maxWeight = 10000;

    private SeqList vertices;
    private int[][] edge;
    private int numOfEdges;

    public AdjMWGraph(int maxV) {
        vertices = new SeqList(maxV);
        edge = new int[maxV][maxV];
        for(int i = 0; i < maxV; i++) {
            for(int j = 0; j < maxV; j++) {
                if(i == j) {
                    edge[i][j] = 0;
                }
                else{
                    edge[i][j] = maxWeight;
                }
            }
        }
        numOfEdges = 0;
    }

    public int getNumOfVertices() {
        return vertices.size;
    }

    public int getNumOfEdge() {
        return numOfEdges;
    }

    public Object getValue(int v) throws Exception{
        return vertices.getData(v);
    }

    public int getWeight(int v1, int v2) throws Exception{
        if(v1 < 0 || v1 >= vertices.size || v2 < 0 || v2 >= vertices.size) {
            throw new Exception("参数 v1 或 v2 越界出错！");
        }
        return edge[v1][v2];
    }

    public void insertVertex(Object vertex) throws Exception{
        //插入结点
        vertices.insert(vertices.size, vertex);
    }

    public void insertEdge(int v1, int v2, int weight) throws Exception{
        //插入边<v1, v2>，权为weight
        if(v1 < 0 || v2 >= vertices.size || v2 < 0 || v2 >=vertices.size) {
            throw new Exception("参数 v1 或 v2 越界出错！");
        }
        if(edge[v1][v2] == maxWeight || v1 == v2) {
            throw new Exception("这边不存在！");
        }

        edge[v1][v2] == maxWeight;
        numOfEdges--;
    }

    public int getFirstNeighbor(int v) throws Exception{
        if(v < 0 || v >= vertices.size) {
            throw new Exception("参数 v 越界出错！");
        }
        for(int col = 0; col < vertices.size; col++) {
            if(edge[v][col] > 0 && edge[v][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }

    public int getFirstNeighbor(int v) throws Exception{
        if(v < 0 || v >= vertices.size) {
            throw new Exception("参数 v 越界出错！");
        }
        for(int col = 0; col < vertices.size; col++) {
            if(edge[v][col] > 0 && edge[v][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) throws Exception{
        if(v1 < 0 || v1 >= vertices.size || v2 < 0 || v2 >= vertices.size) {
            throw new Exception("参数 v1 或 v2 越界出错！");
        }
        for(int col = v2 + 1; col < vertices.size; col++) {
            if(edge[v1][col] > 0 && edge[v1][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }
}




















