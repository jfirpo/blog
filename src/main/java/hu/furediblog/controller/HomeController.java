package hu.furediblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hu.furediblog.dao.entity.Authors;
import hu.furediblog.dao.entity.Entries;
import hu.furediblog.dao.repository.AuthorRepository;
import hu.furediblog.dao.repository.EntryRepository;
import hu.furediblog.service.BlogService;

@Controller
public class HomeController {

	AuthorRepository authorRepo = new AuthorRepository();
	EntryRepository entryRepo = new EntryRepository();
	
	BlogService blogService;
	
	
	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	Authors author = new Authors();
	Entries entry = new Entries();

	@RequestMapping(path = "/stories", method = RequestMethod.GET)
	public String getStories(Model model) {
		model.addAttribute("entries", blogService.getEntries());
		return "stories";
	}

	@RequestMapping(path = "/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", blogService.getAuthors());
		return "authors";
	}

	@RequestMapping(path = "/authorDetails", method = RequestMethod.GET)
	public String authorDetails(int id, Model model) {
		model.addAttribute("auhorsStories", entryRepo.authorsEntries(id));
		model.addAttribute("author", authorRepo.selectAuthor(id));
		return "authorDetails";
	}

	@RequestMapping(path = "/deleteAuthor", method = RequestMethod.GET)
	public String editAuthors(int id, Model model) {
		author = authorRepo.selectAuthor(id);
		authorRepo.remove(author);
		author = new Authors();
		return authors(model);
	}

	@RequestMapping(path = "/addAuthor", method = RequestMethod.POST)
	public String addAuthor(String name, Model model) {
		author.setName(name);
		authorRepo.save(author);
		author = new Authors();
		return authors(model);
	}

	@RequestMapping(path = "/editAuthor", method = RequestMethod.POST)
	public String editAuthor(int id, String name, Model model) {
		author = authorRepo.selectAuthor(id);
		author.setName(name);
		authorRepo.update(author);
		model.addAttribute("authors", authorRepo.selectAll());
		author = new Authors();
		return authors(model);
	}

	@RequestMapping(path = "/addEntryBox", method = RequestMethod.GET)
	public String addEntryBox(int id, Model model) {
		author = authorRepo.selectAuthor(id);
		model.addAttribute("author", author);
		return addstory(model);
	}

	@RequestMapping(path = "/addEntryToDb", method = RequestMethod.POST)
	public String addEntryToDb(int id, String content, Model model) {
		author = new Authors();

		entry.setAuthor(id);
		entry.setContent(content);
		entryRepo.save(entry);
		author = new Authors();
		entry = new Entries();
		return getStories(model);
	}

	@RequestMapping(path = "/addstory", method = RequestMethod.GET)
	public String addstory(Model model) {
		model.addAttribute("author", author);
		return "addstory";
	}

}
