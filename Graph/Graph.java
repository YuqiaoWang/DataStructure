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








public class Visit {
    public void print(Object item) {
        System.out.print(item + " ");
    }

    private void depthFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
        //连通图以 v 为初始结点序号，访问操作为 vs 的深度优先遍历
        //数组visited 标记了相应结点是否已访问过， 0表示未访问，1表示已访问
        vs.print(getValue(v));      //访问该结点
        visited[v] = true;          //置已访问标记

        int w = getFirstNeighbor(v);        //取第一个邻接结点
        while(w != -1) {                    //当邻接结点存在时循环
            if(!visited[w]) {               //如果没有访问过
                depthFirstSearch(w, visited, vs);       //以 w 为初始结点递归
                }
            w = getNextNeighbor(v, w);      //取下一个邻接结点
        }
    }

    private void broadFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
        //连通图以 v 为初始结点序号、访问操作为 vs 的广度优先遍历
        //数组 visited 标记了相应结点是否已访问过， 0表示未访问，1表示已访问
        int u, w;
        SeqList queue = new SeqList();

        vs.print(getValue(v));
        visited[v] = true;

        queue.append(new Integer(v));
        while(!queue.isEmpty()) {
            u = ((Integer)queue.delete()).intValue();
            w = getFirstNeighbor(u);
            while(w != -1) {
                if(!visited[w]) {
                    vs.print(getValue(w));
                    visited[w] = true;
                    queue.append(new Integer(w));
                }

                w = getNextNeighbor(u, w);
            }
        }
    }
}


public class MiniSpanTree{
    Object vertex;
    int weight;

    MiniSpanTree() {

    }

    MiniSpanTree(Object obj, int w) {
        vertex = obj;
        weight = w;
    }
}






