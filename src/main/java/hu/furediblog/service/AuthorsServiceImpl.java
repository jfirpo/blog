package hu.furediblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.furediblog.dao.AuthorDao;
import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

public class AuthorsServiceImpl implements AuthorService{
	private AuthorDao authorDao;
	
	@Autowired
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public void addAuthor(BlogAuthor author) {
		this.authorDao.addAuthor(author);		
	}

	public void updateAuthor(BlogAuthor author) {
		this.authorDao.updateAuthor(author);		
	}

	public List<BlogAuthor> listAuthors() {
		return this.authorDao.listAuthors();
	}

	public BlogAuthor getAuthorById(int id) {
		return this.authorDao.getAuthorById(id);
	}

	public void removeAuthor(int id) {
		this.authorDao.removeAuthor(id);		
	}
/*
	public List<BlogEntryDto> authorsEntries(Authors author) {
		List<Entries> entries = this.authorDao.getAuthorById(author.getId()).getEntries();
		//foreach -> authorMapper.map(author) -> add to new list
		return entries; // mappelt lista
		
	}
*/
	public List<BlogAuthor> listActiveAuthors() {	
		return this.authorDao.listActiveAuthors();
	}

	public List<BlogEntry> authorsEntries(BlogAuthor author) {
		return authorDao.listauthorsEntries(author);
	}
}
