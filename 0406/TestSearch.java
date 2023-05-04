import search.StringSearch;


public class TestSearch {
    public static void main(String[] args) {
        String data[] = {"A", "OK", "XXX", "ZZZ"};
        boolean ret;
        System.out.println("顺序查找");
        ret = StringSearch.search("XXX", data, 1, 3);
        System.out.println(ret);
        System.out.println("折半查找");
        ret = StringSearch.binarySearch("XXX", data, 0, data.length - 1);
        System.out.println(ret);
    }
}