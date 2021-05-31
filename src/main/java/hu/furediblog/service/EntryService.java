package hu.furediblog.service;

import java.util.List;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.dto.BlogEntryDto;

public interface EntryService {
	public void addEntry(BlogEntryDto entry);
	public void updateEntry(BlogEntryDto entry);
	public List<BlogEntryDto> listEntries();
	public List<BlogEntryDto> authorsEntries(int author);
	public BlogEntryDto getEntryById(int id);
//	public void removeEntry(int id);
	public void addEntry(BlogAuthorDto author, String content);	
}
