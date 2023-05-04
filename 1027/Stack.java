/**
 * @Author Lick
 * @date Created in 2022-10-27 11:36
 */
public class Stack {
        char []s ;
        int top;
        public Stack(){
            s = new char[100];
            top = 0;
        }
        public Stack(int maxcount) throws Exception{
            if(maxcount<1 || maxcount > 1000000)
                throw new Exception("内存超出范围");
            s= new char[maxcount];
            top = 0;
        }
        //进栈
        public boolean Push(char c){
            if(isFull())
                return false;
            s[top] = c;
            top++;
            return true;
        }
        //出栈
        public  char Pop() throws Exception{
            if(isEmpty())
                throw new Exception("栈为空");
            top--;
            return s[top];
        }
        //栈空
        public boolean isEmpty(){
            return top == 0 ;
        }
        //栈满
        public boolean isFull(){
            return top == s.length;
        }
    }


