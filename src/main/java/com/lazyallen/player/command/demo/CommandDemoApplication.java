package com.lazyallen.player.command.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class CommandDemoApplication implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandDemoApplication.class);

    private static final String SERVER_PORT = "server.port";

    @Autowired
    Environment env;


    public static void main(String[] args) {
        SpringApplication.run(CommandDemoApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("COMMAND ARGS:args:{}",args);
        logger.info("COMMAND ARGS:SourceArgs:{}",args.getSourceArgs());
        logger.info("COMMAND ARGS:OptionNames:{}",args.getOptionNames());
        logger.info("COMMAND ARGS:NonOptionArgs:{}",args.getNonOptionArgs());
        logger.info("COMMAND ARGS:OptionValues for server.port :{}",args.getOptionValues(SERVER_PORT));
        logger.info("---------------------------------------");
        logger.info("SYSTEM PROPERTIES: server.port:{}",System.getProperty(SERVER_PORT));
        logger.info("---------------------------------------");
        logger.info("SPRING ENV:server.port:{}",env.getProperty(SERVER_PORT));
    }
}
