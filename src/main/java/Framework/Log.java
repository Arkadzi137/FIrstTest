package Framework;


import org.apache.log4j.Logger;

public class Log {
    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger("logger");

    public static void startTestCase(String sTestCaseName){LOGGER.info("Start "+sTestCaseName+ "");}

    public static void endTestCase(String sTestCaseName){
        LOGGER.info("-E---N---D-");
    }

    public static void info(String message) {LOGGER.info(message);}

    public static void warn(String message) {LOGGER.warn(message);}

    public static void error(String message) {LOGGER.error(message);}

    public static void fatal(String message) {LOGGER.fatal(message);}

    public static void debug(String message) {LOGGER.debug(message);}
}
