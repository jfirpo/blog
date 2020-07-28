package hu.furediblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.furediblog.dao.model.Authors;

@Controller
public class AuthorController extends AbstractController {

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", blogService.getAuthors());
		return "authors";
	}

	@RequestMapping(path = "/authorDetails", method = RequestMethod.GET)
	public String authorDetails(int id, Model model) {
		model.addAttribute("auhorsStories", blogService.getEntryRepo().authorsEntries(id));
		model.addAttribute("author", blogService.getAuthorRepo().findById(id));
		return "authorDetails";
	}

	@RequestMapping(path = "/deleteAuthor", method = RequestMethod.GET)
	public String editAuthors(int id, Model model) {
		blogService.getAuthorRepo().remove(blogService.getAuthorRepo().findById(id));
		return authors(model);
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.POST)
	public String addAuthor(String name, Model model) {
		author.setName(name);
		blogService.getAuthorRepo().save(author);
		author = new Authors();
		return authors(model);
	}

	@RequestMapping(path = "/editAuthor", method = RequestMethod.POST)
	public String editAuthor(int id, String name, Model model) {
		author = blogService.getAuthorRepo().findById(id);
		author.setName(name);
		blogService.getAuthorRepo().update(author);
		model.addAttribute("authors", blogService.getAuthorRepo().selectAll());
		author = new Authors();
		return authors(model);
	}


}
