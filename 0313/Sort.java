import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-13
 * Time：10:23
 */
public class Sort {
    public static void main(String[] args) {
        String[] arr1 = {"apple", "banana", "cherry", "date", "elderberry"};
        sort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

        String[] arr2 = {"cuijianing", "jiangjialiang", "songzichun", "liuwenzuo", "lichunkai"};
        sort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

        String[] arr3 = {"刘文卓", "李春凯", "姜佳良", "崔家宁", "宋子淳"};
        sort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));

        String[] arr4 = {"语文", "数学", "英语", "物理", "化学", "地理", "历史", "生物"};
        sort(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(arr4));

    }

    public static void sort(String[] arrays, int left, int right) {
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        String pivot = arrays[left];
        String temp;
        while (l < r) {
            while (pivot.compareTo(arrays[r]) <= 0 && l < r) {
                r--;
            }
            while (pivot.compareTo(arrays[l]) >= 0 && l < r) {
                l++;
            }
            if (l <= r) {
                temp = arrays[r];
                arrays[r] = arrays[l];
                arrays[l] = temp;
            }
        }
        arrays[left] = arrays[l];
        arrays[l] = pivot;
        sort(arrays, left, l - 1);
        sort(arrays, l + 1, right);
    }
}
