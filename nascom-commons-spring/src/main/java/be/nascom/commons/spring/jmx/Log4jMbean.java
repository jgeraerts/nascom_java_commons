package be.nascom.commons.spring.jmx;

import org.apache.log4j.LogManager;
import org.apache.log4j.Level;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 3:32:45 PM
 */
public class Log4jMbean {

    public void setLevel(String category, String level){
        LogManager.getLogger(category).setLevel(Level.toLevel(level));
    }

    public String getLevel(String category){
        Level level = LogManager.getLogger(category).getLevel();
        if(level == null){
            return getRootLevel();
        }
        return level.toString();
    }

    public void setRootLevel(String level){
        LogManager.getRootLogger().setLevel(Level.toLevel(level));
    }

    public String getRootLevel(){
        return LogManager.getRootLogger().getLevel().toString();
    }

}
