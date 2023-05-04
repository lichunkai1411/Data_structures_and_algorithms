/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-16
 * Time：11:55
 */
import java.io.*;
import java.util.*;

public class BucketSort {
    public static void main(String[] args) throws Exception {
        // 读取文件中的手机号
        BufferedReader br = new BufferedReader(new FileReader("03162/phoneNum.txt"));
        String line;
        ArrayList<String> phoneNums = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            phoneNums.add(line);
        }
        br.close();

        // 设置桶的数量和每个桶的容量
        int bucketNum = 100; // 使用100个桶
        int capacity = (int) Math.ceil(phoneNums.size() / (double) bucketNum); // 向上取整计算每个桶的容量

        // 建立桶
        ArrayList<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<String>());
        }

        // 往桶里装手机号
        for (String phoneNum : phoneNums) {
            int index = Integer.parseInt(phoneNum.substring(0, 2));
            buckets.get(index).add(phoneNum);
        }

        // 对每个桶内的手机号进行排序
        for (ArrayList<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 将排序后的手机号写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("sortedPhoneNum.txt"));
        for (ArrayList<String> bucket : buckets) {
            for (String phoneNum : bucket) {
                bw.write(phoneNum);
                bw.newLine();
            }
        }
        bw.close();
    }
}
