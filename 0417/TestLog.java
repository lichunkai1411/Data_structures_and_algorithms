import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestLog {

    public static final int MAX_RECORDS = 20;

    private List<TestNode> nodeList;

    public TestLog() {
        nodeList = new ArrayList<TestNode>();
    }

    public void readLog(String logFilePath) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(logFilePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    String id = fields[0].trim();
                    String stationId = fields[1].trim();
                    String rfid = fields[2].trim();
                    double rh = Double.parseDouble(fields[3].trim());
                    double temp = Double.parseDouble(fields[4].trim());
                    Date createTime = parseDate(fields[5].trim());

                    TestNode node = getNodeById(id);
                    if (node == null) {
                        node = new TestNode(id, stationId, rfid);
                        nodeList.add(node);
                    }
                    node.addRecord(new TestRecord(rh, temp, createTime));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public TestNode getNodeById(String id) {
        for (TestNode node : nodeList) {
            if (node.getId().equals(id)) {
                return node;
            }
        }
        return null;
    }

    public static Date parseDate(String dateString) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void printStatistics(String nodeId, Date endTime) {
        TestNode node = getNodeById(nodeId);
        if (node != null) {
            List<TestRecord> records = node.getRecordsBefore(endTime);
            if (records.size() > 0) {
                double sumRH = 0;
                double sumTemp = 0;
                double maxRH = Double.MIN_VALUE;
                double maxTemp = Double.MIN_VALUE;
                double minRH = Double.MAX_VALUE;
                double minTemp = Double.MAX_VALUE;

                System.out.println("--------------------------------------------------");
                System.out.println("节点 ID：" + nodeId);

                for (TestRecord record : records) {
                    sumRH += record.getRh();
                    sumTemp += record.getTemp();

                    if (record.getRh() > maxRH) {
                        maxRH = record.getRh();
                    }
                    if (record.getTemp() > maxTemp) {
                        maxTemp = record.getTemp();
                    }
                    if (record.getRh() < minRH) {
                        minRH = record.getRh();
                    }
                    if (record.getTemp() < minTemp) {
                        minTemp = record.getTemp();
                    }

                    System.out.println(formatDate(record.getCreateTime()) + " " + record.getTemp() + " 摄氏度 " + record.getRh() + "%");
                }

                int count = records.size();
                if (count > MAX_RECORDS) {
                    count = MAX_RECORDS;
                }
                System.out.println("总共显示 " + count + " 条");

                double avgRH = sumRH / records.size();
                double avgTemp = sumTemp / records.size();
                System.out.println("平均温度：" + avgTemp + " 摄氏度");
                System.out.println("平均湿度：" + avgRH + "%");
                System.out.println("最高温度：" + maxTemp + " 摄氏度");
                System.out.println("最高湿度：" + maxRH + "%");
                System.out.println("最低温度：" + minTemp + " 摄氏度");
                System.out.println("最低湿度：" + minRH + "%");
            } else {
                System.out.println("该节点在查询时间之前没有任何记录");
            }
        } else {
            System.out.println("找不到节点：" + nodeId);
        }
    }

    public static String formatDate(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static void main(String[] args) {
        TestLog log = new TestLog();
        log.readLog("file/gi_log.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("请输入监测节点 ID：");
            String nodeId = reader.readLine().trim();
            System.out.print("请输入监测截止时间（格式：yyyyMMddHHmmss）：");
            String endTimeString = reader.readLine().trim();

            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            Date endTime = format.parse(endTimeString);

            log.printStatistics(nodeId, endTime);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class TestNode {
    private String id;
    private String stationId;
    private String rfid;
    private List<TestRecord> recordList;

    public TestNode(String id, String stationId, String rfid) {
        this.id = id;
        this.stationId = stationId;
        this.rfid = rfid;
        recordList = new ArrayList<TestRecord>();
    }

    public String getId() {
        return id;
    }

    public String getStationId() {
        return stationId;
    }

    public String getRfid() {
        return rfid;
    }

    public void addRecord(TestRecord record) {
        recordList.add(record);
        if (recordList.size() > TestLog.MAX_RECORDS) {
            recordList.remove(0);
        }
    }

    public List<TestRecord> getRecordsBefore(Date endTime) {
        List<TestRecord> result = new ArrayList<TestRecord>();
        for (TestRecord record : recordList) {
            if (record.getCreateTime().before(endTime)) {
                result.add(record);
            }
        }
        return result;
    }
}

class TestRecord {
    private double rh;
    private double temp;
    private Date createTime;

    public TestRecord(double rh, double temp, Date createTime) {
        this.rh = rh;
        this.temp = temp;
        this.createTime = createTime;
    }

    public double getRh() {
        return rh;
    }

    public double getTemp() {
        return temp;
    }

    public Date getCreateTime() {
        return createTime;
    }
}