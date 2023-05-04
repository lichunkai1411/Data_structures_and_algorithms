package StringSort;

/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-23
 * Time：10:27
 */
public class StringSort {
    public static void BubbleSort(String[] data, int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            for (int j = start; j <= end - i - 1; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    String temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void SelectSort(String[] data, int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    public static void QuickSort(String[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        String pivot = data[(start + end) / 2];
        while (left <= right) {
            while (data[left].compareTo(pivot) < 0) {
                left++;
            }
            while (data[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                String temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        }
        QuickSort(data, start, right);
        QuickSort(data, left, end);
    }
}
