package hu.furediblog.dao;
import java.util.List;
import hu.furediblog.dao.model.BlogAuthor;
//import hu.furediblog.dao.model.BlogEntry;

public interface AuthorDao {

	public List<BlogAuthor> listAuthors();
	public BlogAuthor getAuthorById(int id);
	public void addAuthor(BlogAuthor author);
	public void removeAuthor(int id);
	public void updateAuthor(BlogAuthor author);

	public List<BlogAuthor> listActiveAuthors();	//kiszedni vagy aktualizálni	
	//public List<BlogEntry> listauthorsEntries(BlogAuthor author);
}
