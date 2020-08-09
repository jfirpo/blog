package hu.furediblog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.dao.model.Entries;
import hu.furediblog.service.AuthorService;
import hu.furediblog.service.EntryService;

@Controller
public class AuthorController{
	
	Authors author = new Authors();
	Entries entry = new Entries();
	
	
	AuthorService authorService;
	EntryService entryService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Autowired
	public void setEntryService(EntryService entryService) {
		this.entryService = entryService;
	}


	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", authorService.listActiveAuthors());
		return "authors";
	}

	@RequestMapping(path = "/authorDetails", method = RequestMethod.GET)
	public String authorDetails(int id, Model model) {
		model.addAttribute("auhorsStories", authorService.authorsEntries(authorService.getAuthorById(id)));
		model.addAttribute("author", authorService.getAuthorById(id));
		return "authorDetails";
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.POST)
	public String addAuthor(String name, Model model) {
		author.setName(name);
		authorService.addAuthor(author);
		author = new Authors();
		return authors(model);
	}

	@RequestMapping(path = "/editAuthor", method = RequestMethod.POST)
	public String editAuthor(int id, String name, Model model) {
		author = authorService.getAuthorById(id);
		author.setName(name);
		authorService.updateAuthor(author);				
		model.addAttribute("authors", authorService.listAuthors());
		author = new Authors();
		return authors(model);
	}
}
