package com.ahzam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGenerator implements INumberGenerator {

    // fields
    private final Random random = new Random();
    private final int maxNum;
    private final int minNum;

    @Autowired
    public NumberGenerator(@MaxNum int maxNumber, @MinNum int minNumber) {
        this.maxNum = maxNumber;
        this.minNum = minNumber;
    }

    // public methods
    @Override
    public int next() {
        return random.nextInt(maxNum);
    }

    @Override
    public int getMaxNumber() {
        return maxNum;
    }

    @Override
    public int getMinNumber() {
        return 0;
    }
}
