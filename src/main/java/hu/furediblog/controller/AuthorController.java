package hu.furediblog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.furediblog.dao.model.Authors;
import hu.furediblog.service.AuthorService;
import hu.furediblog.service.EntryService;


@Controller
public class AuthorController{
	
	AuthorService authorService;
	EntryService entriesService;
	
	@Autowired
	public void setEntriesService(EntryService entriesService) {
		this.entriesService = entriesService;
	}


	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}


	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", authorService.listActiveAuthors());
		return "authors";
	}

	//entries az entriesService-bol authorId alapjan - pipa
	@RequestMapping(path = "/authorDetails", method = RequestMethod.GET)
	public String authorDetails(int id, Model model) {
		model.addAttribute("auhorsStories", entriesService.authorEntriesList(id));
		model.addAttribute("author", authorService.getAuthorById(id));
		return "authorDetails";
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.POST)
	public ModelAndView addAuthor(String name, Model model) {
		Authors author= new Authors();
		author.setName(name);
		authorService.addAuthor(author);
		return new ModelAndView("redirect:/furediBlog/authors");
	}

	//redirect - pipa
	@RequestMapping(path = "/editAuthor", method = RequestMethod.POST)
	public ModelAndView editAuthor(int id, String name, Model model) {
		Authors author = new Authors();
		author = authorService.getAuthorById(id);
		author.setName(name);
		authorService.updateAuthor(author);				
		model.addAttribute("authors", authorService.listAuthors());
		return new ModelAndView("redirect:/furediBlog/authors");
	}
}
