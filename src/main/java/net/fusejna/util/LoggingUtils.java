package net.fusejna.util;

import org.slf4j.Logger;

/**
 * Utility methods for logging.
 *
 * @author Alfonso Vásquez
 */
public class LoggingUtils {

    private LoggingUtils() {
    }

    public static void logMethodEnter(Logger logger, String methodName, Object... params) {
        if (logger.isDebugEnabled()) {
            StringBuilder msg = new StringBuilder("Entering method '");
            msg.append(methodName).append("'");

            if (params != null) {
                msg.append(" with params (");

                for (int i = 0; i < params.length; i++) {
                    if (i > 0) {
                        msg.append(", ");
                    }

                    msg.append(params[i]);
                }

                msg.append(")");
            }

            logger.debug(msg.toString());
        }
    }

    public static void logMethodExit(Logger logger, String methodName, Object result) {
        if (logger.isDebugEnabled()) {
            StringBuilder msg = new StringBuilder("Exiting method '");
            msg.append(methodName).append("'");

            if (result != null) {
                msg.append(". Result = ").append(result);
            }

            logger.debug(msg.toString());
        }
    }

    public static void logException(Logger logger, String methodName, Throwable ex) {
        logger.debug("Method '" + methodName + "' failed", ex);
    }

}
