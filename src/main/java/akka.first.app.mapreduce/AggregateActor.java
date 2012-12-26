package akka.first.app.mapreduce;

import akka.actor.UntypedActor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:49
 */
public class AggregateActor extends UntypedActor {
    private Map<String, Integer> finalReducedMap =
            new HashMap<String, Integer>();
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof ReduceData) {
            ReduceData reduceData = (ReduceData) message;
            aggregateInMemoryReduce(reduceData.getReduceDataList());
        } else if (message instanceof Result) {
            getSender().tell(finalReducedMap.toString());
        } else
            unhandled(message);
    }

    private void aggregateInMemoryReduce(HashMap<String, Integer> reducedList) {
        Integer count = null;
        for (String key : reducedList.keySet()) {
            if (finalReducedMap.containsKey(key)) {
                count = reducedList.get(key) + finalReducedMap.get(key);
                finalReducedMap.put(key, count);
            } else {
                finalReducedMap.put(key, reducedList.get(key));
            }
        }
    }
}
