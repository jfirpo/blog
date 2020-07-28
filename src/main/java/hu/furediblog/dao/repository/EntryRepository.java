package hu.furediblog.dao.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hu.furediblog.dao.model.*;


public class EntryRepository extends AbstractRepository<Entries> {

	@Override
    public Class<Entries> getManagedClass() {
        return Entries.class;
    }	
			
	public List<Entries> authorsEntries(int id){
		List<Entries> entries= new ArrayList<Entries>();
		for (Entries entry : selectAll()) {
			if (entry.getAuthor() == id)
				entries.add(entry);
		}
		return entries;
	}
}
