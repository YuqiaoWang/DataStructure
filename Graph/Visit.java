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