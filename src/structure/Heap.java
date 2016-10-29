package structure;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 功能描述:堆(优先队列)
 *
 * <数据结构研究系列>
 *
 * @Author ewnit
 * @Date 16/10/23.
 *
 *
 * 特性:
 * 1.完全二叉树
 *      left node = 2*i+1; right node = 2*i+2; parent node = (i-1)/2
 *      一般是通过数组来实现
 *      父节点的值大(小)于子节点的值,不要求左右节点大小有必须的排序
 *      插入:不断与父节点比较进行交换
 *      删除:只能删除根节点,把根节点移到最末子节点
 *
 * 基本操作:
 * 1.构建/调整堆
 * 2.插入
 * 3.删除
 *
 * JAVA API:
 *      PriorityQueue,不重写Comparator时默认为最小堆.每次从队列中取的元素都具有最高优先权.
 *
 * 最佳实践:
 *
 *
 *
 */
public class Heap {
    /**
     * 重复造轮子
     */
    // 将数组构建成堆,数组中的元素默认是不重复的
    public int[] buildHeap1(int[] a) {
        // 1.通过开辟一个新堆自顶向下构建堆
        int[] heap = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            heap[i] = a[i];
            //调整heap
            int parent = (i - 1) / 2;
            int prev = i;
            while (parent >= 0) {
                if (heap[parent] < heap[prev]) {
                    int temp = heap[parent];
                    heap[parent] = heap[prev];
                    heap[prev] = temp;
                }
                if (parent == 0) break;
                prev = parent;
                parent = (parent - 1) / 2;
            }
        }
        System.out.println("自顶向下构建好的堆: ");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();

        return heap;
    }

    public int[] buildHeap2(int[] a) {
        // 2.自底向上构建堆
        for (int i = a.length - 1; i >= 0; i--) {
            int parent = (i - 1) / 2;
            if (a[parent] < a[i]) {
                int temp = a[parent];
                a[parent] = a[i];
                a[i] = temp;

                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int prev = i;
                while (left < a.length || right < a.length) {
                    int next;
                    if (left >= a.length) {
                        next = right;
                    } else if (right >= a.length) {
                        next = left;
                    } else {
                        next = a[left] > a[right] ? left : right;
                    }
                    temp = a[next];
                    a[next] = a[prev];
                    a[prev] = temp;
                    prev = next;
                    left = 2 * prev + 1;
                    right = 2 * prev + 2;
                }
            }

        }

        System.out.println("自底向上构建好的堆: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        return a;
    }

    public int[] insert(int[] a, int value) {
        System.out.println(">>>>>>>>>>>>>>> 开始插入操作");
        int[] heap = buildHeap1(a);
        int[] newHeap = new int[heap.length + 1];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        newHeap[heap.length] = value;

        int prev = heap.length;
        int parent = (prev - 1) / 2;
        while (parent >= 0) {
            if (newHeap[parent] < newHeap[prev]) {
                int temp = newHeap[parent];
                newHeap[parent] = newHeap[prev];
                newHeap[prev] = temp;
            }
            if (parent == 0) break;
            prev = parent;
            parent = (prev - 1) / 2;
        }

        System.out.println("插入之后的新堆: ");
        for (int i = 0; i < newHeap.length; i++) {
            System.out.print(newHeap[i] + " ");
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>> 插入操作结束");
        return newHeap;
    }

    //只能删除根节点
    public int[] remove(int[] a) {
        System.out.println(">>>>>>>>>>>>>>> 开始删除操作");
        //交换最后一个叶子节点和根节点的位置
        int temp = a[a.length - 1];
        a[a.length - 1] = a[0];
        a[0] = temp;

        int[] newHeap = new int[a.length - 1];
        System.arraycopy(a, 0, newHeap, 0, a.length - 1);

        int prev = 0;
        int left = 2 * prev + 1;
        int right = 2 * prev + 2;
        while (left < newHeap.length || right < newHeap.length) {
            int next;
            if (left >= newHeap.length) {
                next = right;
            } else if (right >= newHeap.length) {
                next = left;
            } else {
                next = newHeap[left] > newHeap[right] ? left : right;
            }
            if (newHeap[prev] < newHeap[next]) {
                temp = newHeap[prev];
                newHeap[prev] = newHeap[next];
                newHeap[next] = temp;
                prev = next;
                left = 2 * prev + 1;
                right = 2 * prev + 2;
            } else {
                break;
            }
        }

        System.out.println("删除根节点之后的新堆: ");
        for (int i = 0; i < newHeap.length; i++) {
            System.out.print(newHeap[i] + " ");
        }
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>> 结束删除操作");
        return newHeap;
    }

    /**
     * JAVA API 分析
     */

    public void JavaApi() {
        //Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
        //默认构建的初始优先队列容量为11,默认为最小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        //构建容量为11,自定义比较器的堆,构建最大堆
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //基本操作.
        Random random = new Random();
        for(int i=0;i<10;i++){
            //继承自Collection的add方法
            priorityQueue.add(random.nextInt());
            //继承自Queue的添加方法
            priorityQueue1.offer(random.nextInt());
        }
        //获取但不删除优先级最高的数,若队列为空则为null
        priorityQueue.peek();
        //移除优先级最高的数
        priorityQueue.remove();
        //删除指定的数,若不存在返回false
        priorityQueue.remove(1);
        //获取并删除优先级最高的数
        priorityQueue.poll();
        //是否包含某个数
        priorityQueue.contains(1);
        //转换成队列
        Integer[] a=(Integer[]) priorityQueue.toArray();

        //遍历
        Iterator it=priorityQueue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }

    }

    public static void main(String[] args) {
        int[] a = {5, 3, 53, 23, 64, 29, 345, 2, 14, 22};
        Heap heap = new Heap();
        heap.buildHeap1(a);
        heap.buildHeap2(a);
        heap.insert(a, 100);
        heap.remove(a);
    }

}
