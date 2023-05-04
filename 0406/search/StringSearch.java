package search;


public class StringSearch {

    public static boolean search(String key, String[] data, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (data[i].equals(key)) {
                return true;
            }
        }
        return false;
    }


    public static boolean binarySearch(String key, String[] data, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cmp = key.compareTo(data[mid]);
            if (cmp < 0) {
                end = mid - 1;
            } else if (cmp > 0) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
