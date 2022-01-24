package com.ahzam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans xml.txt";

//    public static void main(String[] args) {
//        log.info("Guess the number game");
//
//        // create context(App Container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
//
//        // get number generator bean from context
//        INumberGenerator numGen = context.getBean("numGenerator", NumberGenerator.class);
//
//        // call next() to get random number
//        int randNum = numGen.next();
//
//        // log num
//        log.info("Number = {}", randNum);
//
//        // get game bean from context
//        // can also be context.getBean(Game.class);
//        IGame game = context.getBean("game", Game.class);
//
//        // close context to prevent memory leaks
//        context.close();
//    }
}
