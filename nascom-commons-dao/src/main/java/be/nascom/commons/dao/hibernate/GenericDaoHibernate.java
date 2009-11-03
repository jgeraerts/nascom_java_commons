package be.nascom.commons.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

import be.nascom.commons.dao.GenericDao;

/**
 * Hibernate based implementation of the GenericDao interface. Original code by jgeraerts.
 * <p/>
 * User: bart
 * Date: Apr 24, 2009
 * Time: 12:33:18 PM
 */
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> type;

    public GenericDaoHibernate(Class<T> type) {
        this.type = type;
    }

    @Override
    public PK save(T newInstance) {
        //noinspection unchecked
        return (PK) sessionFactory.getCurrentSession().save(newInstance);
    }

    @Override
    public T get(PK id) {
        //noinspection unchecked
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void update(T transientObject) {
        sessionFactory.getCurrentSession().update(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        sessionFactory.getCurrentSession().delete(persistentObject);
    }

    @Override
    public List<T> getAll() {
        //noinspection unchecked
        return sessionFactory.getCurrentSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    public List<T> findByExample(T example) {
        //noinspection unchecked
        return sessionFactory.getCurrentSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Example.create(example)).list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
