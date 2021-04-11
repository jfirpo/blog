package hu.furediblog.dao;

import java.util.List;

import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

public interface EntryDao {
	public void addEntry(BlogEntry entry);
	public void updateEntry(BlogEntry entry);
	public List<BlogEntry> listEntries();
	public List<BlogEntry> listAuthorEntries(int author);
	public BlogEntry getEntryById(int id);
	public void removeEntry(int id);
	public void addEntry(BlogAuthor  author, String content);
	
}
