package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * ��������
 */
public class J {

    public class Node{
        //����ڵ������
        public String data;
        //ָ���¸��ڵ������
        private Node next;

        //��ʼ��ȫ�����ԵĹ�����
        public Node(String data , Node next)	{
            this.data = data;
            this.next = next;
        }

    }

    //����������ͷ�ڵ�
    private Node header;
    //����������β�ڵ�
    private Node tail;
    //������������Ѱ����Ľڵ���
    private int size;
    //����������
    public J() {
        // TODO Auto-generated constructor stub
        header=null;
        tail=null;
    }
    //��β������
    public void addTail(String data){
        if(header==null){
            header=new Node(data,null);
        }else{
            Node node= new Node(data,null);
            tail.next=node;
            tail=node;

        }
        size++;

    }

    /**
     *
     * @param index:Ҫ��������ڵ��������
     * @return ��������ָ�����Ǹ��ڵ�
     */
    public Node getNodeByIndex(int index){
        Node currentNode=header;//�����ͷ��

        for(int i=0;i<size;i++){
            if(i==index){//�ҵ���

                return currentNode;
            }
            currentNode=currentNode.next;

        }

        return currentNode;

    }

    /**
     *
     * @param data��Ҫ�������������
     * @param index �ڸ�����������
     */
    public void insert(String data,int index){

        if(index<0 || index>=size){
            System.out.println("Խ����");
        }else{
            if(header==null){//����ʽ�ṹ�Ƿ��нڵ㣬���û�У��ȼ�һ��
                this.addTail(data);

            }else{

                if(index==0){

                    this.addHeader(data);
                }else{
                    Node node=this.getNodeByIndex(index-1);

                    node.next=new Node(data,node.next);//�ȿ����棬�ڸ�ֵ���嵽�Ͻڵ����һ���ڵ��ǰһ��λ��

                }
            }
            size++;

        }


    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(Node current=header;current!=null;current=current.next){

            sb.append(current.data);
        }


        return sb.toString();
    }

    public String delete(int index){
        Node del=null;
        if(index==0){
            del=header;
            header=header.next;

        }else{//����������һ���ڵ�
            Node prev=this.getNodeByIndex(index-1);//Ҫɾ���ڵ��ǰһ���ڵ�
            del=prev.next;
            prev.next=del.next;
        }

        del.next=null;
        return del.data;

    }
    //ͷ�鷨
    public void addHeader(String data){
        this.header=new Node(data,header);
        if(tail==null){
            tail=header;

        }
        size++;

    }
    @Test
    public void ok(){
        this.addHeader("a");
        this.addHeader("b");

        this.addTail("c");

        this.insert("d",1);
        this.delete(2);
        System.out.print(this);



    }

}
