package be.nascom.commons.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Generic dao interface providing standard CRUD functionality.
 * Original code by jgeraerts.
 * <p/>
 * User: bart
 * Date: Apr 24, 2009
 * Time: 12:31:41 PM
 */
@Transactional(propagation = Propagation.REQUIRED)
public interface GenericDao<T, PK extends Serializable> {
    /**
     * Persist an object
     *
     * @param newInstance instance of the T type to be persisted.
     * @return PK a primary key of the PK type provided during object construction.
     */
    @Transactional(readOnly = false)
    PK save(T newInstance);

    /**
     * Retrieve an object that was previously persisted using
     * the indicated id as primary key.
     *
     * @param id instance of the PK type by which to fetch our object of type T.
     * @return object of type T, identified by the provided id.
     */
    @Transactional(readOnly = true)
    T get(PK id);

    /**
     * Save changes made to a persistent object.
     *
     * @param transientObject the object of type T to update.
     */
    @Transactional(readOnly = false)
    void update(T transientObject);

    /**
     * Remove an object from persistent storage.
     *
     * @param persistentObject the object of type T to be deleted.
     */
    @Transactional(readOnly = false)
    void delete(T persistentObject);

    /**
     * Get the collection of all persisted objects.
     *
     * @return Collection<T> of all persisted objects.
     */
    @Transactional(readOnly = true)
    List<T> getAll();

    /**
     * Get a collection of all persisted objects that match an example object.
     * <p/>
     * Be careful when feeding in an example, hibernate will ignore:
     * <ul>
     * <li>Version properties</li>
     * <li>identifiers</li>
     * <li>associated objects</li>
     * </ul>
     * <p/>
     * This is documented here: http://docs.jboss.org/hibernate/stable/core/reference/en/html_single/#querycriteria-examples
     *
     * @param example the example uses in the query.
     * @return Collection<T> of all persisted objects similar to the example.
     */
    @Transactional(readOnly = true)
    List<T> findByExample(T example);
}
