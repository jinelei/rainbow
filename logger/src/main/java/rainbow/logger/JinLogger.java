package rainbow.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;

/**
 * @author zhenlei
 */
public class JinLogger {
    private static LinkedHashMap<Class, Logger> loggerMap = new LinkedHashMap();

    public static Logger getLogger(Class clz) {
        return LoggerFactory.getLogger(clz);
//        if (loggerMap.containsValue(clz)) {
//            return loggerMap.get(clz);
//        }else{
//            Logger logger = LoggerFactory.getLogger(clz);
//            loggerMap.put(clz, logger);
//            return logger;
//        }
    }
}
