package com.ahzam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Game implements IGame {

    // fields
    private static final Logger log = LoggerFactory.getLogger(Game.class);

    private final NumberGenerator numGen;
    private final int totalGuesses;

    private int num;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNum = true;

    // 2 ways to have DI
//    // constructor DI

    @Autowired
    public Game(NumberGenerator numberGenerator, @GuessNum int guessCount) {
        this.numGen = numberGenerator;
        this.totalGuesses = guessCount;
    }
    // setter DI
//    public void setNumGen(NumberGenerator numGen) {
//        this.numGen = numGen;
//    }

    // init methods = methods running right on bean creation
    @PostConstruct
    @Override
    public void reset() {
        smallest = 0;
        guess = 0;
        remainingGuesses = totalGuesses;
        largest = numGen.getMaxNumber();
        num = numGen.next();
        log.debug("Number is {}", num);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("In game pre destory");
    }

    // public methods
    @Override
    public int getNumber() {
        return num;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return largest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return totalGuesses;
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNum) {
            if(guess > num) {
                largest = guess -1;
            }

            if(guess < num) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNum;
    }

    @Override
    public boolean isGameWon() {
        return guess == num;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNum = (guess >= smallest) && (guess <= largest);
    }
}
