package com.weikun.F;

import org.junit.Test;

/**
 * Created by Administrator on 2016/12/20.
 * 堆排序
 */
public class B {
    private int [] data={9,79,46,30,58,49};
    public static void main(String[] args) {

    }
    @Test
    public  void heapSort() {

        System.out.println("开始排序");
        int arrayLength = data.length;
        //循环建堆，构建完全二叉树
		/*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49
		 */
        //针对完全二叉树，大顶堆，最顶端的值(0号索引)肯定是在没交换之前的最大的值，
        //对其在数组里面进行排序交换，大的排在数组后面，虽然最大的在最上面，但是其他的数据并没有排好，因此，需要不停更换顶点，重新建堆，需要循环


        for(int i=0;i<arrayLength-1;i++){

            builMaxdHeap(arrayLength-1-i);


            swap( 0 , arrayLength - 1 - i);
        }


        for( int i:data){
            System.out.println(i);

        }
    }
    //构建大顶堆
    public void builMaxdHeap(int lastIndex){
        //(lastIndex-1)/2 找到lastIndex的父节点的索引号
        for(int i=(lastIndex-1)/2 ; i>=0;i-- ){//
            int k=i;
            //判断当前for循环指定的节点的子节点
            while(k*2+1<=lastIndex){

                //算出左子结点索引

                int bigIndex=k*2+1;//
                //判断是否有右子节点，也就是看他有右子节点的索引是否存在
                if(bigIndex<lastIndex){
                    if(data[bigIndex]-data[bigIndex+1]<0){
                        bigIndex++;
                    }

                }
                //以下leftIndex就是那个大值所代表的索引号，再和父亲比
                if(data[k]-data[bigIndex]<0){//儿子比父亲大,要交换
                    swap(k,bigIndex);
                }else{

                    break;
                }


            }


        }
    }
        //交换索引所代表的数
    private void swap(int k, int bigIndex) {

        int tmp=0;
        tmp=data[k];
        data[k]=data[bigIndex];
        data[bigIndex]=tmp;


    }
}
