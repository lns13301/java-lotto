package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtils {

    public static final List<Integer> generateRandomNumbers(List<Integer> allBoundOfNumbers, int needCount) {
        Collections.shuffle(allBoundOfNumbers);

        return allBoundOfNumbers.stream()
            .limit(needCount)
            .sorted()
            .collect(Collectors.toList());
    }
}
