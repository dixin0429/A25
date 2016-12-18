package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/18.
 */
public class B {

    private int size;// 当前容量
    private static int INIT_CAPACITY = 16;// 默认容量
    private Entity[] container;// 实际存储数据的数组对象
    private static float LOAD_FACTOR = 0.75f;// 值越大，代表其max越大，代表元素越多，越拥挤
    private int max;// 能存的最大的数=capacity*factor
    public  B(){
        //this(INIT_CAPACITY,LOAD_FACTOR);

        max=(int)(INIT_CAPACITY*LOAD_FACTOR);
        INIT_CAPACITY=INIT_CAPACITY;
        LOAD_FACTOR=LOAD_FACTOR;
        container=new Entity[INIT_CAPACITY];//开辟容器空间
    }


//    public  B(int init_capacity,float load_factor){
//        max=(int)(init_capacity*load_factor);
//        INIT_CAPACITY=init_capacity;
//        LOAD_FACTOR=load_factor;
//        container=new Entity[INIT_CAPACITY];//开辟容器空间
//    }
//
    @Test
    public void test(){
        long start=System.currentTimeMillis();

        for(int i=0;i<1000000;i++){
            this.put(i,""+i*10);
        }
        long end=System.currentTimeMillis();
        System.out.println("插入元素时间是："+(end-start));
        System.out.println( this.get(98));
    }
    public String get(Integer key){

        Entity e=null;
        int hash=key.hashCode();

        int index=this.indexFor(hash,this.container.length);

        e=this.container[index];
        if(e==null){
            return null;
        }
        while(e!=null){
            if((key==e.key)){
                return e.value;
            }

            e=e.next;
        }

        return null;
    }



    /**
     *
     * @param k:将要存储的键
     * @param v:将要存储的值
     * @return
     */
    public boolean put(Integer k, String v) {
        int h=k.hashCode();
        Entity e=new Entity(k,v,h);
        if(this.findEntity(e,container)){
            size++;
            return true;
        }

        return false;
    }

    /**
     *
     * @param hashcode key的hash码
     * @param containerLength ：容器的长度
     * @return:即将存储在容器中的那个索引号 不能保证唯一。
     */
    public int indexFor(int hashcode, int containerLength) {
        return hashcode & (containerLength-1);


    }

    /**
     *
     * @param e 新对象
     * @param container：容器
     * @return如果新对象在容器里面存在，返回为true，否则返回为false
     */
    private boolean findEntity(Entity e, Entity[] container) {
        int index=this.indexFor(e.hash,container.length);//计算出了数组下标
        Entity temp=container[index];
        if(temp!=null){//代表该索引下的元素已经存在，存在后，我们只能采用单向链表的形式，把元素放到此链表的最后。
            while(temp!=null){
                if((e.key==temp.key)&&(e.hash==temp.hash)&&(e.value.equals(temp.value))){//判断该新元素e是否和容器的元素相等，如果完全相等，那么不允许添加
                    return false;
                }else{//允许添加

                   if(temp.next==null){
                       break;
                   }

                }

                temp=temp.next;

            }
            //加入新元素到队尾
            this.addEntry2Last(e,temp);//对每个元素的链表操作，一旦有重复值，加到它的链表中
        }
        //将元素【已经排列好的，】插入到数组中。
         setFirstEntry(e,index,container);


        return true;
    }

    /**
     *
     * @param e:新元素
     * @param index:新元素的索引号
     * @param table :新的容器
     */
    private void setFirstEntry(Entity e, int index, Entity[] table) {
        if(size>max){
            reSize(table.length*4);
        }
        table[index]=e;
        e.next=null;
    }



    /**
     *
     * @param entry:将要加入的新元素
     * @param last:循环到末尾的老元素
     */
    private void addEntry2Last(Entity entry, Entity last) {
        if(size>max){//扩容
            reSize(this.container.length*4);

        }
        last.next=entry;



    }


    /**
     *
     * @param newSize :开辟新数组的大小，扩容
     */
    private void reSize(int newSize) {

        this.max=(int)(newSize*this.LOAD_FACTOR);//形成新的max值
        Entity [] newContainer=new Entity[newSize];//新容器

        for(int i=0;i<this.container.length;i++){
            Entity temp=this.container[i];
            while(temp!=null){
                this.findEntity(temp,newContainer);
                temp=temp.next;
            }
        }
        this.container=newContainer;

    }


    class Entity{
        Entity next;//采用挂链法，也就是说 同一个hash码中的不同子元素,next存储的是下个元素的地址
        Integer key;//1 10
        String value;
        int hash;
        Entity(Integer key ,String value,int hash){
            this.key=key;
            this.value=value;
            this.hash=hash;
        }
    }
}
