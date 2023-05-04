import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-13
 * Time：11:02
 */
public class StringSort {
    public static void main(String[] args) {
        String[] data = {"hello", "world", "java", "algorithm", "sorting"};

        // 冒泡排序
        StringSort.BubbleSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data)); // [algorithm, hello, java, sorting, world]

        // 选择排序
        StringSort.SelectSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data)); // [algorithm, hello, java, sorting, world]

        // 快速排序
        StringSort.QuickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data)); // [algorithm, hello, java, sorting, world]
    }

    /**
     * 冒泡排序
     */
    public static void BubbleSort(String[] date, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end - i + start - 1; j++) {
                if (date[j].compareTo(date[j + 1]) > 0) {
                    String temp = date[j];
                    date[j] = date[j + 1];
                    date[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void SelectSort(String[] date, int start, int end) {
        for (int i = start; i <= end; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (date[j].compareTo(date[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                String temp = date[i];
                date[i] = date[minIndex];
                date[minIndex] = temp;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void QuickSort(String[] date, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start, j = end;
        String pivot = date[start + (end - start) / 2];

        while (i <= j) {
            while (date[i].compareTo(pivot) < 0) {
                i++;
            }
            while (date[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                String temp = date[i];
                date[i] = date[j];
                date[j] = temp;
                i++;
                j--;
            }
        }

        QuickSort(date, start, j);
        QuickSort(date, i, end);
    }
}
