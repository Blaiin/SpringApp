package its.nds.utils;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;

public class LogUtils implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(LogUtils.class);
    public static Logger getLogger() {
        String className = new Throwable().getStackTrace()[1].getClassName();
        return LogManager.getLogger(className);
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String logFilePath = sce.getServletContext().getRealPath(File.separator)
                        + File.separator + "logs" + File.separator + "logs.txt";
        System.out.println(logFilePath);
        Configurator.initialize(null, "log4j2.xml");
        logger.info("Log4j initialized. Log file path: " + logFilePath);
    }
}
