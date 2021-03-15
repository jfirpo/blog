package hu.furediblog.dao;
import java.util.List;
import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;

public interface AuthorDao {

	public void addAuthor(Authors author);
	public void updateAuthor(Authors author);
	public List<Authors> listAuthors();
	public Authors getAuthorById(int id);
	public void removeAuthor(int id);
	public List<Authors> listActiveAuthors();
	public List<Entries> listauthorsEntries(Authors author);
}
