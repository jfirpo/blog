package hu.furediblog.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import hu.furediblog.dto.BlogAuthorDto;
import hu.furediblog.dto.BlogEntryDto;
import hu.furediblog.mapper.AuthorMapper;
import hu.furediblog.mapper.AuthorMapperImpl;
import hu.furediblog.mapper.EntryMapper;
import hu.furediblog.mapper.EntryMapperImpl;
import hu.furediblog.model.BlogEntry;
import hu.furediblog.model.dao.EntryDao;

@Service
public class EntryServiceImpl implements EntryService{
	
	private EntryDao entryDao;	
	EntryMapper entryMapper = new EntryMapperImpl();
	AuthorMapper authorMapper = new AuthorMapperImpl();
		
	public void setEntryDao(EntryDao entryDao) {
		this.entryDao = entryDao;
	}		

	public List<BlogEntryDto> authorsEntries(int author) {
		List<BlogEntryDto> authorEntries = new ArrayList<BlogEntryDto>();

		for (BlogEntry entry : this.entryDao.listAuthorEntries(author)) {
			authorEntries.add(entryMapper.map(entry));
		}		
		
		return authorEntries;		
	}
	public List<BlogEntryDto> listEntries() {
		List<BlogEntryDto> entries = new ArrayList<BlogEntryDto>();
		for (BlogEntry entry : this.entryDao.listEntries()) {
			entries.add(entryMapper.map(entry));
		}
		return entries;
	}
	
	public void updateEntry(BlogEntryDto entry) {
		this.entryDao.updateEntry(entryMapper.map(entry));		
	}

	public void addEntry(BlogEntryDto entry) {
		this.entryDao.addEntry(entryMapper.map(entry));		
	}
	public BlogEntryDto getEntryById(int id) {
		return entryMapper.map(this.entryDao.getEntryById(id));
	}

	public void addEntry(BlogAuthorDto author, String content) {
		this.entryDao.addEntry(authorMapper.map(author), content);		
	}

	/*
	public List<BlogEntryDto> authorsEntries(Authors author) {
		List<Entries> entries = this.authorDao.getAuthorById(author.getId()).getEntries();
		//foreach -> authorMapper.map(author) -> add to new list
		return entries; // mappelt lista
		
	}
	
	public List<BlogEntry> authorsEntries(BlogAuthor author) {
		return authorDao.listauthorsEntries(author);
	}
*/	
//	public void removeEntry(int id) {
//	this.entryDao.removeEntry(id);
//	
//}	
}
