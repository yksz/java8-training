package ch02.ex10;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Average {

    static double average(Stream<Double> stream) {
        double[] result = stream
                .map(n -> new double[]{ n, 0.0 })
                .reduce(new double[2], (acc, val) -> {
                    acc[0] += val[0];
                    acc[1] += 1.0;
                    return acc;
                });
        double sum = result[0];
        double count = result[1];
        return sum / count;
    }

    public static void main(String[] args) {
        double[] values = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        assert average(DoubleStream.of(values).boxed()) == 3.0;
    }

}
