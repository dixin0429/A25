package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * ��������˳��洢
 */
public class C {



    //ʹ����������¼���������нڵ�
    private Object[] datas;
    private int DEFAULT_DEEP = 8;
    //������������
    private int deep;
    private int arraySize;//�������ܽڵ�ĸ���
    //��Ĭ�ϵ����������������
    public void init(String data){
        this.deep = DEFAULT_DEEP;
        //�������ܽڵ�ĸ���
        this.arraySize = (int)Math.pow(2 , deep) - 1;//�Ǹ���ʽ,�������������Ľڵ����
        datas = new Object[arraySize];
        datas[0]=data;//���ڵ�
    }
    public C(){

    }
    /**
     * Ϊָ���ڵ�����ӽڵ㡣
     * @param index ��Ҫ����ӽڵ�ĸ��ڵ������
     * @param data ���ӽڵ������
     * @param left �Ƿ�Ϊ��ڵ�
     */
    public void add(int index , String data , boolean left){
        if(datas[index]==null){
            System.out.println("û�и��ڵ�");
            return ;
        }
        if(2*index+1>=this.arraySize){//����Խ���ˣ��������
            System.out.println("���ˣ��������");
            return ;
        }

        if(left){//��
            datas[2*index+1]=data;
        }else{//��
            datas[2*index+2]=data;
        }
    }

    /**
     *
     * @param index :���ڵ�
     * @return ������
     */
    public String left(int index){
        return datas[2*index+1].toString();
    }

    /**
     *
     * @param index :���ڵ�
     * @return ������
     */
    public String right(int index){
        return datas[2*index+2].toString();
    }
    @Test
    public void test(){
        init("A");
        this.add(0,"B",true);
        this.add(0,"C",false);

        System.out.println(this.left(0));
        System.out.println(this.right(0));
    }

}
