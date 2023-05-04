/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-16
 * Time：11:46
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortPhoneNum {

    public static void main(String[] args) {
        String inputFile = "0316/phoneNum.txt";
        String outputFile = "sortedPhoneNum.txt";
        int bucketSize = 1000; // 桶的大小
        List<String> phoneNumList = new ArrayList<>();

        // 读取手机号码到列表中
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                phoneNumList.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 桶排序
        List<List<String>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (String phoneNum : phoneNumList) {
            int digit = Integer.parseInt(phoneNum.substring(0, 1));
            buckets.get(digit).add(phoneNum);
        }
        for (List<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 把排序后的手机号写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (List<String> bucket : buckets) {
                for (String phoneNum : bucket) {
                    writer.write(phoneNum + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
