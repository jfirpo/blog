package hu.furediblog.service;

import java.util.List;





import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;
import hu.furediblog.dao.repository.AuthorRepository;
import hu.furediblog.dao.repository.EntryRepository;


public class BlogService {
	private AuthorRepository authorRepo;
	private EntryRepository entryRepo;

	
	public void setAuthorRepo(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}

	
	public void setEntryRepo(EntryRepository entryRepo) {
		this.entryRepo = entryRepo;
	}		

	public AuthorRepository getAuthorRepo() {
		return authorRepo;
	}

	public EntryRepository getEntryRepo() {
		return entryRepo;
	}
	
	public List<Entries> getEntries() {
		return entryRepo.selectAll();
	}

	public List<Authors> getAuthors() {
		return authorRepo.selectAll();
	}		
}
