package com.weikun.E;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/12/18.
 */
public class B {

    private int size;// ��ǰ����
    private static int INIT_CAPACITY = 16;// Ĭ������
    private Entity[] container;// ʵ�ʴ洢���ݵ��������
    private static float LOAD_FACTOR = 0.75f;// ֵԽ�󣬴�����maxԽ�󣬴���Ԫ��Խ�࣬Խӵ��
    private int max;// �ܴ��������=capacity*factor
    public  B(){


        max=(int)(INIT_CAPACITY*LOAD_FACTOR);

        container=new Entity[INIT_CAPACITY];//���������ռ�
    }

    @Test
    public void test(){
        long start=System.currentTimeMillis();

        for(int i=0;i<13;i++){
            this.put(""+i,""+i*10);
        }
        long end=System.currentTimeMillis();
        System.out.println("����Ԫ��ʱ���ǣ�"+(end-start));
        System.out.println( this.get("1"));
    }
    //���ò������˵�ͷ��д�˺ó�ʱ�䣬���ܱ�֤hash���ظ�����jdkMapԴ���Դ��İ�
    public int hash(Object k) {//��ֹ�����Ĳ������ظ�
        int h = 0;
        h ^= k.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public String get(String key){

        Entity e=null;
        //���ò������˵�ͷ��д�˺ó�ʱ�䣬���ܱ�֤hash���ظ�����jdkMapԴ���Դ��İ�
        int hash = (key == null) ? 0 : hash(key);

        int index=this.indexFor(hash,this.container.length);

        e=this.container[index];
        if(e==null){
            return null;
        }
        while(e!=null){
            if((key.equals(e.key))){
                return e.value;
            }

            e=e.next;
        }

        return null;
    }



    /**
     *
     * @param k:��Ҫ�洢�ļ�
     * @param v:��Ҫ�洢��ֵ
     * @return
     */
    public boolean put(String k, String v) {

        int hash = (k == null) ? 0 : hash(k);
        Entity e=new Entity(k,v,hash);

        if(this.findEntity(e,container)){
            size++;
            return true;
        }

        return false;
    }

    /**
     *
     * @param hashcode key��hash��
     * @param containerLength �������ĳ���
     * @return:�����洢�������е��Ǹ������� ���ܱ�֤Ψһ��
     */
    public int indexFor(int hashcode, int containerLength) {

        return hashcode & (containerLength-1);


    }

    /**
     *
     * @param e �¶���
     * @param container������
     * @return����¶���������������ڣ�����Ϊtrue�����򷵻�Ϊfalse
     */
    private boolean findEntity(Entity e, Entity[] container) {
        int index=this.indexFor(e.hash,container.length);//������������±�
        Entity temp=container[index];
        if(temp!=null){//����������µ�Ԫ���Ѿ����ڣ����ں�����ֻ�ܲ��õ����������ʽ����Ԫ�طŵ�����������
            while(temp!=null){
                if((e.key.equals(temp.key))&&(e.hash==temp.hash)&&(e.value.equals(temp.value))){//�жϸ���Ԫ��e�Ƿ��������Ԫ����ȣ������ȫ��ȣ���ô���������
                    return false;
                }else{//�������

                   if(temp.next==null){
                       break;
                   }

                }

                temp=temp.next;

            }
            //������Ԫ�ص���β
            this.addEntry2Last(e,temp);//��ÿ��Ԫ�ص����������һ�����ظ�ֵ���ӵ�����������
            return true;
        }
        //���򣬼�����Ԫ�ص�����
         setFirstEntry(e,index,container);


        return true;
    }

    /**
     *
     * @param e:��Ԫ��
     * @param index:��Ԫ�ص�������
     * @param table :�µ�����
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
     * @param entry:��Ҫ�������Ԫ��
     * @param last:ѭ����ĩβ����Ԫ��
     */
    private void addEntry2Last(Entity entry, Entity last) {
        if(size>max){//����
            reSize(this.container.length*4);

        }
        last.next=entry;



    }


    /**
     *
     * @param newSize :����������Ĵ�С������
     */
    private void reSize(int newSize) {

        this.max=(int)(newSize*this.LOAD_FACTOR);//�γ��µ�maxֵ
        Entity [] newContainer=new Entity[newSize];//������

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
        Entity next;//���ù�������Ҳ����˵ ͬһ��hash���еĲ�ͬ��Ԫ��,next�洢�����¸�Ԫ�صĵ�ַ
        String key;//1 10
        String value;
        int hash;
        Entity(String key ,String value,int hash){
            this.key=key;
            this.value=value;
            this.hash=hash;
        }
    }
}
