import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-10-13 11:31
 */
public class Demo1013 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一段字符串：");
        String str = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <str.length() ; i++) {
            int old_length = str.length();
            char c = str.charAt(0);
            String new_str = str.replaceAll(c + "", "");
            int new_length = new_str.length();
            count = old_length - new_length;
            str=new_str;
            System.out.println("字符"+c+"出现了"+count+"次");
        }
    }
}
