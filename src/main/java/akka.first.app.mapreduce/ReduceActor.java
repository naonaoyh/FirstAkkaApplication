package akka.first.app.mapreduce;

import akka.actor.UntypedActor;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:37
 */
public class ReduceActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof MapData) {
            MapData mapData = (MapData) message;
            // reduce the incoming data and forword the result to Master actor
            getSender().tell(reduce(mapData.getDataList()));
        } else
            unhandled(message);
    }

    private ReduceData reduce(List<WordCount> dataList) {
        HashMap<String, Integer> reducedMap = new HashMap<String, Integer>();
        for (WordCount wordCount : dataList) {
            if (reducedMap.containsKey(wordCount.getWord())) {
                Integer value = (Integer)
                        reducedMap.get(wordCount.getWord());
                value++;
                reducedMap.put(wordCount.getWord(), value);
            } else {
                reducedMap.put(wordCount.getWord(),
                        Integer.valueOf(1));
            }
        }
        return new ReduceData(reducedMap);
    }
}

