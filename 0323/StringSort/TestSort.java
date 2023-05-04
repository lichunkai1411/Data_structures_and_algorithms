package StringSort;

/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-23
 * Time：10:27
 */
public class TestSort {
    public static void main(String[] args) {
        String data[] = {"OK", "A", "ZZZ", "XXX"};

        System.out.println("选择排序输出。");
        StringSort.SelectSort(data, 1, 3);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

        System.out.println("快速排序输出。");
        StringSort.QuickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}

