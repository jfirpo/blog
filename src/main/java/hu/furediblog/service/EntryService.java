package hu.furediblog.service;

import java.util.List;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;

public interface EntryService {
	public void addEntry(Entries entry);
	public void updateEntry(Entries entry);
	public List<Entries> listEntries();
	public Entries getEntryById(int id);
	public void removeEntry(int id);
	public void addEntry(Authors author, String content);	
}
