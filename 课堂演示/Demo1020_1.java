import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-10-20 18:23
 */
public class Demo1020_1 {
    public static boolean isNumAlpha(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    public static boolean isSpace(char c) {
        return (c ==' ' || c == '\t' || c == '\r' || c == '\n');
    }
    public static void main(String[] args) {
        int begin = 0,end =0;
        int i;
        char c;
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        for ( i = 0; i <s.length() ; i++) {
            c = s.charAt(i);
            if (isNumAlpha(c)) {
                begin = i;
                break;
            }
        }
        for (; i <s.length() ; i++) {
            c = s.charAt(i);
            if (isSpace(c)){
                end = i;
                break;
            }
        }
        String info = s.substring(begin,end);
        System.out.println(info);
    }
}
