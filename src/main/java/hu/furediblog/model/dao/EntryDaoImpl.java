package hu.furediblog.model.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import hu.furediblog.model.BlogAuthor;
import hu.furediblog.model.BlogEntry;

@Repository
public class EntryDaoImpl implements EntryDao{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	public void addEntry(BlogEntry blogEntry) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(blogEntry);
		tx.commit();
		session.close();
	}			
	
	public void updateEntry(BlogEntry blogEntry) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blogEntry);
		tx.commit();
		session.close();
	}    	

	@SuppressWarnings("unchecked")	
	public List<BlogEntry> listEntries() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<BlogEntry> blogEntryList = session.createQuery("from BlogEntry").list();
		tx.commit();
		for (BlogEntry entry : blogEntryList) {
			System.out.println(entry.getContent());
		}
		return blogEntryList;
	}	

	public BlogEntry getEntryById(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		BlogEntry blogEntry = (BlogEntry) session.get(BlogEntry.class, id);
		tx.commit();
		session.close();
		return blogEntry;
	}		


	public void addEntry(BlogAuthor author, String content) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(new BlogEntry(author, content));
		tx.commit();
		session.close();
	}		
	
	public List<BlogEntry> listAuthorEntries(int author) {
		List<BlogEntry> entryList = listEntries();
		List<BlogEntry> auhorEntryList = new ArrayList<BlogEntry>();
		for (BlogEntry entry : entryList){
			if (entry.getAuthor().getId() == author)
				auhorEntryList.add(entry);
		}
		return auhorEntryList;
	}
}
