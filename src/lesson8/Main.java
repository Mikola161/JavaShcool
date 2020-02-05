package lesson8;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.iterate( new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, x -> new BigInteger[] {x[1], x[1].add(x[0])})
                .limit(95)
                .forEach(x -> System.out.println(x[1]));

    }
}
