package hu.furediblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hu.furediblog.dao.entity.Authors;
import hu.furediblog.dao.entity.Entries;
import hu.furediblog.dao.repository.AuthorRepository;
import hu.furediblog.dao.repository.EntryRepository;

@Component
@Service
public class BlogService {
	private AuthorRepository authorRepo;
	private EntryRepository entryRepo;

	@Autowired
	public void setAuthorRepo(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}

	@Autowired
	public void setEntryRepo(EntryRepository entryRepo) {
		this.entryRepo = entryRepo;
	}

	public List<Entries> getEntries() {
		return entryRepo.selectAll();
	}

	public List<Authors> getAuthors() {
		return authorRepo.selectAll();
	}
	
}
