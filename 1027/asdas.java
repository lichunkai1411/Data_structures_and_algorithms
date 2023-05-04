import java.util.Scanner;

/**
 * @Author Lick
 * @date Created in 2022-12-03 10:33
 */
public class asdas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] num = new double[5];
        for (int x = 0; x < num.length; x++) {
            num[x]=input.nextDouble();
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length-1 ; j++) {
                double temp = 0;
                if(num[j] > num[j+1]) {
                    temp = num[j];
                    num[j] = num[j+1];
                    num[j+1]= temp;
                }
            }
        }
        System.out.println(num[0]);
    }
}
