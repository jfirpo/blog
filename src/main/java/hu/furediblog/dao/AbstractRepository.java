package hu.furediblog.dao;
import java.util.List;

import org.hibernate.Session;


public abstract class AbstractRepository<T> {

	public abstract Class<T> getManagedClass();
	
	protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }

	
	
    @SuppressWarnings("unchecked")
	public List<T> selectAll() {
        return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
    }

    @SuppressWarnings("unchecked")
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