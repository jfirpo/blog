package hu.furediblog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;
import hu.furediblog.service.AuthorService;
import hu.furediblog.service.BlogService;
import hu.furediblog.service.EntryService;

public abstract class AbstractController {
	Authors author = new Authors();
	Entries entry = new Entries();
	
	BlogService blogService;
	AuthorService authorService;
	EntryService entryService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@Autowired
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}


}


