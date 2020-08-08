package hu.furediblog.service;

import java.util.List;

import hu.furediblog.dao.model.Authors;

public interface AuthorService {
	public void addAuthor(Authors author);
	public void updateAuthor(Authors author);
	public List<Authors> listAuthors();
	public Authors getAuthorById(int id);
	public void removeAuthor(int id);
}
