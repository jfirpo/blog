package hu.furediblog.service;

import java.util.List;


import hu.furediblog.dao.model.Entries;

public interface EntryService {
	public void addEntry(Entries entry);
	public void updateEntry(Entries entry);
	public List<Entries> listEntries();
	public Entries getEntryById(int id);
	public void removeEntry(int id);
	public List<Entries> authorsEntries(int id);
	public void addEntry(int id, String content);	
}
