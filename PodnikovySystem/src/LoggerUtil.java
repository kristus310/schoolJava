import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("CompanySystemLogger");

    static {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
    }

    public static void log(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.severe(message);
    }
}

