package be.nascom.commons.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

import be.nascom.commons.dao.GenericDao;
import be.nascom.commons.dao.ObjectNotFoundException;

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
        T instance =notNullOrObjectNotFoundException((T) sessionFactory.getCurrentSession().get(type, id),id);

        return instance; 
    }

    protected T notNullOrObjectNotFoundException(T t, PK id) {
        if(t==null){
            throw new ObjectNotFoundException(type,id);
        }
        return t;
    }

    protected T notNullOrObjectNotFoundException(T t) {
        if(t==null){
            throw new ObjectNotFoundException(type);
        }
        return t;
    }

    public static <A> A notNullOrObjectNotFound(Object a){
        if(a==null){
            throw new ObjectNotFoundException();
        }
        return (A)a;
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
    public List<T> getAll(int first, int count) {
        //noinspection unchecked
         return (List<T>) createCriteria()
                 .setFirstResult(first)
                 .setMaxResults(count)
                 .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                 .list();
    }

    private Criteria createCriteria() {
        return sessionFactory
                 .getCurrentSession()
                 .createCriteria(type);
    }

    @Override
    public List<T> findByExample(T example) {
        //noinspection unchecked
        return sessionFactory.getCurrentSession().createCriteria(type).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).add(Example.create(example)).list();
    }

    @Override
    public List<T> findByExample(T example, int first, int count) {
        //noinspection unchecked
        return createCriteria(example)
                .setFirstResult(first)
                .setMaxResults(count)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();
    }

    private Criteria createCriteria(T example) {
        return createCriteria()
              .add(Example.create(example));
    }

    @Override
    public Integer countAll() {
        return (Integer) createCriteria()
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    @Override
    public Integer countByExample(T example) {
        return (Integer) createCriteria(example)
                .setProjection(Projections.rowCount())
                .uniqueResult();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
