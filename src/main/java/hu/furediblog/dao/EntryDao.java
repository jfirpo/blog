package hu.furediblog.dao;

import java.util.List;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;

public interface EntryDao {
	public void addEntry(Entries entry);
	public void updateEntry(Entries entry);
	public List<Entries> listEntries();
	public List<Entries> listAuthorEntries(int author);
	public Entries getEntryById(int id);
	public void removeEntry(int id);
	public void addEntry(Authors  author, String content);
	
}
