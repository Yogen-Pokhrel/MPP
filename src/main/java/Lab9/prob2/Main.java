package Lab9.prob2;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream myIntStream = IntStream.of(10, 20, 5,8,100, 120, 111);
        IntSummaryStatistics statistic = myIntStream.summaryStatistics();
        System.out.println("Max Value: " + statistic.getMax());
        System.out.println("Min Value: " + statistic.getMin());
    }
}
