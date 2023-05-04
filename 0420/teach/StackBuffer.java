package teach;

/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-04-20
 * Time：10:44
 */
public class StackBuffer {
    public static final int DEFAULT_STACK_SIZE = 10;
    private Object[] stack; //栈数组
    private int top; //栈顶
    private int bottom; //栈底

    public StackBuffer() {
        stack = new Object[DEFAULT_STACK_SIZE];
        top = 0;
        bottom = 0;
    }

    public StackBuffer(int size) {
        stack = new Object[size];
        top = 0;
        bottom = 0;
    }

    public boolean isOK() {
        return (top - bottom) == stack.length;
    }

    public int size() {
        return stack.length;
    }

    public Object add(Object obj) {


        if (top < stack.length)
        {
            stack[top % stack.length] = obj;
            top++;
            return null;
        }
        Object t = stack[bottom % stack.length];
        bottom++;
        stack[top% stack.length]=obj;
        top++;

        return t;
    }


    public Object get() {
        int t_top, t_bottom;
        Object[] a = new Object[stack.length];
        int i = 0;
        t_top = top - 1;
        t_bottom = bottom;

        while (t_top >= bottom) {
            a[i] = stack[t_top % stack.length];
            t_top--;
            i++;
        }
        return a;
    }
    public static void main(String[] args) {
        StackBuffer s=new StackBuffer(10);
        Object []result;
        for(int i=0;i<100;i++) {
            s.add(new Integer(i));
        }
        result = (Object[]) s.get();
        for(int i=0;i<result.length;i++){
            System.out.println((Integer)result[i]);
        }
    }

}
