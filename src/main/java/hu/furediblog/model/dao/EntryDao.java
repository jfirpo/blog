package hu.furediblog.model.dao;

import java.util.List;


import hu.furediblog.model.BlogAuthor;
import hu.furediblog.model.BlogEntry;


public interface EntryDao {

	public List<BlogEntry> listEntries();	
	public BlogEntry getEntryById(int id);
	public void addEntry(BlogEntry entry);
	public void updateEntry(BlogEntry entry);
	public List<BlogEntry> listAuthorEntries(int author);
	public void addEntry(BlogAuthor  author, String content);
	
}
