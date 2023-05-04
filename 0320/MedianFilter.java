/**
 * Created by IntelliJ IDEA.
 * Author：Lick
 * Date Created in 2023-03-20
 * Time：10:30
 */

import java.util.Arrays;

public class MedianFilter {
    private int windowSize;  // 滑动窗口大小
    private int[] buffer;    // 数据缓存
    private int bufferIndex; // 缓存索引

    // 构造方法，输入采样周期（us为单位）
    public MedianFilter(double samplingPeriod) {
        if (samplingPeriod <= 1000000.0) {
            windowSize = 8;
        } else if (samplingPeriod <= 100000.0) {
            windowSize = 16;
        } else if (samplingPeriod <= 10000.0) {
            windowSize = 32;
        } else {
            windowSize = 64;
        }

        buffer = new int[windowSize];
        bufferIndex = 0;
    }

    // 存入采样数据，返回经处理后的采样数据
    public int put(int sample) {
        buffer[bufferIndex] = sample;
        bufferIndex = (bufferIndex + 1) % windowSize;

        int[] sortedBuffer = Arrays.copyOf(buffer, windowSize);
        Arrays.sort(sortedBuffer);

        int medianIndex = (windowSize - 1) / 2;
        int median = (sortedBuffer[medianIndex] + sortedBuffer[medianIndex + 1]) / 2;

        return median;
    }

    public static void main(String[] args) {
        MedianFilter filter = new MedianFilter(5000.0); // 采样周期为5ms
        int[] sample = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000 };
        for (int i = 0; i < sample.length; i++) {
            int filteredValue = filter.put(sample[i]);
            System.out.println("Sample " + (i + 1) + ": " + sample[i] + " Filtered Value: " + filteredValue);
        }
    }
}
