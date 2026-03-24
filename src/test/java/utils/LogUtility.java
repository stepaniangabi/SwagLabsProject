package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtility {
    //gaseste in fisierul log4j2.xml si sa incarce tot ce am scris in el
    public static Logger logger = LogManager.getLogger();

    //log care sa anunte inceputul testului
    public static void startTest(String testName){
        logger.info("***** Execution started: "+testName+" *****");
    }

    //log care sa logheze info
    public static void infoLog(String message){
        logger.info(message);
    }

    //log care sa logheze error
    public static void errorLog(String message){
        logger.error(message);
    }

    //log care sa anunte sfarsitul testului
    public static void finishTest(String testName){
        logger.info("***** Execution finished: "+testName+" *****");
    }
}
