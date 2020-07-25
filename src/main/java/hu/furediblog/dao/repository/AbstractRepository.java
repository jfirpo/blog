package hu.furediblog.dao.repository;

import hu.furediblog.dao.db.*;
import hu.furediblog.dao.model.BlogEntity;
import hu.furediblog.dao.model.Entries;

import java.util.List;

import org.hibernate.Session;


public abstract class AbstractRepository<T extends BlogEntity> {

    protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }
    public abstract Class getManagedClass();

    public List<T> selectAll() {
        return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
    }

    public T findById(int id) {
        return (T) getSession().get(getManagedClass(), id);
    }

    public void save(T entity) {
        getSession().beginTransaction();
        getSession().save(entity);
        getSession().getTransaction().commit();
    }

    public void update(T entity) {
        getSession().beginTransaction();
        getSession().update(entity);
        getSession().getTransaction().commit();
    }

    public void remove(T entity) {
        getSession().beginTransaction();
        getSession().delete(entity);
        getSession().getTransaction().commit();
    }

}