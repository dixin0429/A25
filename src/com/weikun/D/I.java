package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/10.
 * 克鲁斯卡尔的最小生成树
 */
public class I {
    private static final int INF = Integer.MAX_VALUE;
    private int ecount;        // 边的数量edge count
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
        //统计合法边的数量，不含自己到自己，不含没有连接的边

        for(int i=0;i<this.mVexs.length;i++){
            for(int j=i+1;j<this.mVexs.length;j++){
                if(this.mMatrix[i][j]!=INF){

                    this.ecount++;
                }

            }

        }
        this.krusker();



    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    };

    public void krusker(){
        int index=0;
        //保存有效地边集合
        EData [] res=new EData[this.ecount];
        //保存结果顶点
        int result[]=new int[this.mVexs.length];

        EData [] data=this.getEdges();
        //排序边元素
        sortEdges(data,this.ecount);

        for(int i=0;i<this.ecount;i++){
            int start =this.getPosition(data[i].start);
            int end =this.getPosition(data[i].end);
            //start所连接的末尾点
            int s1=this.getEnd(result,start);
            //end所连接的末尾点
            int e1=this.getEnd(result,end);
            if(s1!=e1){//确实没有形成回路

                result[s1]=e1;//标记s1作为起点 e1作为终点

                res[index++]=data[i];//真正的没有形成回路的有效边
            }

        }


        // 统计并打印"kruskal最小生成树"的信息
        int length = 0;
        for (int i = 0; i < index; i++){
            length += res[i].weight;
        }
        System.out.printf("Kruskal=%d: ", length);
        for (int i = 0; i < index; i++){
            System.out.printf("(%c,%c) ", res[i].start, res[i].end);
        }




    }

    /**
     * 判断
     * @param  ：结果顶点集合
     * @param i :顶点所有
     * @return：在结果中和他相连的集合的位置
     */
    private int getEnd(int[] result, int i) {
        while(result[i]!=0){//代表i所在的末尾点存在

            i=result[i];
        }
        return i;

    }

    /**
     *
     * @return //统计边对象数组
     */
    public  EData [] getEdges(){
        EData [] data=new EData[this.ecount];
        int index=0;
        for(int i=0;i<this.mVexs.length;i++){
            for(int j=i+1;j<this.mVexs.length;j++){
                if(this.mMatrix[i][j]!=INF){
                    data[index++]=new EData(this.mVexs[i],this.mVexs[j],this.mMatrix[i][j]);;
                }
            }

        }

        return data;
    }

    /**
     *
     * @param edges:有效边的集合
     * @param elen:：有效边的的数量
     */

    private void sortEdges(EData[] edges, int elen) {

        for(int i=0;i<elen;i++){
            for(int j=i+1;j<elen;j++){
                EData temp=null;
                if(edges[i].weight>edges[j].weight){
                    temp=edges[j];
                    edges[j]=edges[i];
                    edges[i]=temp;
                }
            }
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

