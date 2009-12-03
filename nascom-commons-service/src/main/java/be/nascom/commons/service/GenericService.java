package be.nascom.commons.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import be.nascom.commons.dao.ObjectNotFoundException;

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
     * counts the number of objects of this type T
     *
     * @return number of returned rows
     */

    Integer countAll();

    /**
     * Get the collection of all persisted objects.
     *
     * @return Collection<T> of all persisted objects.
     */
    List<T> getAll();


    /**
     * Get the collection of all persisted objects.
     *
     * @param first   first row of data
     * @param count   minimum number of elements to retrieve 
     * @return Collection<T> of all persisted objects.
     */
    List<T> getAll(int first, int count);


    /**
     * get the count of all persisted objects
     *
     * @param example example object
     * @return Long row number
     */
    Integer countByExample(T example);

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
     * @param example  the example uses in the query.
     * @param first   first row of data
     * @param count   minimum number of elements to retrieve
     * @return Collection<T> of all persisted objects similar to the example.
     */
    @Transactional(readOnly = true)
    List<T> findByExample(T example, int first, int count);
}
