package hu.furediblog.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hu.furediblog.dao.entity.*;

@Component
public class EntryRepository extends AbstractRepository {

	@SuppressWarnings("unchecked")
	public List<Entries> selectAll() {
        return getSession().createQuery("from Entries").list();
    }
	
	public Entries selectEntry(int id){
		List<Entries> entries = selectAll();
		Entries entry = new Entries();
		for (Entries entry1 : entries) { 	
			if (entry1.getId() == id)
				entry = entry1;
		}
		return entry;
	}
	
	public List<Entries> authorsEntries(int id){
		List<Entries> entries= new ArrayList<Entries>();
		for (Entries entry : selectAll()) {
			if (entry.getAuthor() == id)
				entries.add(entry);
		}
		return entries;
	}
	
    public void save(Entries entry) {
        getSession().beginTransaction();
        getSession().save(entry);
        getSession().getTransaction().commit();
    }

    public void update(Entries entry) {
        getSession().beginTransaction();
        getSession().update(entry);
        getSession().getTransaction().commit();
    }
    
    public void remove(Entries entry) {
        getSession().beginTransaction();
        getSession().delete(entry);
        getSession().getTransaction().commit();
    }

}
