package be.nascom.commons.spring.jmx;

import org.apache.log4j.LogManager;
import org.apache.log4j.Level;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 3:32:45 PM
 */
public class Log4jMbean {
    public void activateInfo(String category) {
          LogManager.getLogger(category).setLevel(Level.INFO);
      }

      public void activateDebug(String category) {
          LogManager.getLogger(category).setLevel(Level.DEBUG);
      }

      public void activateWarn(String category) {
          LogManager.getLogger(category).setLevel(Level.WARN);
      }

      public void activateError(String category) {
          LogManager.getLogger(category).setLevel(Level.ERROR);
      }

      public void activateFatal(String category) {
          LogManager.getLogger(category).setLevel(Level.FATAL);
      }
    

}
