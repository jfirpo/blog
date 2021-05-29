package hu.furediblog.service;

import java.util.List;

import hu.furediblog.model.BlogAuthor;
import hu.furediblog.model.BlogEntry;

public interface EntryService {
	public void addEntry(BlogEntry entry);
	public void updateEntry(BlogEntry entry);
	public List<BlogEntry> listEntries();
	public List<BlogEntry> authorEntriesList(int author);
	public BlogEntry getEntryById(int id);
//	public void removeEntry(int id);
	public void addEntry(BlogAuthor author, String content);	
}
