/**
 * @Author Lick
 * @date Created in 2022-10-27 10:29
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        stackArray[++top] = c;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];

    }

    public boolean isEmpty() {
        return (top == -1);
    }

}

class Reverse {
    private String input;
    private String output;

    public Reverse(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);
        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            theStack.push(ch);
        }
        output = "";
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output = output + ch;
        }
        return output;
    }
}

public class ReversApp {
    public static void main(String[] args) throws IOException {
        String input, output;

        long start,end;
        while (true) {
            System.out.println("请输入一行文本:");
            //Scanner in = new Scanner(System.in);
            input = getString();

            start = System.currentTimeMillis();
            if (input.equals("")) {
                break;
            }
            Reverse r = new Reverse(input);
            output = r.doRev();
            System.out.println(output);

            end = System.currentTimeMillis();
            System.out.println("开始时间：" + start);
            System.out.println("结束时间：" + end);
            System.out.println("运行时间：" + (end - start) + "(ms)");
        }
    }

    private static String getString() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        return s;
    }
}


