package hu.furediblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.furediblog.dao.AuthorDao;
import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;

public class AuthorsServiceImpl implements AuthorService{
	private AuthorDao authorDao;
	
	@Autowired
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public void addAuthor(Authors author) {
		this.authorDao.addAuthor(author);		
	}

	public void updateAuthor(Authors author) {
		this.authorDao.updateAuthor(author);		
	}

	public List<Authors> listAuthors() {
		return this.authorDao.listAuthors();
	}

	public Authors getAuthorById(int id) {
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
	public List<Authors> listActiveAuthors() {	
		return this.authorDao.listActiveAuthors();
	}

	public List<Entries> authorsEntries(Authors author) {
		return authorDao.listauthorsEntries(author);
	}
}
