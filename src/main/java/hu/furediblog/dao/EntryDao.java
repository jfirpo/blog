package hu.furediblog.dao;

import java.util.List;

import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

public interface EntryDao {

	public List<BlogEntry> listEntries();	
	public BlogEntry getEntryById(int id);
	public void addEntry(BlogEntry entry);
	public void updateEntry(BlogEntry entry);
	public void removeEntry(int id);

	public List<BlogEntry> listAuthorEntries(int author);
	public void addEntry(BlogAuthor  author, String content);
	
}
