package hu.furediblog.dao;
import java.util.List;
import hu.furediblog.dao.model.BlogAuthor;
import hu.furediblog.dao.model.BlogEntry;

public interface AuthorDao {

	public void addAuthor(BlogAuthor author);
	public void updateAuthor(BlogAuthor author);
	public List<BlogAuthor> listAuthors();
	public BlogAuthor getAuthorById(int id);
	public void removeAuthor(int id);
	public List<BlogAuthor> listActiveAuthors();
	public List<BlogEntry> listauthorsEntries(BlogAuthor author);
}
