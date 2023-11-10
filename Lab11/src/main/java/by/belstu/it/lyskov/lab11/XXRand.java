package by.belstu.it.lyskov.lab11;

import java.util.Random;

public class XXRand {
    private int maxValue = Integer.MAX_VALUE;
    private final Random random = new Random();

    public XXRand(Integer maxValue) {
        if (maxValue > 0)
            this.maxValue = maxValue;
    }

    public Integer getNumber() {
        return random.nextInt() % maxValue;
    }
}

