package TestNode;

import java.util.LinkedList;

public class TestNodeDataItem {
    private String rfid;
    private double TempValue;
    private double RHValue;
    private long SampleTime;

    public TestNodeDataItem(String rfid, double tempValue, double RHValue, long sampleTime) {
        this.rfid = rfid;
        TempValue = tempValue;
        this.RHValue = RHValue;
        SampleTime = sampleTime;
    }

    public String getRfid() {
        return rfid;
    }

    public double getTempValue() {
        return TempValue;
    }

    public double getRHValue() {
        return RHValue;
    }

    public long getSampleTime() {
        return SampleTime;
    }
}

class TestNuode {
    private LinkedList<TestNodeDataItem> queue;
    private double Tmax;
    private double Tmin;
    private double Tavg;
    private double RHmax;
    private double RHmin;
    private double RHavg;

    public void TestNode() {
        queue = new LinkedList<>();
        Tmax = Double.NEGATIVE_INFINITY;
        Tmin = Double.POSITIVE_INFINITY;
        Tavg = 0;
        RHmax = Double.NEGATIVE_INFINITY;
        RHmin = Double.POSITIVE_INFINITY;
        RHavg = 0;
    }

    public void add(String s) {
        String[] fields = s.split(",");
        String rfid = fields[0];
        double tempValue = Double.parseDouble(fields[1]);
        double RHValue = Double.parseDouble(fields[2]);
        long sampleTime = Long.parseLong(fields[3]);

        TestNodeDataItem item = new TestNodeDataItem(rfid, tempValue, RHValue, sampleTime);
        queue.addLast(item);

        // 删除超时的数据
        long cutoffTime = sampleTime - 10 * 60 * 1000;
        while (!queue.isEmpty() && queue.getFirst().getSampleTime() < cutoffTime) {
            TestNodeDataItem removedItem = queue.removeFirst();
            double removedTempValue = removedItem.getTempValue();
            double removedRHValue = removedItem.getRHValue();

            // 更新统计值
            if (removedTempValue == Tmax) {
                Tmax = Double.NEGATIVE_INFINITY;
                for (TestNodeDataItem qItem : queue) {
                    Tmax = Math.max(Tmax, qItem.getTempValue());
                }
            }
            if (removedTempValue == Tmin) {
                Tmin = Double.POSITIVE_INFINITY;
                for (TestNodeDataItem qItem : queue) {
                    Tmin = Math.min(Tmin, qItem.getTempValue());
                }
            }
            if (removedRHValue == RHmax) {
                RHmax = Double.NEGATIVE_INFINITY;
                for (TestNodeDataItem qItem : queue) {
                    RHmax = Math.max(RHmax, qItem.getRHValue());
                }
            }
            if (removedRHValue == RHmin) {
                RHmin = Double.POSITIVE_INFINITY;
                for (TestNodeDataItem qItem : queue) {
                    RHmin = Math.min(RHmin, qItem.getRHValue());
                }
            }
            Tavg = (Tavg * queue.size() - removedTempValue) / (queue.size() - 1);
            RHavg = (RHavg * queue.size() - removedRHValue) / (queue.size() - 1);
        }

        // 更新统计值
        Tmax = Math.max(Tmax, tempValue);
        Tmin = Math.min(Tmin, tempValue);
        Tavg = (Tavg * queue.size() + tempValue) / (queue.size() + 1);
        RHmax = Math.max(RHmax, RHValue);
        RHmin = Math.min(RHmin, RHValue);
        RHavg = (RHavg * queue.size() + RHValue) / (queue.size() + 1);
    }

    public double getTmax() {
        return Tmax;
    }

    public double getTmin() {
        return Tmin;
    }

    public double getTavg() {
        return Tavg;
    }

    public double getRHmax() {
        return RHmax;
    }

    public double getRHmin() {
        return RHmin;
    }

    public double getRHavg() {
        return RHavg;
    }
}
