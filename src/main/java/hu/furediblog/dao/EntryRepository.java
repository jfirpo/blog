package hu.furediblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import hu.furediblog.dao.model.*;

@Repository
public class EntryRepository implements EntryDao{

	protected Session getSession() {
        return DatabaseSessionProvider.getInstance().getSessionObj();
    }
	
    public Class<Entries> getManagedClass(){
        return Entries.class;
    }	
			
	public List<Entries> authorsEntries(int id){
		List<Entries> entries= new ArrayList<Entries>();
		for (Entries entry : listEntries()) {
			if (entry.getAuthor() == id)
				entries.add(entry);
		}
		return entries;
	}

	public void addEntry(Entries entry) {
	       getSession().beginTransaction();
	       getSession().save(entry);
	       getSession().getTransaction().commit();		

		
	}

	public void updateEntry(Entries entry) {
		 getSession().beginTransaction();
	     getSession().update(entry);
	     getSession().getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<Entries> listEntries() {		
		return getSession().createQuery("from " + getManagedClass().getSimpleName()).list();
	}

	public Entries getEntryById(int id) {
		return (Entries) getSession().get(Entries.class, id);
	}

	public void removeEntry(int id) {
        getSession().beginTransaction();
        getSession().delete(getEntryById(id));
        getSession().getTransaction().commit();				
	}

	public void addEntry(int id, String content) {
		 getSession().beginTransaction();
	     getSession().save(new Entries(id, content));
	     getSession().getTransaction().commit();
		
	}
}
