package hu.furediblog.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import hu.furediblog.dao.EntryDao;
import hu.furediblog.dao.model.Authors;
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
	
	public void addEntry(Authors author, String content) {
		this.entryDao.addEntry(author, content);
		
	}
}
