package com.weikun.D;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/12/13.
 * 有向图的拓扑排序
 */
public class K {

    // 邻接表中表对应的链表的顶点
    private class ENode {
        int itop;       // 该边所指向的顶点的位置
        ENode next; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };

    private List<VNode> mVexs;  // 顶点数组

    @Test
    public void test(){
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//顶点数组
        char[][] edges = new char[][]{//边数组，例如A->G B->A等
                {'A', 'G'},
                {'B', 'A'},
                {'B', 'D'},
                {'C', 'F'},
                {'C', 'G'},
                {'D', 'E'},
                {'D', 'F'}
        };

        int vlen=vexs.length;
        int elen=edges.length;
        mVexs=new ArrayList<VNode>();
        //初始化顶点集合
        for(int i=0;i<vlen;i++){
            VNode vNode=new VNode();
            vNode.data=vexs[i];
            vNode.firstEdge=null;
            mVexs.add(vNode);//把所有顶点对象送入顶点集合
        }
        //初始化边集合

        for(int i=0;i<elen;i++){
            char c1=edges[i][0];//A
            char c2=edges[i][1];//G

            int p1=this.getPosition(c1);//A的位置
            int p2=this.getPosition(c2);//G的位置

            ENode eNode=new ENode();
            eNode.itop=p2;

            if(this.mVexs.get(p1).firstEdge==null){//A指向的出度节点 第一次关联
                this.mVexs.get(p1).firstEdge=eNode;
            }else{//代表有多个A指向的出度节点，多次关联
                ENode old=this.mVexs.get(p1).firstEdge;
                this.linkedLast(old,eNode);

            }



        }
        sort();

    }
    public void sort(){
        int vlen=this.mVexs.size();//顶点个数
        int index=0;
        int rudu[]=new int[vlen];//入度数组

        char[] results  = new char[vlen];//存排序后结点的数组

        //统计每个顶点的入度数组，由于rudu的默认每个元素都是0，通过统计
        //每个顶点的入度，把每个元素++
        for(int i=0;i<vlen;i++){

            ENode edge=this.mVexs.get(i).firstEdge;//取出第一个弧的地址
            //形成个入度数组
            while(edge!=null){//代表有弧

                rudu[edge.itop]++;
                edge=edge.next;
            }

        }
        //将所有入度为零的顶点，入队列
        Queue<Integer> queue = new LinkedList<Integer>();// 辅助队列
        //入度为零的索引
        for(int i=0;i<vlen;i++){
            if(rudu[i]==0){
                queue.add(i);
            }
        }
        //拆边
        while(!queue.isEmpty()){

            int i=queue.poll();
            results[index++]=this.mVexs.get(i).data;//找到了入度为0的点

            ENode eNode=this.mVexs.get(i).firstEdge;//G

            //拆边核心，实际上就是让rudu数组指定的索引号--
            while(eNode!=null){

                //VNode vNode=this.mVexs.get(eNode.itop);

                rudu[eNode.itop]--;
                if(rudu[eNode.itop]==0){
                    queue.add(eNode.itop);
                }

                eNode=eNode.next;


            }



        }
        if(index!=vlen){
            System.out.println("拆解之后是个环，不能进步拆卸");
        }

        // 打印拓扑排序结果
        System.out.printf("== TopSort: ");
        for(int i = 0; i < vlen; i ++){
            System.out.printf("%c ", results[i]);
        }
        System.out.printf("\n");


    }

    /**
     *
     * @param old 老节点
     * @param newnode 新节点地址
     */
    private void linkedLast(ENode old,ENode newnode){
        ENode o=old;
        while(o.next!=null){

            o=o.next;
        }
        o.next=newnode;
    }
    /**
     *
     * @param c:要查找的字符
     * @return返回在顶点数组中的位置
     */
    public int getPosition(char c){
        for(int i=0;i<this.mVexs.size();i++){
            if(this.mVexs.get(i).data==c){//找到了
                return i;
            }

        }
        return -1;
    }

}
