package akka.first.app.mapreduce;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:04
 */
public final class MapData {
    private final List<WordCount> dataList;

    public List<WordCount> getDataList() {
        return dataList;
    }

    public MapData(List<WordCount> dataList) {
        this.dataList = dataList;
    }
}
