public class Dijkstra{
    static final int maxWeight = 9999;

    public static void dijkstra(AdjMWGraph g, int v0, int[] distance, 
                    int path[]) throws Exception{
        int n = g.getNumOfVertices();
        int[] s = new int[n];       //用来存放n个结点的标记
        int minDis, u = 0;

        //初始化
        for(int i = 0; i < n; i++) {
            distance[i] = g.getWeight(v0, i);
            s[i] = 0;               //初始标记为0
            if(i != v0 && distance[i] < maxWeight) {
                path[i] = v0;       //初始的目标结点的前一结点均为v0
            }else {
                path[i] = -1;
            }
        }
        s[v0] = 1;

        //在当前还未找到最短路径的结点集合中选取具有最短距离的结点u
        for(int i = 1; i < n; i++) {
            minDis = maxWeight;
            for(int j = 0; j < n; j++) {
                if(s[j] == 0 && distance[j] < minDis) {
                    u = j;
                    minDis = distance[j];
                }
                //当已不存在路径时算法结束
                if(minDis == maxWeight) return;

                s[u] = 1;           //标记结点u已从集合T加入到集合S中

                //修改从v0到其他结点的最短距离和最短路径
                for(int j = 0; j < n; j++) {
                    if(s[j] == 0 && g.getWeight(u, j) < maxWeight && 
                            distance[u] + g.getWeight(u, j) < distance[j]) {
                            //结点 v0 经结点 u 到其他结点的最短距离和最短路径
                            distance[j] = distance[u] + g.getWeight(u, j);
                            path[j] = u;
                    }
                }
            }
        }
    }

    
}