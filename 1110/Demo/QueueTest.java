package Demo;

import javax.swing.*;
import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-11-10 10:42
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
        MyQueue q = new MyQueue(3);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (true) {
            if (q.qin(num))
                System.out.println("进入队列成功！");
            if (q.qin(num))
                System.out.println("进入队列成功！");
            if (q.qin(num))
                System.out.println("进入队列成功！");
            if (q.qin(num))
                System.out.println("进入队列成功！");
            else
                System.out.println("队列已满！");

            Integer v;
            v = q.qout();
            if (v != null)
                System.out.println("出队列：" + v);
            else
                System.out.println("队列为空！");
            v = q.qout();
            if (v != null)
                System.out.println("出队列：" + v);
            else
                System.out.println("队列为空！");
            v = q.qout();
            if (v != null)
                System.out.println("出队列：" + v);
            else
                System.out.println("队列为空！");
            v = q.qout();
            if (v != null)
                System.out.println("出队列：" + v);
            else
                System.out.println("队列为空！");
        }
    }
}


