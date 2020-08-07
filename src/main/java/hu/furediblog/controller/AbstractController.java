package hu.furediblog.controller;

import org.springframework.beans.factory.annotation.Autowired;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;
import hu.furediblog.service.BlogService;

public abstract class AbstractController {
	BlogService blogService;
	Authors author = new Authors();
	Entries entry = new Entries();

	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
}
