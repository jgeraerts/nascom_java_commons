package be.nascom.commons.services;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * Generic service interface providing standard CRUD functionality.
 * Original code by jgeraerts.
 * <p/>
 * Service methods are Transactional with Propagation.REQUIRED by default.
 * <p/>
 * <p/>
 * User: bart
 * Date: Apr 24, 2009
 * Time: 12:51:48 PM
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface GenericService<T, PK extends Serializable> {
    /**
     * Persist an object
     *
     * @param newInstance instance of the T type to be persisted.
     * @return PK a primary key of the PK type provided during object construction.
     */
    PK save(T newInstance);

    /**
     * Retrieve an object that was previously persisted using
     * the indicated id as primary key.
     *
     * @param id instance of the PK type by which to fetch our object of type T.
     * @return object of type T, identified by the provided id.
     */
    T get(PK id);

    /**
     * Save changes made to a persistent object.
     *
     * @param transientObject the object of type T to update.
     */
    void update(T transientObject);

    /**
     * Remove an object from persistent storage.
     *
     * @param persistentObject the object of type T to be deleted.
     */
    void delete(T persistentObject);

    /**
     * Get the collection of all persisted objects.
     *
     * @return Collection<T> of all persisted objects.
     */
    Collection<T> getAll();
}
