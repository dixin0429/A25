package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/6.
 * 二叉树的顺序存储
 */
public class C {



    //使用数组来记录该树的所有节点
    private Object[] datas;
    private int DEFAULT_DEEP = 8;
    //保存该树的深度
    private int deep;
    private int arraySize;//二叉树总节点的个数
    //以默认的深度来创建二叉树
    public void init(String data){
        this.deep = DEFAULT_DEEP;
        //二叉树总节点的个数
        this.arraySize = (int)Math.pow(2 , deep) - 1;//是个公式,按满二叉树开的节点个数
        datas = new Object[arraySize];
        datas[0]=data;//根节点
    }
    public C(){

    }
    /**
     * 为指定节点添加子节点。
     * @param index 需要添加子节点的父节点的索引
     * @param data 新子节点的数据
     * @param left 是否为左节点
     */
    public void add(int index , String data , boolean left){
        if(datas[index]==null){
            System.out.println("没有父节点");
            return ;
        }
        if(2*index+1>=this.arraySize){//左子越界了，不能添加
            System.out.println("满了，不能添加");
            return ;
        }

        if(left){//左
            datas[2*index+1]=data;
        }else{//右
            datas[2*index+2]=data;
        }
    }

    /**
     *
     * @param index :父节点
     * @return ：左子
     */
    public String left(int index){
        return datas[2*index+1].toString();
    }

    /**
     *
     * @param index :父节点
     * @return ：右子
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
