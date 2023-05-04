import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-10-20 10:42
 */
public class Demo1020 {
    /**
     * 去除字符串两边的空白
     * String trim()
     * @author Administrator
     *
     */
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            //去除字符串两边的空白，中间的不管
            String tr = str.trim();
            char strs [] = tr.toCharArray();
            for (int i = 0; i < strs.length; i++) {

            }
            System.out.println(tr);
        }
    }



