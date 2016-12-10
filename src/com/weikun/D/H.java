package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/10.
 * Prim的最小生成树
 */
public class H {
    private static final int INF = Integer.MAX_VALUE;

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    @Test
    public void test(){

        //顶点
        char[] tops = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //INF最大值,也就是在邻接矩阵中，两个点如果没有边，就标记最大值
        //0 是自己到自己的点的标记

        int matrix1[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
         /*A*/ {   0,  12, INF, INF, INF,  16,  14},
         /*B*/ {  12,   0,  10, INF, INF,   7, INF},
         /*C*/ { INF,  10,   0,   3,   5,   6, INF},
         /*D*/ { INF, INF,   3,   0,   4, INF, INF},
         /*E*/ { INF, INF,   5,   4,   0,   2,   8},
         /*F*/ {  16,   7,   6, INF,   2,   0,   9},
         /*G*/ {  14, INF, INF, INF,   8,   9,   0}
        };
        this.mVexs=tops;
        this.mMatrix=new int[tops.length][tops.length];
        for(int i=0;i<this.mVexs.length;i++){
            for(int j=0;j<this.mVexs.length;j++){
                this.mMatrix[i][j]=matrix1[i][j];
            }

        }

        prim(0);


    }

    /**
     *
     * @param: 从0号顶点开始其算法
     */

    private void prim(int start) {

        int len=this.mVexs.length;
        char [] result=new char[len];//顶点结果数组
        int weights[]=new int[len];//权值数组

        int index=0;

        //将start所在顶点放到结果数组中
        result[index++]=this.mVexs[start];
        for(int i=0;i<len;i++){
            weights[i]=this.mMatrix[start][i];
        }
        //开始找权值最小的点
        for(int i=0;i<len;i++){

            if(start==i){//AA点没有意义,自己到自己的点
                continue;
            }
            int k=0;//同行下的最小权值列的索引
            int j=0;
            int min=INF;

            while(j<len){//遍历同一行下的所有列，看谁的权值最小，其索引放到k中

                if(weights[j]!=0&&weights[j]<min){

                    min=weights[j];
                    k=j;
                }
                j++;

            }
            //结果点
            result[index++]=this.mVexs[k];
            //由于k点已经完事，所以在权值数组中把他的权值抹去
            weights[k]=0;

            //现在已经找到了最小点是k，以下更新以k作为点的所有权值
            //因为weights是一维数组，一次只能存储最小权值所代表的索引的那个点所指的那个一行的所有权值。

            for(j=0;j<len;j++){
                if(weights[j]!=0&&this.mMatrix[k][j]<weights[j]){
                    weights[j]=this.mMatrix[k][j];

                }
            }

        }

        //生成最小生成树的权值
        //i==1代表B，A点不需要访问
        int sum=0;
        for(int i=1;i<index;i++){


            int k=this.getPosition(result[i]);//结果点，在顶点集合的索引//B
            //找到k点所在的顶点，和另外个顶点
            int min=INF;
            for(int j=0;j<i;j++){

                int n=this.getPosition(result[j]);//A

                if(this.mMatrix[n][k]<min){//代表确实小
                    min=this.mMatrix[n][k];
                }

            }
            sum+=min;
        }
        System.out.println(sum);


        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);

        }
    }

    public int getPosition(char c){//找到其在顶点集合的位置
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i]==c){
                return i;
            }
        }
        return -1;

    }
}
