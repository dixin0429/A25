package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * ˫������
 */
public class K {

    private class Node {
        //����ڵ������
        private String data;
        //ָ���ϸ��ڵ������
        private Node prev;
        //ָ���¸��ڵ������
        private Node next;

        //��ʼ��ȫ�����ԵĹ�����
        public Node(String data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
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
    public K() {
        //������header��tail����null
        header = null;
        tail = null;
    }

    //ͷ�鷨
    public void addHeader(String data) {
        this.header = new Node(data, null, header);
        if (tail == null) {
            tail = header;

        }
        size++;

    }

    //��β������
    public void addTail(String data) {
        if (header == null) {
            header = new Node(data, null, null);
        } else {
            Node node = new Node(data, tail, null);
            tail.next = node;
            tail = node;

        }
        size++;

    }

    /**
     * @param index:Ҫ��������ڵ��������
     * @return ��������ָ�����Ǹ��ڵ�
     */
    public Node getNodeByIndex(int index) {
        Node currentNode = header;//�����ͷ��

        for (int i = 0; i < size; i++) {
            if (i == index) {//�ҵ���

                return currentNode;
            }
            currentNode = currentNode.next;

        }

        return currentNode;

    }

    /**
     *
     * @param index Ҫɾ���ڵ������
     * @return ɾ���ڵ������
     */
    public String delete(int index){
        Node del=null;
        if(index==0){
            del=header;
            header=header.next;

        }else{//����������һ���ڵ�
            Node prev=this.getNodeByIndex(index-1);//Ҫɾ���ڵ��ǰһ���ڵ�
            del=prev.next;
            prev.next=del.next;
            del.next.prev=del.prev;
        }

        del.next=null;
        del.prev=null;
        return del.data;

    }
    /**
     * @param data��Ҫ�������������
     * @param index         �ڸ�����������
     */
    public void insert(String data, int index) {

        if (index < 0 || index >= size) {
            System.out.println("Խ����");
        } else {
            if (header == null) {//����ʽ�ṹ�Ƿ��нڵ㣬���û�У��ȼ�һ��
                this.addTail(data);

            } else {

                if (index == 0) {

                    this.addHeader(data);
                } else {
                    Node node = this.getNodeByIndex(index - 1);
                    Node current = new Node(data, node, node.next);
                    node.next.prev = current;
                    node.next = current;//�ȿ����棬�ڸ�ֵ���嵽�Ͻڵ����һ���ڵ��ǰһ��λ��


                }
            }
            size++;

        }

    }
    @Test
    public void ok(){
        this.addHeader("A");
        this.addTail("B");
        this.addHeader("C");
        this.insert("D",1);
        this.delete(2);
        this.insert("E",1);
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for(Node current=header;current!=null;current=current.next){

            sb.append(current.data);
        }


        return sb.toString();
    }
}
