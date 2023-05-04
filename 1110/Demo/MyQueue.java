package Demo;

/**
 * @Author Lick
 * @date Created in 2022-11-10 10:43
 */
public class MyQueue {
    private int front;
    private int rear;
    private int count;
    private int[] Q;

    public MyQueue(int size) {
        front = 0;
        rear = 0;
        count = 0;
        Q = new int[size];
    }

    public boolean isFull() {
        return count == Q.length;
//        return  (rear - front) == Q.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean qin(int v) {
        if (isFull())
            return false;
        Q[rear++ % Q.length] = v;
        rear++;
        count++;
        return true;
    }

    public int qout() throws Exception {
        int v;
        if (isEmpty())
            throw new Exception("队列为空");
        v = Q[front % Q.length];
        front++;
        count--;
        return v;
    }
}
