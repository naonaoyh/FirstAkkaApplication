package akka.first.app.mapreduce;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:07
 */
public final class WordCount {
    private final String word;
    private final Integer count;

    public WordCount(String inWord, Integer inCount) {
        word = inWord;
        count = inCount;
    }

    public Integer getCount() {
        return count;
    }

    public String getWord() {
        return word;

    }
}
