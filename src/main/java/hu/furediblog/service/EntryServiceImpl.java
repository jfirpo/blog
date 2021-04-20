package hu.furediblog.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import hu.furediblog.dao.EntryDao;
import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

public class EntryServiceImpl implements EntryService{
	
	private EntryDao entryDao;	
	
	@Autowired
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

	public void removeEntry(int id) {
		this.entryDao.removeEntry(id);
		
	}
	
	public void addEntry(BlogAuthor author, String content) {
		this.entryDao.addEntry(author, content);
		
	}

	public List<BlogEntry> authorEntriesList(int author) {
		// TODO Auto-generated method stub
		return this.entryDao.listAuthorEntries(author);
		
	}
}
