package be.nascom.commons.services;

import be.nascom.commons.dao.GenericDao;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;

/**
 * Basic implementation of the GenericService interface.
 * <p/>
 * User: bart
 * Date: Apr 24, 2009
 * Time: 12:53:36 PM
 */
@Service
public class GenericServiceImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    protected GenericDao<T, PK> dao;

    /**
     * Provided to allow for easier testing code.
     */
    public GenericServiceImpl() {
    }

    /**
     * This should be the default constructor.
     *
     * @param dao the GenericDao to which persistence jobs will be delegated.
     */
    public GenericServiceImpl(GenericDao<T, PK> dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PK save(T newInstance) {
        return dao.save(newInstance);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(PK id) {
        return dao.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T transientObject) {
        dao.update(transientObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T persistentObject) {
        dao.delete(persistentObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<T> getAll() {
        return dao.getAll();
    }
}
