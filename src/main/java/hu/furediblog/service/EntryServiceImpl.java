package hu.furediblog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.furediblog.dao.EntryDao;
import hu.furediblog.dao.model.Entries;

public class EntryServiceImpl implements EntryService{
	
	private EntryDao entryDao;	
	
	@Autowired
	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}

	public void addEntry(Entries entry) {
		this.entryDao.addEntry(entry);
		
	}

	public void updateEntry(Entries entry) {
		this.entryDao.updateEntry(entry);
		
	}

	public List<Entries> listEntries() {		
		return this.entryDao.listEntries();
	}

	public Entries getEntryById(int id) {
		return this.entryDao.getEntryById(id);
	}

	public void removeEntry(int id) {
		this.entryDao.removeEntry(id);
		
	}
	
	public List<Entries> authorsEntries(int id){
		List<Entries> entries= new ArrayList<Entries>();
		for (Entries entry : listEntries()) {
			if (entry.getAuthor() == id)
				entries.add(entry);
		}
		return entries;
	}

	public void addEntry(int id, String content) {
		this.entryDao.addEntry(id, content);
		
	}

	
		
		

}
