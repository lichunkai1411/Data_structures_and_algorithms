/**
 * @Author Lick
 * @date Created in 2022-10-13 18:54
 */
public class Demo1013_1 {
    public static void main(String[] args) {

    }

    public static int search(char c, char[] letter) {
        int i;
        for (i = 0; i < letter.length && letter[i] > 0; i++) {
            if (letter[i] == c)
                break;
        }
        return i;
    }

    public static void method_1(String s) {
        char[] letter = new char[s.length()];
        int[] count = new int[s.length()];
    }
}
