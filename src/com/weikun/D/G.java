package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * 无向图的邻接矩阵表示
 */
public class G {

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

    //构造无向图
    public void make(char[] mvexs,int [][] mmatrix){
        //初始化顶点
        this.mVexs=mvexs;
        //初始化边


    }

    /**
     *
     * @param c 要查找的顶点
     * @return 在顶点数组中的索引号
     */
    public int getPosition(char c){

        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i]==c){
                return i;
            }

        }
        return -1;

    }

    public  void DFS(){
        boolean [] visited=new boolean[this.mVexs.length];
        for(int i=0;i<this.mVexs.length;i++){
            if(!visited[i]){
                DFS(i,visited);
            }
        }

    }
    public void BFS(){
        int head = 0;//队列的头
        int rear = 0;//队列的尾
        int []queue=new int[this.mVexs.length];//辅助队列

        boolean []visited=new boolean[this.mVexs.length];

        for(int i=0;i<this.mVexs.length;i++){

            if(!visited[i]){
                queue[rear++]=i;//入已经被访问的队列，从尾入
                visited[i]=true;//已经访问了
                System.out.printf("%c",this.mVexs[i]);
            }
            //吐出队列值
            while(head!=rear){
                int j=queue[head++];//顶点索引
                int k=firstVertex(j);//找到其第一个邻接点

                while(k>=0){

                    if(!visited[k]){
                        queue[rear++]=k;//入已经被访问的队列，从尾入
                        visited[k]=true;//已经访问了
                        System.out.printf("%c",this.mVexs[k]);
                    }
                    //i始终是在本行找，i就是本行索引，当本行完事，且没有找到 k=-1,跳出内层循环
                    k=this.nextVertex(j,k);//下个邻接点索引

                }



            }

        }


    }

    /**
     *
     * @param v:查找的顶点索引
     * @return 返回的是查找的顶点的第一个临近点的索引
     */
    private int firstVertex(int v) {

        for(int i=0;i<this.mVexs.length;i++){
            if(this.mMatrix[v][i]==1){
                return i;
            }
        }
        return -1;
    }

    private void DFS(int i, boolean[] visited) {
        visited[i]=true;//代表该订点已经访问过了
        System.out.printf("%c",this.mVexs[i]);
        //去查找i所代表的顶点邻接的第一个节点
        int j=this.firstVertex(i);//j就是第一个邻接点的索引

        while(j>=0){
            if(visited[j]==false){
                DFS(j,visited);
            }
            ///第一次发现了有节点已经被访问了，才用的以下方法
            //
            j=nextVertex(i,j);//k代表的是下个邻接点的索引
        }
    }

    /**
     *
     *
     * @param i :顶点索引
     * @param j：顶点的第一个邻接点的索引
     * @return 下一个邻接点的索引
     */
    private int nextVertex(int i, int j) {

        for(int k=j+1;k<this.mVexs.length;k++){
            if(this.mMatrix[i][k]==1){
                return k;
            }
        }
        return -1;//代表没有找到
    }

    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
        char[][] edges = new char[][]{//边是个二维数组
                {'A', 'B'},
                {'A', 'F'},
                {'B', 'G'},
                {'B', 'C'},
                {'B', 'I'},
                {'B', 'A'},
                {'C', 'B'},
                {'C', 'I'},
                {'C', 'D'},
                {'D', 'C'},
                {'D', 'I'},
                {'D', 'G'},
                {'D', 'H'},
                {'D', 'E'},
                {'E', 'H'},
                {'E', 'F'},
                {'E', 'D'},
                {'F', 'G'},
                {'F', 'A'},
                {'F', 'E'},
                {'G', 'H'},
                {'G', 'D'},
                {'G', 'B'},
                {'G', 'F'},
                {'H', 'G'},
                {'H', 'D'},
                {'H', 'E'},
                {'I', 'B'},
                {'I', 'C'},
                {'I', 'D'}

        };

        this.mVexs=vexs;
        //二维矩阵，里面存的是每个顶点的索引
        this.mMatrix=new int[this.mVexs.length][this.mVexs.length];
        for(int i=0;i<edges.length;i++){//遍历顶点集合了，看哪两个顶点组成弧，组成弧的值就是1
            int pos1=this.getPosition(edges[i][0]);
            int pos2=this.getPosition(edges[i][1]);

            this.mMatrix[pos1][pos2]=1;
        }
        this.print();

        DFS();
        System.out.println();
        BFS();

    }
    public void print(){

        for(int i=0;i<this.mVexs.length;i++){
            for(int j=0;j<this.mVexs.length;j++){

                System.out.printf("%d ",this.mMatrix[i][j]);

            }
            System.out.println();

        }
    }
}
