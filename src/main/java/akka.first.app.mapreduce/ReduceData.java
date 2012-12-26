package akka.first.app.mapreduce;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:14
 */
public final class ReduceData {
    private final HashMap<String, Integer> reduceDataList;

    public HashMap<String, Integer> getReduceDataList() {
        return reduceDataList;
    }

    public ReduceData(HashMap<String, Integer> reduceDataList) {
        this.reduceDataList = reduceDataList;
    }
}
