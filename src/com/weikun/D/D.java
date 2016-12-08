package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/8.
 * 无向图的邻接表表示方法
 */
public class D {

    private class ENode {
        int tp;       // 该边所指向的顶点的位置
        ENode nextEdge; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        String data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };
    private VNode[] top;  // 顶点数组
    private int getPosition(String[] vexs,String key){
        for(int i=0;i< vexs.length;i++){
            if(vexs[i].equals(key)){

                return i;

            }
        }
        return -1;
    }
    /**
     *
     * @param vexs 顶点集合
     * @param edges 边集合
     */
    public void init(String[] vexs, String[][] edges){
        int len=vexs.length;
        int elent=edges.length;//边的个数
        top=new VNode[len];//开空间
        for(int i=0;i<len;i++){
            VNode node=new VNode();
            node.data=vexs[i];
            node.firstEdge=null;
            top[i]=node;//声明了顶点数组。

        }
        //初始化边
        for(int i=0;i<elent;i++){
            int pos1=this.getPosition(vexs ,edges[i][0]);//A
            int pos2=this.getPosition(vexs ,edges[i][1]);//B

            ENode eNode=new ENode();//A--B
            eNode.tp=pos2;
            if(top[pos1].firstEdge==null){//已经有节点了

                top[pos1].firstEdge=eNode;
            }else{
                linkNode(top[pos1].firstEdge,eNode);
            }

            ENode eNode2=new ENode();//B--A
            eNode2.tp=pos1;
            if(top[pos2].firstEdge==null){//

                top[pos2].firstEdge=eNode2;
            }else{
                linkNode(top[pos2].firstEdge,eNode2);
            }

        }


    }
    @Test
    public void test(){
        String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//无向图，全部表示节点之间的关系即可
                {"V0", "V1"},
                {"V0", "V2"},
                {"V0", "V3"},
                {"V1", "V2"},
                {"V3", "V2"}
        };
        // 自定义"图"(输入矩阵队列)
        //pG = new ListUDG();
        // 采用已有的"图"
        this.init(vexs,edges);

        this.print();   // 打印图
    }
    private void linkNode(ENode o,ENode n){
        ENode t=o;
        while(o.nextEdge!=null ){
            o=o.nextEdge;
        }
        t.nextEdge=n;
    }

    /*
     * 打印矩阵队列图
     */
    public void print() {
        System.out.printf("List Graph:\n");
        //top顶点数组
        for (int i = 0; i < top.length; i++) {
            System.out.printf("%d(%s): ", i, top[i].data);
            ENode node = top[i].firstEdge;//链表的顶点
            while (node != null) {         //node.tp该边所指向的顶点在数组中的的位置
                System.out.printf("%d(%s) ", node.tp, top[node.tp].data);
                node = node.nextEdge;
            }
            System.out.printf("\n");
        }
    }
}
