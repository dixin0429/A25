package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * 带权值的有向图的邻接矩阵表示
 */
public class C {

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
    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D'};
        //无向图是,无向图和有向图代码一致，只不过无向图AB两个顶点，边表示是A->B B->A
        char[][] edges = new char[][]{//边是个二维数组
                {'A', 'B'},//1
                {'B', 'C'},//2
                {'C', 'D'},//3
                {'A', 'D'},//4
                {'A', 'C'}//5
        };
        int []weights=new int[]{1,2,3,4,5};

        this.mVexs=vexs;
        //二维矩阵，里面存的是每个顶点的索引
        this.mMatrix=new int[this.mVexs.length][this.mVexs.length];
        for(int i=0;i<edges.length;i++){//遍历顶点集合了，看哪两个顶点组成弧，组成弧的值就是1
            int pos1=this.getPosition(edges[i][0]);
            int pos2=this.getPosition(edges[i][1]);

            this.mMatrix[pos1][pos2]=weights[i];
        }
        this.print();



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
