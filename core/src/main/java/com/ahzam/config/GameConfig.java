package com.ahzam.config;

import com.ahzam.GuessNum;
import com.ahzam.MaxNum;
import com.ahzam.MinNum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ahzam")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    // == fields ==
    @Value("${game.maxNum:20}")
    private int maxNumber;

    @Value("${game.guessNum:5}")
    private int guessCount;

    @Value("${game.minNum:5}")
    private int minNumber;


    // == bean methods ==
    @Bean
    @MaxNum
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessNum
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNum
    public int minNumber() {
        return minNumber;
    }
}
