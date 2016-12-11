package com.weikun.D;

import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2016/12/11.
 * �Ͻ�˹�������·��
 */
public class J {
    /*
	 * Node�������ڷ�װ�ڵ���Ϣ���������ֺ��ӽڵ�
	 */
    public class Node {
        private String name;
        //�ӽڵ�
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
	 * Dijkstra�������ڼ�����ʼ�ڵ㵽���������ڵ�����·��
	 */
    private Set<Node> open=new HashSet<Node>();//open���ڴ洢δ�����ĵ�
    private Set<Node> close=new HashSet<Node>();//close�����洢�ѱ����Ľڵ�
    private Map<String,Integer> path=new HashMap<String,Integer>();//Դ�㵽���ⶥ��ķ�װ·������
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
     * @param node :Ҫ�����ĵ�
     * @return ����Ҫ�����ĵ����СȨֵ���ٽ���
     */
    private Node getShortestPath(Node node){
        Map<Node, Integer> children=node.getChild();
        Set<Node> s=children.keySet();
        Iterator<Node> it=s.iterator();
        int tmp=Integer.MAX_VALUE;
        Node n=null;
        while(it.hasNext()){
            Node res=it.next();
            if(open.contains(res)){//û����
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
        //1�ҵ�nodeָ�������Ȩֵ�ڵ�
        Node nearest=this.getShortestPath(node);
        if(nearest==null){
            return ;
        }
        close.add(nearest);
        open.remove(nearest);
        System.out.println(nearest.getName());

        //2���ҵ�nearest�������ٽ��㣬��Դ�㵽nearest���ٽ����·���Ƿ��ֱ�ӵ�nearest·��С
        //�ҳ�����nearest�ĺ���
        Map<Node,Integer> children=nearest.getChild();

        Set <Node> s=   children.keySet() ;

        Iterator<Node> it=s.iterator();

        while(it.hasNext()){

            Node key=it.next();
            if(open.contains(key)){//����Ѿ�֤��û�б�����

                int weight1=children.get(key);//ͨ��key�ҵ�Ȩֵ����nearest��Ȩֵ

                //Դ�㵽nearest�ٽ���ľ���
                int weight2=path.get(key.getName());
                //���ҵ�nearest�������ٽ��㣬��Դ�㵽nearest���ٽ����·���Ƿ��ֱ�ӵ�nearest·��С
                //���С��Ҫ�Ѵ�Դ�㵽nearest��Ȩֵ����
                int i=path.get(nearest.getName());
                if((i+weight1)<weight2){
                    System.out.println(i+weight1);
                    path.put(key.getName(),i+weight1);
                }

            }

        }

        this.djstela(nearest);
    }


    //��ʼ������Դ������Դ��
    public class MapBuilder {
        //open:����û�з��ʹ���Դ�㼯�ϣ�close�����ʹ���Դ�㼯��
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
