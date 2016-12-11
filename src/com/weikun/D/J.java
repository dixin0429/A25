package com.weikun.D;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2016/12/11.
 * 迪杰斯特拉最短路径
 */
public class J {
    /*
	 * Node对象用于封装节点信息，包括名字和子节点
	 */
    public class Node {
        private String name;
        //子节点
        private Map<Node,Integer> child=new HashMap<Node,Integer>();
        public Node(String name){
            this.name=name;
        }
        public String getName() {
            return name;
        }

        public Map<Node, Integer> getChild() {
            return child;
        }

    }
    /*
	 * Dijkstra对象用于计算起始节点到所有其他节点的最短路径
	 */
    private Set<Node> open=new HashSet<Node>();//open用于存储未遍历的点
    private Set<Node> close=new HashSet<Node>();//close用来存储已遍历的节点
    private Map<String,Integer> path=new HashMap<String,Integer>();//源点到任意顶点的封装路径距离
    @Test
    public void init(){


        path.put("V1", 1);
        path.put("V2", 5);
        path.put("V3", Integer.MAX_VALUE);
        path.put("V4", Integer.MAX_VALUE);

        path.put("V5", Integer.MAX_VALUE);
        path.put("V6", Integer.MAX_VALUE);
        path.put("V7", Integer.MAX_VALUE);
        path.put("V8", Integer.MAX_VALUE);

        Node v0=new MapBuilder().build1(open,close);
        System.out.println("V0");
        djstela(v0);
    }

    /**
     *
     * @param node :要搜索的点
     * @return ：和要搜索的点的最小权值的临近点
     */
    private Node getShortestPath(Node node){
        Map<Node, Integer> children=node.getChild();
        Set<Node> s=children.keySet();
        Iterator<Node> it=s.iterator();
        int tmp=Integer.MAX_VALUE;
        Node n=null;
        while(it.hasNext()){
            Node res=it.next();
            if(open.contains(res)){//没遍历
                Integer weight=children.get(res);
                if(weight<tmp){
                    tmp=weight;
                    n=res;
                }
            }


        }
        return n;

    }

    /**
     *
     * @param node
     */
    public void djstela(Node node){
        //1找到node指定的最短权值节点
        Node nearest=this.getShortestPath(node);
        if(nearest==null){
            return ;
        }
        close.add(nearest);
        open.remove(nearest);
        System.out.println(nearest.getName());

        //2再找到nearest的所有临近点，看源点到nearest的临近点的路径是否比直接到nearest路径小
        //找出所有nearest的孩子
        Map<Node,Integer> children=nearest.getChild();

        Set <Node> s=   children.keySet() ;

        Iterator<Node> it=s.iterator();

        while(it.hasNext()){

            Node key=it.next();
            if(open.contains(key)){//如果已经证明没有被访问

                int weight1=children.get(key);//通过key找到权值，到nearest的权值

                //源点到nearest临近点的距离
                int weight2=path.get(key.getName());
                //再找到nearest的所有临近点，看源点到nearest的临近点的路径是否比直接到nearest路径小
                //如果小：要把从源点到nearest的权值更新
                int i=path.get(nearest.getName());
                if((i+weight1)<weight2){
                    System.out.println(i+weight1);
                    path.put(key.getName(),i+weight1);
                }

            }

        }

        this.djstela(nearest);
    }


    //初始化数据源，返回源点
    public class MapBuilder {
        //open:代表没有访问过的源点集合，close：访问过的源点集合
        public Node build1(Set<Node> open, Set<Node> close){

            Node node0=new Node("V0");
            Node node1=new Node("V1");
            Node node2=new Node("V2");
            Node node3=new Node("V3");
            Node node4=new Node("V4");
            Node node5=new Node("V5");
            Node node6=new Node("V6");
            Node node7=new Node("V7");
            Node node8=new Node("V8");

            node0.getChild().put(node1, 1);//V0--V1
            node0.getChild().put(node2, 5);//V0--V2

            node1.getChild().put(node0, 1);
            node1.getChild().put(node2, 3);
            node1.getChild().put(node3, 7);
            node1.getChild().put(node4, 5);

            node2.getChild().put(node0, 5);
            node2.getChild().put(node1, 3);
            node2.getChild().put(node4, 1);
            node2.getChild().put(node5, 7);

            node3.getChild().put(node1, 7);
            node3.getChild().put(node4, 2);
            node3.getChild().put(node6, 3);

            node4.getChild().put(node1, 5);
            node4.getChild().put(node2, 1);
            node4.getChild().put(node3, 2);
            node4.getChild().put(node5, 3);
            node4.getChild().put(node6, 6);
            node4.getChild().put(node7, 9);

            node5.getChild().put(node2, 7);
            node5.getChild().put(node4, 3);
            node5.getChild().put(node7, 5);


            node6.getChild().put(node3, 3);
            node6.getChild().put(node4, 6);
            node6.getChild().put(node7, 2);
            node6.getChild().put(node8, 7);


            node7.getChild().put(node4, 9);
            node7.getChild().put(node6, 2);
            node7.getChild().put(node8, 4);

            node8.getChild().put(node6, 7);
            node8.getChild().put(node7, 4);



            open.add(node1);
            open.add(node2);
            open.add(node3);
            open.add(node4);
            open.add(node5);
            open.add(node6);
            open.add(node7);
            open.add(node8);

            close.add(node0);

            return node0;

        }

    }

}
