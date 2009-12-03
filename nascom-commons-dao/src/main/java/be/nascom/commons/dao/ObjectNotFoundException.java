package be.nascom.commons.dao;

import java.io.Serializable;

/**
 * User: jgeraerts
 * Date: Dec 3, 2009
 * Time: 2:18:12 PM
 */
public class ObjectNotFoundException extends RuntimeException {
    private Class clazz;
    private Object id;

    public ObjectNotFoundException(Class clazz, Object id) {
        super("cannot load persistent class of type " + clazz.getName() + "with id " + id.toString());
        this.clazz = clazz;
        this.id= id;
    }


}
