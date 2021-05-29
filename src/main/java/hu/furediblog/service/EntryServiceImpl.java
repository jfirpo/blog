package hu.furediblog.service;

import java.util.List;
import org.springframework.stereotype.Service;
import hu.furediblog.model.BlogAuthor;
import hu.furediblog.model.BlogEntry;
import hu.furediblog.model.dao.EntryDao;

@Service
public class EntryServiceImpl implements EntryService{
	
	private EntryDao entryDao;	
		
	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}
		
	public void addEntry(BlogEntry entry) {
		this.entryDao.addEntry(entry);		
	}

	public void updateEntry(BlogEntry entry) {
		this.entryDao.updateEntry(entry);		
	}

	public List<BlogEntry> listEntries() {		
		return this.entryDao.listEntries();
	}

	public BlogEntry getEntryById(int id) {
		return this.entryDao.getEntryById(id);
	}

	public void addEntry(BlogAuthor author, String content) {
		this.entryDao.addEntry(author, content);		
	}

	public List<BlogEntry> authorEntriesList(int author) {
		// TODO Auto-generated method stub
		return this.entryDao.listAuthorEntries(author);		
	}
	
//	public void removeEntry(int id) {
//	this.entryDao.removeEntry(id);
//	
//}	
}
