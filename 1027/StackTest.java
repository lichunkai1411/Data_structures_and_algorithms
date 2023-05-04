import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-10-27 11:00
 */
public class StackTest {
    public static char[] getLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line.toCharArray();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        char[] c = getLine();
        long start, end;
        start = System.currentTimeMillis();
        for (int k = 0; k < 1000000; k++) {


            for (int i = 0; i < c.length; i++)
                s.Push(c[i]);

            // 方法一用异常退出循环
//        while (true) {
//            try {
//                System.out.print(s.Pop());
//            } catch (Exception e) {
//                break;
//            }
//        }


            // 方法二用isEmpty()判断栈是否为空
            while (!s.isEmpty()) {
                try {
//                System.out.print(s.Pop());
                    s.Pop();
                } catch (Exception e) {
                }
            }
        }
            end = System.currentTimeMillis();
            System.out.println("用时" + (end - start) + "毫秒");


//        s.Push('A');
//        s.Push('B');
//        s.Push('C');
//        try {
//            System.out.println(s.Pop());
//            System.out.println(s.Pop());
//            System.out.println(s.Pop());
//            System.out.println(s.Pop());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}