/**
 * @Author Lick
 * @date Created in 2022-11-10 10:33
 */

public class Queue {
    //队列的最大长度
    private int maxsize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //队列
    private int[] arr;

    public Queue(int size) {
        maxsize = size;
        arr = new int[maxsize];
        //指向第一个元素前一个位置
        front = -1;
        //指向最后一个元素
        rear = -1;

    }

    //判断是否为满
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    //判断是否为空
    public boolean isempty() {
        return rear == front;

    }

    //添加数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已经满了，无法添加了");
            return;
        }
        arr[++rear] = n;
    }

    //获取数据
    public int getQueue() {
        if (isempty()) {
            //因为有返回值抛出异常,输出异常后就不用再return了
            throw new RuntimeException("队列空，不能获取");

        }
        return arr[++front];
    }

    //遍历
    public void showQueue() {
        if (isempty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("第" + i + 1 + "位:" + arr[i]);
        }

    }
    public int headData() {
        if (isempty()) {
            throw new RuntimeException("队列为空---没有数据");

        }
        return arr[front + 1];
    }

}


