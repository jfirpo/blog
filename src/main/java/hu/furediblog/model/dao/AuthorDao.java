package hu.furediblog.model.dao;
import java.util.List;

import hu.furediblog.model.BlogAuthor;

public interface AuthorDao {

	public List<BlogAuthor> listAuthors();
	public BlogAuthor getAuthorById(int id);
	public void addAuthor(BlogAuthor blogAuthor);
	public void updateAuthor(BlogAuthor author);
	public List<BlogAuthor> listActiveAuthors();	//kiszedni vagy aktualizálni	

	//public List<BlogEntry> listauthorsEntries(BlogAuthor author);
	//	public void removeAuthor(int id);
}