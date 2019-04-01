/*
General configuration settings for the program
 */


package com.project.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.project.library")
@PropertySource("classpath:application.properties")
public class AppConfig {


    // set up variable to hold the properties
    // This holds the data read from the properties files
    @Autowired
    private Environment env;

    // set up a logger for diagnostics
    // TODO: add loogging methods
    private Logger logger = Logger.getLogger(getClass().getName());

}
