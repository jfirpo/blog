package hu.furediblog.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import hu.furediblog.model.BlogAuthor;

@Repository
public class AuthorDaoImpl implements AuthorDao {
		
	private SessionFactory sessionFactory;
		
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//@Override
	public void addAuthor(BlogAuthor blogAuthor) {
		Session session = this.sessionFactory.openSession();		
		Transaction tx = session.beginTransaction();
		session.persist(blogAuthor);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<BlogAuthor> listAuthors() {		

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<BlogAuthor> blogAuthorList = session.createQuery("from BlogAuthor").list();
		tx.commit();
		session.close();
		return blogAuthorList;
	}	

	public BlogAuthor getAuthorById(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BlogAuthor blogAuthor = (BlogAuthor) session.get(BlogAuthor.class, id);
		tx.commit();
		session.close();
		return blogAuthor;
	}	
    
	public void updateAuthor(BlogAuthor blogAuthor) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blogAuthor);
		tx.commit();
		session.close();
	}    	
	
	public List<BlogAuthor> listActiveAuthors() {
		List<BlogAuthor> authors = new ArrayList<BlogAuthor>();
		for(BlogAuthor author : listAuthors()) {
			if (!author.getName().contains("deleted author"))
				authors.add(author);
		}
		return authors;
	}
}
